package com.magneto.msmutantes.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magneto.msmutantes.dao.MutantesDao;
import com.magneto.msmutantes.dto.EstadisticaAdn;
import com.magneto.msmutantes.dto.Mutante;
import com.magneto.msmutantes.service.MutantesService;
import com.magneto.msmutantes.utils.CrearAdn;
import com.magneto.msmutantes.utils.ValidMutante;

@Service
public class MutanteServiceImpl implements MutantesService {

	
	@Autowired
	public ValidMutante validarMutante;
	
	@Autowired
	public CrearAdn crearAdn;
	
	@Autowired
	public MutantesDao mutantesDao;
	
	@Autowired 
	EstadisticaAdn estadisticaAdn;
	
	@Override
	public Mutante postMutante(Mutante mutante) {
		Mutante localMutante = new Mutante();
		List<String> error = new ArrayList<String>();
		List<Mutante> listMutantes = new ArrayList<Mutante>();
		boolean mutanteAlmacenado=false;
		String objMutant="";
		localMutante.setMutant(validarMutante.isMutant(mutante.getDna()));

		//Traemos todos los mutantes guardados
		listMutantes=mutantesDao.listarMutantes();
		System.out.println(listMutantes);
		//Validamos si un mutante ya esta almacenado
		if(listMutantes != null) {
			
			for(Mutante objMut:listMutantes) {
				if(objMut.getDnaObj().equals(mutante.getDna().toString())) {
					objMutant=objMut.getDnaObj();
					mutanteAlmacenado=true;
				}
			}
		}
		
		if(localMutante.isMutant() && !mutanteAlmacenado) {
			
			System.out.println("Es Mutante");
			localMutante.setDna(mutante.getDna());
			localMutante.setMutant(true);
			mutantesDao.postMutante(localMutante);
		}else {
			
			if(mutanteAlmacenado) {
				System.out.println("ya existe ADN de este mutante/persona");
				error.add("ya existe ADN de este mutante/persona ");
				error.add(objMutant);
				localMutante.setDna(error);
				//localMutante.setMutant(false);
			}else {
				System.out.println("No es Mutante");
				localMutante.setDna(mutante.getDna());
				localMutante.setMutant(false);
				mutantesDao.postMutante(localMutante);
			}
		}
		return localMutante;
	}

	@Override
	public EstadisticaAdn getEstadisticaMutantes() {
	
		float humanos = 0,mutantes = 0,ratio=0;
		List<Mutante> listMutantes = mutantesDao.listarMutantes();
		
		for(Mutante isMutant :listMutantes) {
			if(isMutant.isMutant()) {
				mutantes+=1;
			}else {
				humanos+=1;
			}
		}
		ratio=mutantes/humanos;
		estadisticaAdn.setHumanosAdn((int)humanos);
		estadisticaAdn.setMutantesAdn((int)mutantes);
		estadisticaAdn.setRatio(ratio);
		return estadisticaAdn;
	}
}

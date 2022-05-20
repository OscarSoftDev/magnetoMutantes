package com.magneto.msmutantes.dao;

import java.util.List;

import com.magneto.msmutantes.dto.Mutante;

public interface MutantesDao {
	
	Mutante postMutante(Mutante mutante);
	
	List<Mutante> listarMutantes();

}

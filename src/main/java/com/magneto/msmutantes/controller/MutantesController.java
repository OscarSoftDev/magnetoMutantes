package com.magneto.msmutantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magneto.msmutantes.dto.EstadisticaAdn;
import com.magneto.msmutantes.dto.Mutante;
import com.magneto.msmutantes.service.MutantesService;





@RestController
public class MutantesController {

	@Autowired
    private MutantesService mutantesService;
	
	@PostMapping("/mutant")
    public ResponseEntity<?> postMutante(@RequestBody Mutante mutante) throws Throwable    {
		ResponseEntity<?> response = null;
		try {
        	Mutante muta = mutantesService.postMutante(mutante);
            if(muta.isMutant()==true) {
            	response= new ResponseEntity<>(muta, HttpStatus.OK);
            }else {
            	response= new ResponseEntity<>(muta, HttpStatus.FORBIDDEN);
            }
            return response;
        } catch (Throwable ex) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
	@GetMapping("/stats")
	public ResponseEntity<?> estadisticaAdn(){
		try {
			EstadisticaAdn estadisticaAdn = mutantesService.getEstadisticaMutantes();
			
			return new ResponseEntity<>(estadisticaAdn, HttpStatus.OK);
			 
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
	
}

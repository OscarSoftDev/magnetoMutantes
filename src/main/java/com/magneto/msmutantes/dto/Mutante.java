package com.magneto.msmutantes.dto;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonInclude;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mutante {
	
	private int idMutante;
	
	private boolean mutant;
    
    private List<String> dna;
    
    private String dnaObj;

	public boolean isMutant() {
		return mutant;
	}

	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}

	public List<String> getDna() {
		return dna;
	}

	public void setDna(List<String> dna) {
		this.dna = dna;
	}
	
	public int getIdMutante() {
		return idMutante;
	}

	public void setIdMutante(int idMutante) {
		this.idMutante = idMutante;
	}

	
	public String getDnaObj() {
		return dnaObj;
	}

	public void setDnaObj(String dnaObj) {
		this.dnaObj = dnaObj;
	}

	@Override
	public String toString() {
		return "Mutante [idMutante=" + idMutante + ", mutant=" + mutant + ", dna=" + dna + ", dnaObj=" + dnaObj + "]";
	}

}

package com.magneto.msmutantes.dto;

import org.springframework.stereotype.Component;

@Component
public class EstadisticaAdn {

	private int humanosAdn;
	private int MutantesAdn;
	private float ratio;
	public int getHumanosAdn() {
		return humanosAdn;
	}
	public void setHumanosAdn(int humanosAdn) {
		this.humanosAdn = humanosAdn;
	}
	public int getMutantesAdn() {
		return MutantesAdn;
	}
	public void setMutantesAdn(int mutantesAdn) {
		MutantesAdn = mutantesAdn;
	}
	public float getRatio() {
		return ratio;
	}
	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	@Override
	public String toString() {
		return "EstadisticaAdn [humanosAdn=" + humanosAdn + ", MutantesAdn=" + MutantesAdn + ", ratio=" + ratio + "]";
	}
	
	
}

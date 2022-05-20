package com.magneto.msmutantes.service;

import java.util.List;

import com.magneto.msmutantes.dto.EstadisticaAdn;
import com.magneto.msmutantes.dto.Mutante;

public interface MutantesService {

	Mutante postMutante(Mutante mutante);

	EstadisticaAdn getEstadisticaMutantes();

}

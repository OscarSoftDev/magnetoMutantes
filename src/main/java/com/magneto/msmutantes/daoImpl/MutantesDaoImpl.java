package com.magneto.msmutantes.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.magneto.msmutantes.dao.MutantesDao;
import com.magneto.msmutantes.dto.Mutante;

@Repository
public class MutantesDaoImpl implements MutantesDao {

	@Autowired
	@Qualifier("JdbcTemplateAlianza")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;
	

	private static final String SQL_POST_MUTANT = "INSERT INTO alianza_mutante.mutante (adn_mutante,mutante) VALUES ( :adn_mutante , :mutante)";

	private static final String SQL_GET_MUTANTS ="select * from alianza_mutante.mutante";

	@Override
	public Mutante postMutante(Mutante mutante) {
		
		System.out.println(mutante);
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("adn_mutante", mutante.getDna().toString());
		map.addValue("mutante", mutante.isMutant());
		namedParameterJdbcTemplate.update(SQL_POST_MUTANT, map);
		return mutante;
	}

	@Override
	public List<Mutante> listarMutantes() {
        return namedParameterJdbcTemplate.query(SQL_GET_MUTANTS, new MapSqlParameterSource("id_mutante", 0), rs -> {
            List<Mutante> lista = null;
            if (rs.isBeforeFirst()) {
                lista = new ArrayList<>();
                Mutante item;
                while (rs.next()) {
                    item = new Mutante();
                    item.setIdMutante(rs.getInt("id_mutante"));
                    item.setDnaObj(rs.getString("adn_mutante"));
                    item.setMutant(rs.getBoolean("mutante"));
                    
                    lista.add(item);
                }
            }
            return lista;
        });
	}
}

package com.magneto.msmutantes.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class CrearAdn {
	
	static public List<String> newDna() {
        Random random = new Random(System.currentTimeMillis());
        // Producir nuevo int aleatorio entre 0 y 99
        
        List<String> adn = new ArrayList<String>();
        String[] dna = new String[random.nextInt(8) + 4];

        for (int i = 0; i < dna.length; i++) {
            dna[i] = "";
            for (int j = 0; j < dna.length; j++) {

                //crea letras (A,T,C,G)
                switch (random.nextInt(4)) {

                    case 0:
                        dna[i] += "A";
                        break;
                    case 1:
                        dna[i] += "T";
                        break;
                    case 2:
                        dna[i] += "C";
                        break;
                    case 3:
                        dna[i] += "G";
                        break;
                }

            }

        }
        for(String a:dna) {
        	adn.add(a);  
        }
        return adn;

    }

}

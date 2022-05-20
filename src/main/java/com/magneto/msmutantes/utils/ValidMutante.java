package com.magneto.msmutantes.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ValidMutante {
	 //Desde una posicion determinado por i,j toma 4 caracteres consecutivos en setindo horizontal, vertical, diagonal y diagonal invertido para verificar si son iguales
    static public boolean isMutant(List<String> list) {
        //Contabiliza total de combinaciones iguales
        int totalDna = 0;
        //Variable i recorre los string completos ej "ATAGC"
        for (int i = 0; i < list.size(); i++) {
            //j determina la posicion dentro del string
            for (int j = 0; j < list.get(i).length(); j++) {
                
                // Control Horizontal
                if (j < list.get(i).length() - 3) {
                    if (isEqual(list.get(i).charAt(j), list.get(i).charAt(j + 1), list.get(i).charAt(j + 2), list.get(i).charAt(j + 3))) {
                        totalDna++;
                    }
                }
                // Control Vertical
                if (i < list.size() - 3) {
                    // vertical check
                    if (isEqual(list.get(i).charAt(j), list.get(i+1).charAt(j), list.get(i+2).charAt(j), list.get(i+3).charAt(j))) {
                        totalDna++;
                    }
                }

                //Control Diagonal
                if (i < list.size() - 3 && j < list.get(i).length() - 3) {
                    if (isEqual(list.get(i).charAt(j), list.get(i+1).charAt(j + 1), list.get(i+2).charAt(j + 2), list.get(i+3).charAt(j + 3))) {
                        totalDna++;
                    }
                }

                //Control Diagonal Invertido
                if (i >= 3 && j < list.get(i).length() - 3) {
                    if (isEqual(list.get(i).charAt(j), list.get(i-1).charAt(j + 1), list.get(i-2).charAt(j + 2), list.get(i-3).charAt(j + 3))) {
                        totalDna++;
                    }
                }

                if (totalDna > 1) {
                    return true;
                }

            }

        }

        return false;
    }
    //Retorana verdadedos si todo los char son iguales
    public static boolean isEqual(char a, char b, char c, char d) {
        return a == b && b == c && c == d;
    }

}

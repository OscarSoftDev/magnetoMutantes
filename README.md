# magnetoMutantes
**Proyecto de reclutamiento de mutantes segun su ADN.**

"Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Men.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante
basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma (En
alguno de los siguiente lenguajes: ( Java / Python ):
boolean isMutant(String[] dna); // Ejemplo Java
En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.
Ejemplo (Caso mutante):
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
En este caso el llamado a la función isMutant(dna) devuelve “true”.
Desarrolla el algoritmo de la manera más eficiente posible.
"

Se crea proyecto con Springboot / JDBC / BD:Mysql   esquema:alianza_mutante  tabla: mutante

Creacion de tabla en my sql
CREATE TABLE `alianza_mutante`.`mutante` (
  `id_mutante` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `adn_mutante` varchar(100) DEFAULT NULL,
  `mutante` boolean DEFAULT NULL
) ;


Se realiza configuracion de base de datos en Aplicacion.yml

La clase DataSourceConfig dentro del paquete de config esta la configuracion para conexion.

Se crean 2 endpoints

POST → /mutant/
El cual valida si ya existe el registro, en caso de que no inserta la data.

GET → /stats
Genera un estado de cuantos humanos, mutantes y genera su ratio.


******Datos de prueba*****
El programa valida si el dna ya existe, en ese caso responde con un objeto y un mensaje indicando que ya se a insertado dicho registro,
En caso contrario inserta el valor.
De esta manera 
*-----------
*HUMANO!*|
*-----------
{
  "dna": [
    "ACCGGATAAT",
    "TGTTGTTTAC",
    "GGGCGAGACG",
    "ACGTCGGGCG",
    "TGCAATGTAT",
    "ATGGTTCGCA",
    "GTCCTTCTAT",
    "CAAACGGGAC",
    "CTGGCGGTAC",
    "TACGCCGGGA"
  ]
}
*-----------
*MUTANTE!*|
*-----------
{
  "dna": [
      "ATGCGA",
      "CAGTGC",
      "TTATGT",
      "AGAAGG",
      "CCCCTA",
      "TCACTG"
  ]
}
*-----------
*MUTANTE!*|
*-----------
{
  "dna": [
      "TTTTGA",
      "CAGTGC",
      "TTATGT",
      "AGAAGG",
      "CCCCTA",
      "TCACTG"
  ]
}
*-----------
*HUMANO!*|
*-----------
{
  "dna": [
      "TTATG",
      "CAGTG",
      "TTATG",
      "AGAAG",
      "CACCT"
  ]
}


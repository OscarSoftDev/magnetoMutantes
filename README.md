# magnetoMutantes
Proyecto de reclutamiento de mutantes segun su ADN.

Se crea proyecto con Springboot / JDBC / BD:Mysql
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


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
*-----------
*HUMANO!*|
*-----------
{
  "mutant": true,
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
  "mutant": true,
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
  "mutant": true,
  "dna": [
      "TTTTGA",
      "CAGTGC",
      "TTATGT",
      "AGAAGG",
      "CCCCTA",
      "TCACTG"
  ]
}


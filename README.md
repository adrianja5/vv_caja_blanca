# Práctica caja negra 
**GRUPO**: IWT-41 Grupo 5

## Instrucciones para la ejecución de la práctica.

1. Se deberá tener instalado Maven en el ordenador así como tener debidamente configuradas las variables de entorno[^1].
2. TODO
3. A través de la línea de comandos navegaremos hasta el directorio dónde se encuentra nuestro proyecto haciendo uso del comando `cd`, por ejemplo `cd vv_caja_blanca`
4. Una vez estemos dentro del directorio deseado deberemos ejecutar los siguientes comandos para ejecutar los test:
  >- 3.1- `mvn clean`
  >- 3.2- `mvn compile`
  >- 3.3- `mvn test`

Con Maven se pueden ejecutar las pruebas de los paquetes de Java por separado. Así, como se han usado dos paquetes distintos, se pueden ejecutar los comandos:
  - `mvn '-Dtest=com.practica.cajablanca.PruebasPrincipales.*Test' test` para realizar las pruebas de `PruebasPrincipales`.
  - `mvn '-Dtest=com.practica.cajablanca.OtrasPruebas.*Test' test` para realizar las pruebas de `OtrasPruebas`.

  
[^1]: Tutorial para instalar Maven en Windows 10: https://dev.to/vanessa_corredor/instalar-manualmente-maven-en-windows-10-50pb

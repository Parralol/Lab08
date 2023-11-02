# Lab08

## Realizado por Santiago Parra

### PARTE 1


Usando el mismo código del proyecto 7 (generar un repositorio nuevo), para hacer lo siguiente:

1) Subir el nuevo repositorio a GitHub
   
     > aqui podemos verlo

2) Configurar en github actions un **workflow** que contendrá 3 **jobs**, el primer **job** se llamará **build**, el segundo **test** y el tercero **deploy**, además, este workflow se disparará (events/trigger) **on: pull_request**, para esto puede usar como base [este tutorial](https://qaautomation.expert/2023/06/26/how-to-run-springboot-tests-with-github-actions/) o cualquier otro qué considere. Deberás hacer **steps** o **actions** sobre cada **job** para que se pueda obtener los siguiente:
   
- build: únicamente realizar hasta la fase *compile* de *maven*
  
- test: realizar la fase de *verify* y responder ¿se puede lograr que se ejecute sin necesidad de compilar el proyecto?, es prerrequisito de build para ser ejecutada
  
- deploy: por ahora deberá imprimir en consola "En construcción ..."

![image](https://github.com/Parralol/Lab08/assets/110953563/468e548c-095d-4f02-a26b-542aa75c808b)


3) Agregar los siguientes tests
- Dado que tengo 1 empleado registrado, Cuando lo consulto a nivel de servicio, Entonces la consulta será exitosa validando el campo id.
- Dado que no hay ningún empleado registrado, Cuándo lo consulto a nivel de servicio, Entonces la consulta no retornará ningún resultado.
- Dado que no hay ningún empleado registrado, Cuándo lo creo a nivel de servicio, Entonces la creación será exitosa.
- Dado que tengo 1 empleado registrado, Cuándo lo elimino a nivel de servicio, Entonces la eliminación será exitosa.
- Dado que tengo 1 empleado registrado, Cuándo lo elimino y consulto a nivel de servicio, Entonces el resultado de la consulta no retornará ningún resultado.

   > Ya se encuentran en el codigo
  
4) Verifica que la ejecución del **workflow** es exitosa, si no lo fuera, modifícalo hasta que ocurra

   ![image](https://github.com/Parralol/Lab08/assets/110953563/ef2f2203-bd48-40d5-b405-993d1b8c11a9)


### Desplegando en Azure usando CI/CD (Continous Deployment / Continous Delivery)

5) En Azure crea un servicio de App Service con recursos que facturen 0 dólares
   ![image](https://github.com/Parralol/Lab08/assets/110953563/ec3982bb-7d40-4488-a182-2e1ca39b83e2)

7) Configura el **job deploy** que creaste en el paso 2 y usando el *action* **azure/webapps-deploy@v2** despliega el *jar* generado a tu servicio de App Service
   
9) Verifica qué el endpoint de la aplicación generado en App Service
    
11) En este punto la aplicación no debería funcionar, ¿Donde puedes ver el mensaje de error de la aplicación o logs?, (probáblemente está fallando debido a que el puerto usado para despliegue no es el esperado (puerto 80), modifícalo en el **application.properties**)
    
8) En este punto la aplicación no debería funcionar totalmente debido a qué no hay una base de datos preparada, debes verificar esta situación a través de los logs, crea una base de datos MySQL con facturación de 0 dólares
   
10) Para utilizar la base de datos, configura los datos de conexión como una o varias variables de entorno tanto en App Service como en el archivo **application.properties** de tu proyecto
    
12) Prueba nuevamente la aplicación, ya debería estar funcionando! :fireworks: :champagne:



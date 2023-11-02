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
   ![image](https://github.com/Parralol/Lab08/assets/110953563/80b91734-b5c7-4a25-a621-35f05f980293)

9) Verifica qué el endpoint de la aplicación generado en App Service
      > si
    
11) En este punto la aplicación no debería funcionar, ¿Donde puedes ver el mensaje de error de la aplicación o logs?, (probáblemente está fallando debido a que el puerto usado para despliegue no es el esperado (puerto 80), modifícalo en el **application.properties**)
    ![image](https://github.com/Parralol/Lab08/assets/110953563/5c68f937-4895-4a83-9568-6b4d7cd8f53a)

8) En este punto la aplicación no debería funcionar totalmente debido a qué no hay una base de datos preparada, debes verificar esta situación a través de los logs, crea una base de datos MySQL con facturación de 0 dólares
   ![image](https://github.com/Parralol/Lab08/assets/110953563/0c069d7e-dacb-4c29-bf87-0ec6e93a6203)

10) Para utilizar la base de datos, configura los datos de conexión como una o varias variables de entorno tanto en App Service como en el archivo **application.properties** de tu proyecto

    
12) Prueba nuevamente la aplicación, ya debería estar funcionando! :fireworks: :champagne:
    > si funciona

## PARTE II. GRÁFICOS

### Generación de datos por procedimientos

Sobre el mismo proyecto del punto anterior:
1) Agrega dos nuevos campos, *empresa* y *sexo biológico* a la entidad *empleado* existente, esta nueva entidad también tendrá su propio modelo y repositorio.

2) Genera "proceduralmente" nuevos empleados, aleatoriamente serán entre 50 y 100. No se necesita crear ningún tipo de interfaz gráfica para poder llenarla, esta parte de la lógica pertenece al dominio de la capa de servicio.
Recuerde la estructura:
![image](https://github.com/PDSW-ECI/labs/assets/4140058/18de025e-cf76-4deb-9fc2-19c763e473d8)

3) Escoje entre algunas de las bibliotecas de gráficos en javascript y sustente su decisión, algunas que podría considerar son: [d3.js](https://d3js.org/), [c3.js](https://c3js.org/), [chart.js](https://www.chartjs.org/), [Google Charts](https://developers.google.com/chart), entre otras, para sustentar apoyese de instrumentos como las tabla T "pros y cons".

| Característica                | D3.js                           | C3.js                         | Chart.js                    | Google Charts              |
|-------------------------------|---------------------------------|-------------------------------|-----------------------------|-----------------------------|
| Curva de Aprendizaje          | Alta                            | Baja                          | Baja                        | Baja                        |
| Flexibilidad                  | Alta                            | Media                         | Baja                        | Media                       |
| Comunidad y Documentación     | Grande                          | Buena                         | Buena                       | Buena                       |
| Tipos de Gráficos Soportados   | Personalizables                 | Amplia gama                   | Gráficos comunes            | Amplia gama                 |
| Animaciones y Transiciones    | Soportadas                      | Soportadas                    | Soportadas                  | Soportadas                  |
| Interactividad                | Personalizable                  | Personalizable                | Básica                      | Básica                      |
| Personalización de Estilos    | Personalizable                  | Personalizable                | Limitada                    | Limitada                    |
| Requiere Conexión a Internet  | No                              | No                            | No                          | Sí (para cargar la librería) |
| Integración con Google        | No                              | No                            | No                          | Sí                          |

   > Se decide usar c3.js ya que, entre este y google poseen una buena flexibilidad, baja curva de aprendizaje, buena documentacion, una amplia gama de graficos y basicamente, sobresale en todo sobre los demas, ademas de NO requerir internet   

4) Realiza una página nueva en la estructura, esta página será la de "analítica" o "insights", en está página se podrá seleccionar entre las siguientes gráficas:
- Histograma de Salario
- Número de empleados por empresa
- Salario promedio por empresa
- Gastos en salario de las empresas registras en el sistema
- Persona por sexo en la base de datos
> Todas estas gráficas deberán ser debidamente rotuladas con su título, leyenda, etiquetas de ejes con sus unidades y tooltip sobre la serie de datos. Puede escoger entre gráficos de barras, líneas, pie, y sustente su elección.

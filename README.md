<h1>Proyecto de Reservaciones de mesa </h1>

<h2 align="center"> Objetivo </h2>
<span>
  En este proyecto podemos visualizar las clases orientadas a objetos en un lenguaje de programación JAVA, esta aplicación se está conectando a dos distintas bases de datos:
    <li>MongoDB</li>
    <li>PostGreSQl</li>
  A su vez estamos impplementando la publicación de servicios de tipo GET y POST para hacer uso de las llamadas hacia la BD.
  La arquitectura empleada es el diseño MVC con entities para el lado de PostGreSQL y del lado de documents para MongoDB.
  Se hizo también una implementación de unit testing, como la unidad especializada de realizar pruebas dentro del proyecto

  <h3>Como correr el poryecto</h3>
  Los pasos para correr este proyecto se descargan la última versión del proyecto, verificar que todo el proyecto pueda ser ejecutado y compilado, seguido de eso usted necesita
  escoger que forma de inserción necesita acceder:

  <h4>MongoDB</h4>
  En este caso tiene que ir a la carpeta de la estructura donda esta el servicio de MongoDB en todas esas clases y colocarles la palabra reservada @service para habilitar que todo
  lo que se vaya a realizar se ingrese en el apartado de MongoDB por ejemplo el siguiente:
  ![image](https://github.com/samdher/SpringBootReservationProject/assets/135747751/f77b1cfe-708a-4370-b819-b53c5a2c4236)

  <h4>PostGreSQL</h4>
  En el apartado de PostGreSQL de igual forma se hace todo los cambios necesarios para que agarre lo servicios de la estructura del mismo, y se le agrega la notación service
  a todo lo que esten la carpeta de PostGreSQL como se muestra a continuación:
  ![image](https://github.com/samdher/SpringBootReservationProject/assets/135747751/2ea00da8-5c3b-461a-9100-57ca7576ca3c)

  Para correr las pruebas Unitarias, usted deberá ir a la sección donde están las pruebas y ejecutar dichas pruebas para ver si las pruebas pasan o no pasan los parametros establecidos,
  para ello deberá ubicar la carpeta de pruebas y ejecutar una a una las unit testing, para ver el resultado de las mismas.

  <h3>Como Probar el proyecto</h3>
  Para poder probar el proyecto y su funcionamiento es necesario tener instalado postman y haber generado su token de auntenticación previamente generado para hacer uso de los distintos métodos que tienen tanta la reserva, como el mantinimiento de la mesa.

  <h4>Creación de Token para auntenticación</h4>
  En este caso se necesita usar el método para registrar un usuario dentro de la base de datos. <br>
  http://localhost:8080/api/v1/auth/register <br>
  con esto en el body <br>
  {
    "firstName":"test",
    "lastName": "testlastname",    
    "email": "ejemplotest01@gmail.com",
    "password": "Password123"    
} <br> <br> 
Seguido de esto se procede a iniciar sesión con la siguiente URL: <br>
http://localhost:8080/api/v1/auth/login <br>
con esto en el body: <br>
{
    "email":"ejemplotest01@gmail.com",
    "password": "Password123"
}<br>
<b>Cabe mencionar que el usuario tuvo que haberse cerado en el paso anterior, debido que si no estará mandando un mensaje de que el usuario no existe. </b> <br> <br>
Ya con el token que genera usted esta listo para hacer uso de los distintos métodos con el que consta la aplicación para su uso <br>

<br><br>
  <h4>Mantenimiento de Mesas</h4> <br>
  <li>Creación</li>
    Para crear una mesa es necesario utilizar este método en Postman: <br>
    http://localhost:8080/api/v1/tablebench <br>
    Con esto en el body: <br>
    {
      "noPersons":5,
      "ubication":"pergola",
      "isReserved":false
    }<br>
  Teniendo siempre un token tipo bearer.<br><br>

<li>Consulta</li>
    Para consultar una mesa es necesario utilizar este método en Postman: <br>
    <br>http://localhost:8080/api/v1/tablebench/id <br>
    Metodo: GET <br>
    En donde id es el número de mesa que se desea consultar teniendo como resultado el siguiente: <br>
    {
        "id": 2,
        "noPersons": 5,
        "ubication": "pergola",
        "isReserved": false
    }<br>
  Teniendo siempre un token tipo bearer.<br><br>

  
<li>Eliminar</li>
    Para eliminar una mesa es necesario utilizar este método en Postman: <br>
    <br>http://localhost:8080/api/v1/tablebench/id <br>
    Metodo: POST <br>
    Resultado: Ok cuando la mesa ha sido elminiada, o si el registro no fue encontrado muestra un mensaje de error. <br>
  Teniendo siempre un token tipo bearer.<br><br>

  
</span>

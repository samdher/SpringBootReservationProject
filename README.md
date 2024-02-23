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

</span>

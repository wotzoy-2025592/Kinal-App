# Kinal App

Proyecto hecho con SpringBoot para gestionar
el registro de usuarios, clientes, productos, 
ventas y detalles de la venta, llevando cada 
uno un CRUD funcional.

## Tecnologías utilizadas
* **Java 21**
* **SpringBoot 4.0.2**
* **Maven** (Gestor de dependencias)
* **MySQL** (Sistema Gestor de Base de Datos)

## Requisitos Previos
* JDK 17 o superior instalado
* Maven
* Instancia de MySQL abierta para revisar la base de datos
* Editor de archivos (Intellij o Visual Studio Code)

## Instalacion y Ejecución
Es importante saber que debes hacer para instalar y ejecutar el programa:
* Clonar el repositorio
* Ejecutar la aplicacion desde un editor de textos (Preferiblemente Intellij)

## Documentación
* Se ha creado la capa de entidad de Usuario, estando lista para crear las relaciones/cardinalidad
* Se ha creado la capa de repositorio de Usuario
* Se ha creado la capa de interfaz de servicio de Usuario
* Se ha creado la capa de servicio de Usuario
* Se ha creado la capa de controlador de Usuario
* La capa de servicio ya valida campos vacíos y la capa de interfaz de servicio ya tiene el metodo para encontrar por estado.
* El controlador de Usuario ya tiene listo los metodos de mapeo para poder realizar funciones del CRUD.


* Se cambio el tipo de variable en repository y service de la entidad Usuario, pasando de ser String a Long.


* Se ha creado la capa de entidad de Producto estando lista para crear la cardinalidad
* Se ha creado la capa repositorio de Producto
* Se ha creado la capa de interfaz de servicio de Producto
* Se ha creado la capa de servicio de Producto
* Se ha creado el controlador de Producto
* La capa de servicio y de interfaz funcionan correctamente, validando campos vacios y poder encontrar estado
* El controlador de Producto esta listo para poder realizar el testeo de los endpoints.


* Se ha creado la capa de entidad de Venta, ahora esta lista para crear la relación
* Se ha creado la capa de repositorio de Venta.
* Se ha creado la capa de interfaz de servicio de Venta.
* Se ha creado la capa de servicio de Venta.
* Se ha creado el controlador de Venta.
* Los métodos de verificación estan en service, se tiene ya los métodos HTTPS y métodos CRUD para verificar datos en los endpoints.


* Se ha creado la capa de entidad de Detalle Venta.
* Se ha creado la capa de repositorio de Detalle Venta.
* Se ha creado la capa de Interfaz de servicio de Detalle Venta.
* Se ha creato la capa de servicio de Detalle Venta
* Se ha creado el controlador de Detalle Venta.
* Los métodos de verificación están en DetalleVentaService y se tienen los métodos HTTPS y métodos CRUD para verificar los endpoints.


* Se agregaron las relaciones de cada entidad y sus cardinalidades, tambien se agregaron las foraneas de las 2 entidades que tenían. El modelo entidad relación
  esta exactamente como el ejemplo dado.


15/04/2026
* Se ha creado un archivo html en templates que contiene el menú principal
* Se ha creado un archivo en static-css para definir un estilo/colores a la página del menú principal (index.html).
* Se han agregado imagenes en static-img para mostrar iconos en el menú principal y mostrar el logo.
* Se ha creado un controlador de la vista del menú para poder ejecutar la vista.


## Solución de Errores

* Listar Cliente: Error 400 bad request
  Error solucionado al cambiar la entrada de estado en formato JSON, pasando de tener letras (String) a tener números (int).
* Agregar Usuario: Error 500 internal server error
  Error solucionado al quitar el "codigoUsuario" porque era un valor autoincrementable.
* 15/04/2026: Error 404 Not Found:
  Error solucionado al agregar las dependencias de thymeleaf al proyecto, haciendo que funcione el html.
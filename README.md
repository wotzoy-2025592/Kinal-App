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

## Solución de Errores
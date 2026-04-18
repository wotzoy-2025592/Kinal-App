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


* Gestión de vistas y navegación
* Se implementó correctamente la integración de Thymeleaf en todas las vistas HTML.
* Se corrigieron rutas relativas para evitar errores de carga de páginas.
* Se mejoró la navegación general permitiendo regresar al menú principal desde diferentes vistas.
* Se reorganizó la estructura del index.html para cargar correctamente todas las entidades.

* CRUD completo en vistas
* Se implementaron vistas completas para:
  * Usuario
  * Cliente
  * Producto
  * Venta
  * DetalleVenta
* Cada entidad cuenta con:
  * Vista de tabla (Manda a métodos CRUD)
  * Vista de formulario
* Se integraron validaciones en formularios para evitar datos nulos o inválidos.

* Controladores y lógica de negocio
* Se implementaron métodos HTTP completos (GET, POST, PUT, DELETE) en los controladores.
* Se corrigieron conflictos de rutas (@RequestMapping) entre controladores.
* Se mejoró el flujo de actualización usando claves primarias existentes.
* Se eliminaron valores por defecto forzados que afectaban la persistencia de datos.

* Se eliminó la lógica que asignaba automáticamente rol ADMIN desde el controlador.
* Se deshabilitó la opción de eliminar registros desde la interfaz:
* Ahora muestra un mensaje indicando que no está permitido.
* Se habilitó la opción de editar registros sin restricción de rol.
* Se mejoró la lógica de validación de acceso en las vistas.

* Se agrego la funcionalidad de búsqueda de usuarios por nombre.
* Se permite validar si un usuario existe antes de realizar operaciones.
* * Se crearon las vistas para Login y Register.
* Se intrego un estilo para las nuevas vistas y se reutilizaron antiguos diseños.

* Se agregaron getters y setters faltantes en entidades.
* Se eliminaron líneas innecesarias en múltiples clases.
* Se simplificaron estructuras en controladores y vistas. 
* Se eliminaron elementos HTML no funcionales en formularios (select). 
* Se mejoró la organización general del proyecto.


### - 17/04/2026
- Se logro completar el proyecto con login funcional, cerrado de sesión (redirigir al login), CRUD completo en backend,
 CRUD completo en frontend y estilos bonitos para cada vista, algunos reutilizados.
- Finalmente tambien se solucionaron errores que volvieron a aparecer, como mal mapeo de rutas o el
  mal uso de thymeleaf al momento de buscar por rutas/archivos/imgenes/links.
- Proyecto con una cantidad de commits moderada, en la parte de rama propia y la de pull request. 

## Solución de Errores

* Listar Cliente: Error 400 bad request
  Error solucionado al cambiar la entrada de estado en formato JSON, pasando de tener letras (String) a tener números (int).
* Agregar Usuario: Error 500 internal server error
  Error solucionado al quitar el "codigoUsuario" porque era un valor autoincrementable.
* 15/04/2026: Error 404 Not Found:
  Error solucionado al agregar las dependencias de thymeleaf al proyecto, haciendo que funcione el html.
* Mal uso de thymeleaf:
  Han habido errores 500 o 404 algunas veces porque no se paso bien la ruta/link para poder buscar el archivo html o
  hubo algo dentro del código como la base de datos, que causaba conflictos al momento de intentar
  acceder a la vista, como posibles campos nulos, nombres incorrectos de atributos o mal uso de la entidad (No tenía
  Getters o Setters para acceder a los atributos si esta era foranea).
# Gestión de Reservas - Sistema de Vuelos

Este proyecto es un sistema de gestión de reservas de vuelos, desarrollado en Java utilizando Spring Boot. El proyecto incluye funcionalidades para la búsqueda de vuelos, reservas, y otras operaciones relacionadas con la gestión de vuelos.

## Requisitos

### Software Necesario:
- **JDK 17**
- **Maven 3.6.3** o superior.
- **Base de datos SQL Server** (o cualquier base de datos compatible con JPA).

### Dependencias del Proyecto:
Las dependencias principales que el proyecto usa están definidas en el archivo `pom.xml`. Algunas importantes incluyen:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- SQL Server Driver para la conexión con bases de datos SQL Server
- Swagger para la documentación de API


## Configuración del Proyecto

### Clonar el Proyecto
Puedes clonar el repositorio desde el control de versiones (Git):
```bash
git clone https://github.com/Jerson-P/prueba-bigview-api.git
cd prueba-bigview-api
```
	

### Configurar la Base de Datos (SQL Server)

- El proyecto está configurado para utilizar SQL Server. 
- Debes actualizar las propiedades de conexión en el archivo **application.properties** los cuales son la url, username y password, deacuerdo a tu conexion.
- Ejemplo configuración del **spring.datasource.url**: **jdbc:sqlserver://<SERVIDOR>:<PUERTO>;databaseName=<NOMBRE_BASE_DE_DATOS>**

### Cambiar el Puero del Servidor

- El proyecto está configurado en el puerto 8087.
- Si deseas cambiarlo, puedes hacerlo en el archivo **application.properties**

## Ejecutar la Aplicación en Local

- Para ejecutar el proyecto en tu entorno local, asegúrate de tener configurada la base de datos y haber cambiado las propiedades en el archivo **application.properties**. Luego, puedes ejecutar el proyecto utilizando Maven.
1. Primero, asegúrate de haber instalado las dependencias necesarias ejecutando:
 `./mvnw clean install`
2. Luego, ejecuta la aplicación con el siguiente comando:
 `./mvnw spring-boot:run`
- Este comando iniciará el servidor en el puerto configurado (8087).

## Documentación de la API (Swagger)

Este proyecto utiliza Swagger para documentar la API REST. Puedes acceder a la documentación interactiva de la API una vez que la aplicación esté en ejecución accediendo a la siguiente URL:

`http://localhost:8080/swagger-ui.html`

Desde esta interfaz, puedes probar directamente los endpoints disponibles y consultar las especificaciones de cada uno de ellos.

## Compilación y Construcción

Para compilar y construir el proyecto, puedes usar el siguiente comando Maven:

`./mvnw clean install`

Esto generará un archivo .jar en el directorio target/, el cual puede ser utilizado para desplegar la aplicación en un entorno de producción.

### Ejecutar el .jar generado:

`java -jar target/gestionreservas-1.0.0.jar`

##Estructura del Proyecto

El proyecto sigue una estructura estándar de Spring Boot:

	```
	gestionreservas/
	├── src
	│   ├── main
	│   │   ├── java
	│   │   │   └── com.tuempresa.gestionreservas
	│   │   └── resources
	│   │       ├── application.properties
	│   │       └── static
	│   └── test
	├── pom.xml
	├── mvnw
	└── README.md```

- **src/main/java**: Contiene el código fuente de la aplicación.
- **src/main/resources**: Contiene los recursos de configuración (como el archivo application.properties).
- **pom.xml**: Archivo de configuración de Maven, donde se gestionan las dependencias.

## Contacto

Si tienes alguna pregunta o problema con el proyecto, por favor contacta a **jersons156@gmail.com**.


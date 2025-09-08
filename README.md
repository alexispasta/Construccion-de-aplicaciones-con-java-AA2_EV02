PROYECTO: JAVA_SGRH
Evidencia: GA7-220501096-AA2-EV02
Aprendiz: Alexis Gonzalez Sogamoso.

Repositorio del proyecto (GitHub):
[https://github.com/alexispasta/Construccion-de-aplicaciones-con-java-AA2_EV02]

Descripción del proyecto:
Este proyecto corresponde al módulo del sistema de información SGRH desarrollado en Java, con conexión a base de datos MySQL mediante JDBC. Se han implementado funcionalidades completas para la gestión de datos de todas las tablas del sistema, incluyendo:

- Inserción de registros
- Actualización de registros
- Eliminación de registros

El sistema utiliza un modelo basado en clases `modelo`, `dao` y `conexion`, estructurado de manera modular.

Paquetes:
- `modelo`: contiene las clases que representan las entidades (Empresa, Persona, Empleado, etc.).
- `dao`: contiene las clases que permiten interactuar con la base de datos.
- `conexion`: contiene la clase `ConexionBD` para conectar con MySQL.

Herramientas utilizadas:
- Java 17+
- MySQL
- JDBC
- Visual Studio Code
- MySQL Workbench (para el modelado y pruebas de base de datos)

Pruebas:
En el archivo `App.java` se realizan pruebas de inserción, actualización y eliminación para validar el correcto funcionamiento de los métodos DAO.

Instrucciones básicas para ejecución:
1. Asegurarse de tener de conetar la base de datos "sgrh".
2. Compilar los archivos `intro-servlets.war` en tomcat.
3. ingresar al link del login http://localhost:8080/intro-servlets/login.html

Observaciones:
El proyecto fue construido siguiendo las buenas prácticas de codificación y con base en los artefactos del ciclo de vida del software desarrollados en evidencias anteriores (diagramas de clases, casos de uso y prototipos).
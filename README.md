# Conversor de Monedas

Aplicación de escritorio para convertir una cantidad entre distintas monedas. Obtiene las tasas de cambio actuales mediante ExchangeRate-API y permite guardar y consultar un historial de conversiones asociado a una dirección de correo electrónico.

## Funcionalidades

- Selección de moneda de origen y moneda de destino.
- Conversión de una cantidad utilizando las tasas recibidas de la API.
- Validación básica del correo electrónico y de la cantidad ingresada.
- Guardado de conversiones en una base de datos MySQL cuando se proporciona un correo válido.
- Consulta del historial de conversiones por correo electrónico.

## Tecnologías

- **Java 22** como lenguaje y versión de compilación configurada.
- **Java Swing** para la interfaz gráfica de escritorio.
- **Maven** para la gestión del proyecto y sus dependencias.
- **Java HttpClient** para realizar solicitudes HTTP a ExchangeRate-API.
- **Gson 2.11.0** para interpretar la respuesta JSON de la API.
- **MySQL** para almacenar el historial, con conexión JDBC mediante MySQL Connector/J.
- El archivo `pom.xml` también declara dependencias de **Hibernate/JPA** e **iText**.

## Requisitos

- JDK 22.
- Maven.
- Una instancia de MySQL con la tabla `historial_de_conversiones` configurada.
- Acceso a Internet y una clave válida para ExchangeRate-API.

## Ejecución

1. Clona el repositorio y abre el proyecto `AppConversorM` en un IDE compatible con Maven, como IntelliJ IDEA.
2. Configura la conexión a MySQL en `src/main/java/org/rer/conexionBD.java` y verifica que exista la tabla requerida para el historial.
3. Configura tu clave de ExchangeRate-API en `src/main/java/org/rer/servicioConversion.java`.
4. Recarga las dependencias de Maven y ejecuta la clase `org.rer.MenuConversor`.

> **Importante:** configura las credenciales de la base de datos y la clave de la API localmente. No publiques contraseñas ni claves privadas en el repositorio; lo recomendable es leerlas desde variables de entorno.

## Uso

Al iniciar la aplicación, ingresa una cantidad, selecciona las monedas de origen y destino y pulsa **Convertir**. Para guardar la operación en el historial, proporciona un correo válido. Puedes consultar operaciones previas ingresando ese correo en la sección **Historial**.

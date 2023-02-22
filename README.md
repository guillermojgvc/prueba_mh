PRUEBA TÉCNICA BACKEND ENGINEER

La prueba consta de 3 preguntas que se han resuelto de la siguiente forma:

============================================================================
# Pre Requisitos: 
    -- CON DOCKER DESARROLLO --
    > Para mayor facilidad del evaluador el proyecto incluye los archivos de creación del ambiente de 
    base de datos en docker "docker-compose.yml"
    > Levantar la base de datos con el comando (De forma automática se crearan las bases de datos myhotel-vehiculo y myhotel-test, a su vez se restauraran los datos de entrada iniciales)
        %> docker-compose up
    
    -- SIN DOCKER --
    > En caso de que el evaluador considere realizar las pruebas en ambiente local deberá crear las bases de datos
    myhotel-vehiculo y myhotel-test y ejecutar los scripts de la carpeta "database/init" en el siguiente orden:
        * 01 create_database.sql
        * 02 myhotel-vehiculo.sql
        * 03 myhotel-test.sql
============================================================================

# Pregunta 1 SPRINGBOOT: 
    Carpeta "vehiculos", aplicación Springboot para la administración de vehículos

    > Importar el proyecto en SpringToolSuite4 (proyecto Maven)
    > Realizar el cambio del archivo resources en la ubicación 
        vehiculos/src/main/resources/application.properties
        Ajustar los valores de la conexión como host, puerto, usuario y password (El archivo ya cuenta con la configuración del ambiente docker de desarrollo)
    > La aplicación cuenta por defecto con un sandbox de pruebas para los endpoints generado con Swagger que puede ser accedido de forma local en la siguiente URL:
        - http://localhost:8082/swagger-ui/index.html#/
    
    # El API desarrollado cuenta con información de los catálogos tipos y categorias
    # Para crear un nuevo vehículo hay que considerar la siguiente estructura de payload para la consulta:
        - Automovil
        {
            "marca": "string",
            "modelo": "string",
            "patente": "string",
            "anio": 2000,
            "kilometraje": 0,
            "cilindrada": 0,
            "idTipo": 0,
            "numeroPuertas": 0,
            "capacidadPasajeros": 0,
            "capacidadMaletero": 0,
        }
        - Camion
        {
            "marca": "string",
            "modelo": "string",
            "patente": "string",
            "anio": 2000,
            "kilometraje": 0,
            "cilindrada": 0,
            "idTipo": 0,
            "capacidadToneladas": 0,
            "cantidadEjes": 0
        }
    # Para el ingreso de información se realiza la validación del tipo de vehículo, tamaños máximos en los campos y validaciones de valores no negativos para información de kilometraje, cilindraje, año
    # Los endpoint cuentan con un manejador de excepciones para mostrar las alertas de forma más amigable
    # Los endpoints devuelven los siguientes estados: 200-OK, 204-Sin Contenido, 400-Bad Request
    
------------------------------------------------------------------------
# Pregunta 2 SQL: 
    Consultas de dump mysql, las consultas a base de datos se encuentran disponibles en la ubicación 
    * database/querys/ejercicio2.sql

# Pregunta 3 SPRINGBOOT: 
    Carpeta "prueba", aplicación Springboot api consultas de dump mysql

    > Importar el proyecto en SpringToolSuite4 (proyecto Maven)
    > Realizar el cambio del archivo resources en la ubicación 
        prueba/src/main/resources/application.properties
        Ajustar los valores de la conexión como host, puerto, usuario y password (El archivo ya cuenta con la configuración del ambiente docker de desarrollo)
    > La aplicación cuenta por defecto con un sandbox de pruebas para los endpoints generado con Swagger que puede ser accedido de forma local en la siguiente URL:
        - http://localhost:8081/swagger-ui/index.html#/
    
    # El API desarrollado muestra las consultas realizadas en el paso 2 implementadas a razón de API Rest
    # Los endpoints devuelven los siguientes estados: 200-OK, 204-Sin Contenido, 400-Bad Request
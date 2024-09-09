Proyecto Microservicios ClientePersona y CuentaMovimiento

Este proyecto contiene dos microservicios separados que se encargan de gestionar la información de clientes y cuentas, así como sus movimientos financieros. La comunicación entre estos microservicios se realiza de forma asíncrona utilizando RabbitMQ.

Contenido del Repositorio
clientePersona-service: Microservicio para la gestión de clientes y personas.
cuentaMovimiento-service: Microservicio para la gestión de cuentas y movimientos financieros.
EjercicioClienteCuenta.postman_collection.json: Colección de Postman con los endpoints para verificar los microservicios.
docker-compose.yml: Archivo docker-compose que configura ambos microservicios y RabbitMQ.
personaCliente.sql: Script SQL para la base de datos de clientes y personas.
cuentaMovimiento.sql: Script SQL para la base de datos de cuentas y movimientos.
Requisitos
Docker y Docker Compose: Para ejecutar los contenedores de los microservicios y RabbitMQ.
PostgreSQL: Para gestionar las bases de datos.
pgAdmin o similar: Para ejecutar los scripts SQL.
Instrucciones de Despliegue
1. Configuración de Bases de Datos
Crear las bases de datos necesarias en PostgreSQL:
Base de datos para clientes y personas.
Base de datos para cuentas y movimientos financieros.
Ejecutar los scripts SQL proporcionados en este repositorio:
personaCliente.sql para crear las tablas de clientes y personas.
cuentaMovimiento.sql para crear las tablas de cuentas y movimientos financieros.

Instrucciones de Despliegue
1. Configuración de Bases de Datos
Crear las bases de datos necesarias en PostgreSQL:
Base de datos para clientes y personas <persona_cliente_db>.
Base de datos para cuentas y movimientos financieros<cuenta_movimiento_db>.
Ejecutar los scripts SQL proporcionados en este repositorio:
personaCliente.sql para crear las tablas de clientes y personas.
cuentaMovimiento.sql para crear las tablas de cuentas y movimientos financieros.

Las tablas tambien se generan de forma automatica al momento de ejecutar los microservicios.

3. Ejecución del Proyecto
Para desplegar los microservicios y RabbitMQ en contenedores Docker:

Clona el repositorio:

bash
Copy code
https://github.com/serdna123/clienteCuentaMovimientoEjercicio.git
cd tu-repositorio
Asegúrate de tener Docker y Docker Compose instalados.

Ejecuta Docker Compose para levantar ambos microservicios:

bash
Copy code
docker-compose up --build
3. Verificación de los Endpoints
Una vez que los contenedores estén corriendo, puedes verificar los endpoints usando Postman.

Importa la colección de Postman:
Importa el archivo EjercicioClienteCuenta.postman_collection.json en Postman.
Verifica los endpoints disponibles en la colección.
4. Configuración de los Servicios
clientePersona-service:

Puerto: 8081
Base de datos: personaCliente
URL base: http://localhost:8081/api/...


cuentaMovimiento-service:

Puerto: 8080
Base de datos: cuentaMovimiento
URL base: http://localhost:8080/api/...
5. RabbitMQ
El archivo docker-compose.yml configurará RabbitMQ como broker de mensajes para la comunicación entre los microservicios.
Puedes acceder a la interfaz de RabbitMQ en http://localhost:15672/ con las credenciales predeterminadas (guest/guest).

Docker Hub
docker pull serdna1230/cuentamovimiento-service
docker pull serdna1230/clientepersona-service

# Sistema de Ventas

Este proyecto es una aplicación de un sistema de ventas desarrollada siguiendo el patrón de diseño de Microservicios. La arquitectura está dividida en tres microservicios principales:

### **Microservicios**

1. **Productos:**
   - Almacena todos los productos en su base de datos.
   - Cada producto tiene un identificador único (`id`), nombre, precio y marca.

2. **Carrito:**
   - Se comunica con el servicio de Productos para obtener el precio total de los productos agregados al carrito mediante sus identificadores (`id`).
   - Gestiona la lógica del carrito de compras.

3. **Venta:**
   - Registra cada venta con una fecha y un carrito de compra asociado.
   - Almacena los detalles de cada transacción realizada.

### **Inicio Rápido**

Para poner en marcha el proyecto, sigue estos pasos:

1. **Clona el repositorio:**
   ```sh
   git clone [https://github.com/mativ707/Proyecto-sistema-de-ventas]
2. **Crea las bases de datos:**
- Configura las bases de datos locales necesarias para cada microservicio (Productos, Carrito, Venta).
  
3. **Configura los archivos application.properties:**
- Asegúrate de que cada microservicio tenga su archivo application.properties correctamente configurado con los detalles de conexión a las bases de datos locales.
  
4. **Ejecuta los microservicios:**
- Importa cada microservicio en tu IDE de preferencia (por ejemplo, IntelliJ IDEA, Eclipse).
- Ejecuta cada microservicio de forma independiente.

**Tecnologías Utilizadas**
- Java
- Spring Boot
- MySQL (o cualquier otra base de datos que prefieras)
- Eureka (para el descubrimiento de servicios)
- Feign (para la comunicación entre microservicios)
- Docker (opcional, para la contenedorización)

## Autor

LinkedIn : [Matias Velazquez](https://www.linkedin.com/in/mativ707)


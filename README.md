# Sistema de Ventas

Este proyecto es una aplicación de un sistema de ventas desarrollada siguiendo el patrón de diseño de Microservicios. La arquitectura está dividida en tres microservicios principales:

### **Microservicios**

1. **Productos:**
   - Almacena todos los productos en su base de datos.
   - Cada producto tiene un identificador único (`code`), nombre, precio y marca.

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
   git clone [[URL del repositorio](https://github.com/mativ707/Proyecto-sistema-de-ventas)]

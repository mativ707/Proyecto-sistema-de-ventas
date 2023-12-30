Sistema de Ventas

Este proyecto es una aplicación de un sistema de ventas aplicando el patron de diseño de Microservicios. Se encuentra dividido en 3 microservicios:
1- Productos: Almacena en su BD todos los productos con un identificador único (code) y demás características como el nombre, precio y marca.
2- Carrito: Se comunica con el servicio Productos para obtener un precio total de los productos mediante su id.
3- Venta: Registra cada venta mediante una fecha y un carrito de compra.

Inicio rápido:
1- Clone el repositorio.
2- Cree las correspondientes bases de datos (ya que estuvo siendo trabajada con BD locales) y configure el application properties en cada microservicio.
3- Puede ejecutar en su IDE de preferencia.

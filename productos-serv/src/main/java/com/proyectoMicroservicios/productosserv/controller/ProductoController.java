package com.proyectoMicroservicios.productosserv.controller;

import com.proyectoMicroservicios.productosserv.model.Producto;
import com.proyectoMicroservicios.productosserv.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService prodServ;
    @Value("${server.port}")
    private int serverPort;

    @GetMapping("/traer")
    public List<Producto> getProductos() {
        return prodServ.getProductos();
    }

    @GetMapping("/traerByIds/{ids}")
    public List<Producto> getById(@PathVariable("ids") List<Long> ids) {
        System.out.println("Estoy en el puerto: " + serverPort);
        return prodServ.getProductosById(ids);
    }

    @PostMapping("/crear")
    public String saveProducto(@RequestBody Producto producto) throws Exception {
        prodServ.saveProducto(producto.getNombre(),
                producto.getMarca(), producto.getPrecio());

        return "Se ha creado el producto correctamente!";
    }

    @DeleteMapping("/borrar/{idProducto}")
    public void deleteProdById(@PathVariable Long idProducto) {
        prodServ.deleteProducto(idProducto);
    }
}

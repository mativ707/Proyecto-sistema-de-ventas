package com.proyectoMicroservicios.carritoserv.controller;

import com.proyectoMicroservicios.carritoserv.model.Carro;
import com.proyectoMicroservicios.carritoserv.service.ICarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private ICarroService carroServ;

    @GetMapping("/findCarro/{idCarro}")
    public Carro getCarroById(@PathVariable Long idCarro){
        return carroServ.findCarro(idCarro);
    }

    @GetMapping("/traer")
    public List<Carro> getCarros(){
        return carroServ.getCarros();
    }

    @PostMapping("/crear")
    public String saveCarro(@RequestBody List<Long> idProductos){

        carroServ.saveCarro(idProductos);

        return "Se ha creado el carrito correctamente!";
    }

    @DeleteMapping("/delete/{idCarro}")
    public String deleteCarro(@PathVariable Long idCarro){
        carroServ.deleteCarro(idCarro);
        return "Se ha eliminado el carro correctamente";
    }

    @PutMapping("/sacarProductos/{idCarro}")
    public String deleteProductosCarrito(@PathVariable Long idCarro, @RequestBody List<Long> idProductos) throws Exception {

        carroServ.eliminarProductos(idCarro, idProductos);

        return "Se han actualizado los productos en tu carrito!";
    }

    @PutMapping("/agregarProductos/{idCarro}")
    public String addProductosCarrito(@PathVariable Long idCarro, @RequestBody List<Long> idProductos) throws Exception {

        carroServ.agregarProductos(idCarro, idProductos);

        return "Se han actualizado los productos en tu carrito!";
    }
}

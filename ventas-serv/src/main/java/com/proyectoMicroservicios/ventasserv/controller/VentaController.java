package com.proyectoMicroservicios.ventasserv.controller;

import com.proyectoMicroservicios.ventasserv.dto.CarroDTO;
import com.proyectoMicroservicios.ventasserv.dto.VentaDTO;
import com.proyectoMicroservicios.ventasserv.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @GetMapping("/consulta/{idVenta}")
    public VentaDTO consultaVenta(@PathVariable Long idVenta) throws Exception {
        return ventaServ.consultaVenta(idVenta);
    }

    @PostMapping("/crear/{idCarro}")
    public String crearVenta(@PathVariable Long idCarro){

        ventaServ.saveVenta(idCarro);
        return "Se ha creado la venta correctamente!";
    }
}

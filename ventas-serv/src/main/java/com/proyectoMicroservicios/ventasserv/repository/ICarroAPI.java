package com.proyectoMicroservicios.ventasserv.repository;

import com.proyectoMicroservicios.ventasserv.dto.CarroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "carrito-serv")
public interface ICarroAPI {

    @GetMapping("/carro/findCarro/{idCarro}")
    public CarroDTO getCarroById(@PathVariable Long idCarro);
}

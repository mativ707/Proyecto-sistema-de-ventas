package com.proyectoMicroservicios.ventasserv.repository;

import com.proyectoMicroservicios.ventasserv.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "productos-serv")
public interface IProductoAPI {

    @GetMapping("/productos/traerByIds/{ids}")
    public List<ProductoDTO> getById(@PathVariable("ids") List<Long> ids);
}

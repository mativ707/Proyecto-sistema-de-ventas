package com.proyectoMicroservicios.ventasserv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    private Long id;
    private Double totalVenta;
    private List<ProductoDTO> productosVenta;
}

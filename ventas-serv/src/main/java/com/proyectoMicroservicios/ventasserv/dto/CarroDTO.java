package com.proyectoMicroservicios.ventasserv.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

    private Long id;
    private Double total;
    private List<Long> idProductos;

}

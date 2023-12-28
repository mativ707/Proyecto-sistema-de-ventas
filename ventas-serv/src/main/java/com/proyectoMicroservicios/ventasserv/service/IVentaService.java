package com.proyectoMicroservicios.ventasserv.service;

import com.proyectoMicroservicios.ventasserv.dto.VentaDTO;
import com.proyectoMicroservicios.ventasserv.model.Venta;

public interface IVentaService {

    public Venta getVentaById(Long id);

    public void saveVenta(Long idCarro);

    public void deleteVenta(Long id);

    public VentaDTO consultaVenta(Long idVenta) throws Exception;


}

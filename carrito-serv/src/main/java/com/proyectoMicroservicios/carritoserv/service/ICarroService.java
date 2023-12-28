package com.proyectoMicroservicios.carritoserv.service;

import com.proyectoMicroservicios.carritoserv.model.Carro;

import java.util.List;

public interface ICarroService {

    public List<Carro>getCarros();
    public Carro findCarro(Long id);
    public void saveCarro(List<Long>idProductos);
    public void deleteCarro(Long id);
    public void agregarProductos(Long id, List<Long>idProductos) throws Exception;
    public void eliminarProductos(Long id, List<Long>idProductos) throws Exception;
}

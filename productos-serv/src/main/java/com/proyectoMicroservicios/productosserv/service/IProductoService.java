package com.proyectoMicroservicios.productosserv.service;

import com.proyectoMicroservicios.productosserv.model.Producto;

import java.util.List;

public interface IProductoService{

    public List<Producto>getProductos();
    public Producto getProductoById(Long id);
    public List<Producto>getProductosById(List<Long>ids);
    public void saveProducto(String nombre, String marca, Double precio);
    public void deleteProducto(Long id);
    public void modifyProducto(Long id, Producto producto);

}

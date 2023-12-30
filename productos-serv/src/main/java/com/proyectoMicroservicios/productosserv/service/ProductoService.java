package com.proyectoMicroservicios.productosserv.service;

import com.proyectoMicroservicios.productosserv.model.Producto;
import com.proyectoMicroservicios.productosserv.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getProductosById(List<Long>ids) {
        return productoRepo.findAllById(ids);
    }

    @Override
    public void saveProducto(String nombre, String marca, Double precio) throws Exception {

        validar(nombre,marca,precio);

        //Instanciamos
        Producto prod = new Producto();
        //Seteamos atributos
        prod.setMarca(marca);
        prod.setNombre(nombre);
        prod.setPrecio(precio);

        //Guardamos
        productoRepo.save(prod);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public void modifyProducto(Long id, Producto producto) throws Exception {

        Producto productoEditar = productoRepo.findById(id).orElse(null);

        if(productoEditar != null){
            productoEditar = producto;
            productoRepo.save(productoEditar);
        }else{
            throw new Exception("El producto a editar no se ha encontrado");
        }
    }

    public void validar (String nombre, String marca, Double precio) throws Exception {

        if(nombre == null || nombre.isEmpty()){
            throw new Exception("El nombre no es válido o esta vacío");
        }
        if(marca == null || marca.isEmpty()){
            throw new Exception("La marca no es válida o esta vacío");
        }
        if(precio == null || precio.isNaN()){
            throw new Exception("El precio no es válido o esta vacío");
        }
    }
}

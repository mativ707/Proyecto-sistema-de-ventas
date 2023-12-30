package com.proyectoMicroservicios.carritoserv.service;

import com.proyectoMicroservicios.carritoserv.dto.ProductoDTO;
import com.proyectoMicroservicios.carritoserv.model.Carro;
import com.proyectoMicroservicios.carritoserv.repository.ICarroRepository;
import com.proyectoMicroservicios.carritoserv.repository.IProductoAPIClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService implements ICarroService {

    @Autowired
    private ICarroRepository carroRepo;
    @Autowired
    private IProductoAPIClient productoAPI;

    @Override
    @CircuitBreaker(name = "producto-serv", fallbackMethod = "fallBackGetProductosById")
    @Retry(name = "producto-serv")
    public void saveCarro(List<Long> idProductos) {
        Carro carro = new Carro();

        List<ProductoDTO> listaProductos = new ArrayList<ProductoDTO>();
        listaProductos = productoAPI.getById(idProductos);

        List<Long> guardadoCodes = new ArrayList<Long>();

        //Variable para guardar y sumar los precios de los productos elegidos
        Double precios = 0.0;

        //Iteramos iter + TAB
        for (ProductoDTO aux : listaProductos) {
            precios += aux.getPrecio();
            guardadoCodes.add(aux.getCode());
        }

        //Seteamos
        carro.setIdProductos(guardadoCodes);
        carro.setTotal(precios);
        //Guardamos
        carroRepo.save(carro);
    }

    public List<ProductoDTO> fallBackGetProductosById(Throwable throwable){

        List<ProductoDTO> errorList = new ArrayList<>();
        errorList.add(new ProductoDTO(99999L, "ERROR", "ERROR", 0.0));

        return errorList;
    }

    @Override
    public void eliminarProductos(Long id, List<Long> idProductos) throws Exception {

        Carro carro = carroRepo.findById(id).orElse(null);

        if (carro == null) {
            throw new Exception("No se ha encontrado carrito");
        }

        List<ProductoDTO> restaDeProductos = new ArrayList<ProductoDTO>();
        restaDeProductos = productoAPI.getById(idProductos);
        List<Long> nuevaListaCarro = new ArrayList<Long>();
        nuevaListaCarro = carro.getIdProductos();
        Double preciosRestar = 0.0;

        for (ProductoDTO aux : restaDeProductos) {

            //Nos aseguramos de no restar productos inexistentes en el carro
            if (carro.getIdProductos().contains(aux.getCode())) {
                preciosRestar += aux.getPrecio();
                nuevaListaCarro.remove(aux.getCode());
            }
        }

        //Actualizamos el total del carrito
        carro.setTotal(carro.getTotal() - preciosRestar);
        //Actualizamos lista de productos de carro (id's)
        carro.setIdProductos(nuevaListaCarro);
        //Actualizamos y guardamos
        carroRepo.save(carro);
    }

    @Override
    public void agregarProductos(Long id, List<Long>idProductos) throws Exception {

        Carro carro = carroRepo.findById(id).orElse(null);

        if (carro == null) {
            throw new Exception("No se ha encontrado carrito");
        }

        List<ProductoDTO> sumaDeProductos = new ArrayList<ProductoDTO>();
        sumaDeProductos = productoAPI.getById(idProductos);
        List<Long> nuevaListaCarro = new ArrayList<Long>();
        nuevaListaCarro = carro.getIdProductos();
        Double preciosSumar = 0.0;

        for (ProductoDTO aux : sumaDeProductos) {

            //Nos aseguramos de no agregar productos existentes en el carro
            if (!carro.getIdProductos().contains(aux.getCode())) {
                preciosSumar += aux.getPrecio();
                nuevaListaCarro.add(aux.getCode());
            }
        }

        //Actualizamos el total del carrito
        carro.setTotal(carro.getTotal() + preciosSumar);
        //Actualizamos lista de productos de carro (id's)
        carro.setIdProductos(nuevaListaCarro);
        //Actualizamos y guardamos
        carroRepo.save(carro);
    }

    @Override
    public List<Carro> getCarros() {
        return carroRepo.findAll();
    }

    @Override
    public Carro findCarro(Long id) {
        return carroRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCarro(Long id) {
        carroRepo.deleteById(id);
    }

}

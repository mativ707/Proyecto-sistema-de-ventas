package com.proyectoMicroservicios.ventasserv.service;

import com.proyectoMicroservicios.ventasserv.dto.CarroDTO;
import com.proyectoMicroservicios.ventasserv.dto.ProductoDTO;
import com.proyectoMicroservicios.ventasserv.dto.VentaDTO;
import com.proyectoMicroservicios.ventasserv.model.Venta;
import com.proyectoMicroservicios.ventasserv.repository.ICarroAPI;
import com.proyectoMicroservicios.ventasserv.repository.IProductoAPI;
import com.proyectoMicroservicios.ventasserv.repository.IVentaRepository;
import com.thoughtworks.xstream.converters.time.LocalDateConverter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepo;

    @Autowired
    private IProductoAPI productoAPI;
    @Autowired
    private ICarroAPI carroAPI;

    @Override
    public Venta getVentaById(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void saveVenta(Long idCarro) {
        Venta venta = new Venta();
        venta.setFecha(LocalDate.now());
        venta.setIdCarro(idCarro);

        ventaRepo.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        ventaRepo.deleteById(id);
    }

    @Override
    @CircuitBreaker(name = "carrito-serv", fallbackMethod = "fallBackGetCarroById")
    public VentaDTO consultaVenta(Long idVenta) throws Exception {

        VentaDTO consulta = new VentaDTO();
        Venta ventaConsulta = ventaRepo.findById(idVenta).orElse(null);

        if(ventaConsulta == null){
            throw new Exception("La venta no se ha encontrado o es nula");
        }

        // Obtenemos el carro para identificar su total
        CarroDTO carro = new CarroDTO();
        carro = carroAPI.getCarroById(ventaConsulta.getIdCarro());

        // Obtenemos la lista de productos asociados al carro
        List<ProductoDTO> listaProductos = new ArrayList<ProductoDTO>();
        listaProductos = productoAPI.getById(carro.getIdProductos());

        // Seteamos los atributos a la consulta
        consulta.setId(ventaConsulta.getId());
        consulta.setTotalVenta(carro.getTotal());
        consulta.setProductosVenta(listaProductos);

        return consulta;
    }

    public VentaDTO fallBackGetCarroById(Throwable throwable){
        return new VentaDTO(9999L, 0.0, null);
    }
}

package com.proyectoMicroservicios.productosserv.repository;

import com.proyectoMicroservicios.productosserv.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}

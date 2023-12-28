package com.proyectoMicroservicios.ventasserv.repository;

import com.proyectoMicroservicios.ventasserv.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {

}

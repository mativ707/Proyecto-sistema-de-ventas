package com.proyectoMicroservicios.carritoserv.repository;

import com.proyectoMicroservicios.carritoserv.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarroRepository extends JpaRepository<Carro,Long> {
}

package com.proyectoMicroservicios.productosserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductosServApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductosServApplication.class, args);
	}

}

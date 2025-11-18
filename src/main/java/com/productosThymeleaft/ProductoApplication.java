package com.productosThymeleaft;

import com.productosThymeleaft.modelo.Productos;
import com.productosThymeleaft.repositorio.productosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductoApplication implements CommandLineRunner {

    @Autowired
    private productosRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ProductoApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
       /* Productos productos = new Productos("Sabritas","50 Gramos, exceso de sal",12,new BigDecimal(12.50),"Soriana");

        repositorio.save(productos);*/
    }
}

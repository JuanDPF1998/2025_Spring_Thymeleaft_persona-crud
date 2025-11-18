package com.productosThymeleaft.repositorio;

import com.productosThymeleaft.modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productosRepositorio extends JpaRepository<Productos,Integer> {
}

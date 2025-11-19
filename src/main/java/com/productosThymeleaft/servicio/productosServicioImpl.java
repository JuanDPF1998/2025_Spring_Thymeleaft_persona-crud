package com.productosThymeleaft.servicio;

import com.productosThymeleaft.modelo.Productos;
import com.productosThymeleaft.repositorio.productosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productosServicioImpl implements  productosServicio{
    @Autowired
    private productosRepositorio repositorio;

    @Override
    public List<Productos> listarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Productos agregarProducto(Productos productos) {
        return repositorio.save(productos);
    }

    @Override
    public Productos obtenerProductoId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Productos actualizarPorId(Productos productos) {
        return repositorio.save(productos);
    }

    @Override
    public void eliminarPorId(Long id) {
        repositorio.deleteById(id);
    }
}

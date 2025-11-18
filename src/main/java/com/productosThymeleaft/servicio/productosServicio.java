package com.productosThymeleaft.servicio;

import com.productosThymeleaft.modelo.Productos;

import java.util.List;

public interface productosServicio {
    public List<Productos> listarTodos();
    public Productos agregarProducto(Productos productos);
}

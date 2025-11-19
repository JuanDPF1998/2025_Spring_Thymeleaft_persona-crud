package com.productosThymeleaft.controlador;

import com.productosThymeleaft.modelo.Productos;
import com.productosThymeleaft.servicio.productosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class productosControlador {
    @Autowired
    private productosServicio servicio;

    @GetMapping({"/productos", "/"})
    public String listarTodos(Model model){
        model.addAttribute("productos", servicio.listarTodos());
        return "Productos";
    }

    //mostrar formulario
    @GetMapping("/productos/nuevo")
    public String mostrarFormularioAgregar(Model model){
        Productos producto = new Productos();
        model.addAttribute("producto", producto);
        return "Formulario_Registrar";
    }
    //Accion registrar producto en la base de datos
    @PostMapping("/productos")
    public String registrarProductoEnBaseDeDatos(@ModelAttribute Productos producto){
        servicio.agregarProducto(producto);
        return "redirect:/productos";
    }
    @GetMapping("/productos/ver/{id}")
    public String mostrarFormularioEditarPorId(@PathVariable Long id, Model model){
        model.addAttribute("producto", servicio.obtenerProductoId(id));
        return "Formulario_Editar";
    }
    @PostMapping("/productos/actualizar/{id}")
    public String actualizarProductos(@PathVariable Long id, @ModelAttribute("producto") Productos producto){
        Productos productoExiste = servicio.obtenerProductoId(id);
        productoExiste.setId(id);
        productoExiste.setNombre(producto.getNombre());
        productoExiste.setDescripcion(producto.getDescripcion());
        productoExiste.setExistencia(producto.getExistencia());
        productoExiste.setPrecio(producto.getPrecio());
        productoExiste.setTienda(producto.getTienda());

        servicio.actualizarPorId(productoExiste);
        return "redirect:/productos";
    }
    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id){
        servicio.eliminarPorId(id);
        return "redirect:/productos";
    }
}

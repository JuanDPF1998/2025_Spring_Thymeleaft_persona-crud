package com.productosThymeleaft.controlador;

import com.productosThymeleaft.modelo.Productos;
import com.productosThymeleaft.servicio.productosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

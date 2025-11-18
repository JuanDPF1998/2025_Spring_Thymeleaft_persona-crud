package com.productosThymeleaft.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false, length = 100, unique = true)
    private String nombre;
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Column(name = "existencia", nullable = false)
    private int existencia;
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
    @Column(name = "tienda", nullable = false, length = 100)
    private String tienda;

    public Productos(String nombre, String descripcion, int existencia, BigDecimal precio, String tienda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencia = existencia;
        this.precio = precio;
        this.tienda = tienda;
    }
}

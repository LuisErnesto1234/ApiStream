package com.pruebas.estudio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Producto {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private int cantidadVendida;

}

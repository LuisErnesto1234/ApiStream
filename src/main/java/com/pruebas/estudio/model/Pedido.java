package com.pruebas.estudio.model;

import lombok.Getter;

import java.util.List;

@Getter
public class Pedido {
    private List<Productos> productos;
    public Pedido(List<Productos> productos) { this.productos = productos; }
}

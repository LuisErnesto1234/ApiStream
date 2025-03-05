package com.pruebas.estudio.model;

import java.util.List;

public class Usuario {

    private String nombre;
    private List<String> correos;

    public Usuario(String nombre, List<String> correos) {
        this.nombre = nombre;
        this.correos = correos;
    }
    public List<String> getCorreos() {
        return correos;
    }

    public String getNombre() {
        return nombre;
    }
}

package com.pruebas.estudio.model;

import lombok.*;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    private String nombre;
    private List<String> libros;

}

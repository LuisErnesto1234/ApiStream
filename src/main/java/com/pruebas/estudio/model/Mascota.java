package com.pruebas.estudio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mascota {
    private Long id;
    private String nombre;
    private String especie;
    private Integer edad;
}

package com.pruebas.estudio;

import com.pruebas.estudio.model.Mascota;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        /*TODO Tenemos la lista armada, ahora veamos como podemos filtrar informacion,
        *  recordemos que haremos uso de map() y tambien de filter()*/
        List <Mascota> mascotaList = Arrays.asList(
                new Mascota(1L, "Sasi", "Gato", 2),
                new Mascota(2L, "Claudio", "Gallo", 4),
                new Mascota(3L, "Masha", "Perro", 3));

        List<String> especieGato = mascotaList.stream()
                .filter(u -> u.getEspecie().equals("Gato"))
                .map(Mascota::toString)
                .toList();

//        mascotaList.forEach(System.out::println);
        especieGato.forEach(System.out::println);



    }
}

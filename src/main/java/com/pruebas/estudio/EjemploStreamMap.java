package com.pruebas.estudio;

import com.pruebas.estudio.model.Bandera;
import com.pruebas.estudio.model.Mascota;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {

    public static void main(String[] args) {

        /*TODO: Stream: es como una especie de mecanismo en el cual nosotros podemos
         *  organizar extraer filtrar infromacion, cabe aclarar que un stream no guarda
         * todo información, pues solo la trata la manipula quienes si guardan infromacion son
         *  los coleccionables. Como List<E>, Map<K, V>*/

        Stream<String> s1 = Stream
                .of("Luis", "Ernesto", "Mateo", "Adriano", "Nil")
                .map(String::toUpperCase);
//                .peek(System.out::println);

        /*todo Convertir este Stream a una lista*/

        List<String> lista = s1.toList();
        lista.forEach(System.out::println);


        /*TODO Ahora vamos con algo mas cercano a la realidad*/
        List<Mascota> mascotaList = Arrays.asList(
                new Mascota(1L, "Sasi", "Gato", 3),
                new Mascota(2L, "Claudio", "Gallo", 2),
                new Mascota(3L, "Masha", "Perro", 4)
        );

//        String [] mascotasNombres = mascotaList.stream()
//                .map(Mascota::getNombre)
//                .toArray(String[]::new);

        List<String> mN = mascotaList.stream()
                .map(Mascota::getNombre)
                .toList();

        mN.forEach(System.out::println);



    List<Integer> edades = mascotaList.stream()
            .map(Mascota::getEdad)
            .toList();

    edades.forEach(System.out::println);


    /*TODO: Otro ejemplo, ahora veamos como podemos hacer para por ejemplo separar el nombre y el apellido
    *  y colocarlo por separado de modo que el objeto complete sus atributos con un solo String :V*/

        Stream<Bandera> banderaStream = Stream.
                of("Peru America", "Italia Europa", "USA America", "Senegal Africa", "China Asia", "Australia Oceania")
                .map(nombre -> new Bandera(nombre.split(" ")[0], nombre.split(" ")[1]));

        List<Bandera> banderaList = banderaStream.toList();
        banderaList.forEach(System.out::println);










    }
}
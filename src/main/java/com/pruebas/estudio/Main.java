package com.pruebas.estudio;

import com.pruebas.estudio.model.Autor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /*TODO: Stream: es como una especie de mecanismo en el cual nosotros podemos
         *  organizar extraer filtrar infromacion, cabe aclarar que un stream no guarda
         * todo información, pues solo la trata la manipula quienes si guardan infromacion son
         *  los coleccionables. Como List<E>, Map<K, V>*/

//        Stream<String> s1 = Stream.of("Luis", "Ernesto", "Mateo", "Adriano", "Nil");
//        s1.forEach(System.out::println);
//
//        String[] nombres = {"Luis", "Ernesto", "Mateo", "Adriano", "Nil"};
//        Stream<String> s2 = Arrays.stream(nombres);
//        s2.forEach(System.out::println);
//
//        Stream<String> s3 = Stream.<String>builder().add("Luis")
//                .add("Mateo")
//                .add("Bothi")
//                .build();
//
//        s3.forEach(System.out::println);
//
//        List<String> lista = Arrays.asList("Luis", "Ernesto", "Mateo", "Adriano", "Nil");
//        Stream<String> s4 = lista.stream();
//        s4.forEach(System.out::println);

        /*TODO: Otra manera de hacer el mismo ejemplo pero mas simplificado :V*/
//        lista.stream().forEach(System.out::println);

        List<Autor> autores = Arrays.asList(
                new Autor("Gabriel García Márquez", Arrays.asList("Cien años de soledad", "El amor en los tiempos del cólera")),
                new Autor("Julio Cortázar", Arrays.asList("Rayuela", "Bestiario")),
                new Autor("Isabel Allende", Arrays.asList("La casa de los espíritus", "Paula"))
        );

//         TODO: Usa flatMap() para obtener una lista única de libros
        List<String> nombresLibros = autores.stream()
                .flatMap(a -> a.getLibros().stream())
                .toList();


        nombresLibros.forEach(System.out::println);

        List<String> mejorFormato = autores.stream()
                .map(autor -> autor.getNombre() + " [\n  " +
                        String.join("\n  ", autor.getLibros()) +
                        "\n]")
                .toList();

        mejorFormato.forEach(s -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(s);
        });

    }
}
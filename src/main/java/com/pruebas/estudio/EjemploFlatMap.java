package com.pruebas.estudio;

import com.pruebas.estudio.model.Pedido;
import com.pruebas.estudio.model.Productos;
import com.pruebas.estudio.model.Usuario;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploFlatMap {

    public void main(String[] args) {
        /*TODO Ejercicio 1: Listas anidadas de números
            Tienes una lista de listas de números enteros. Usa flatMap para combinarlas
            en una sola lista y obtener solo los números pares.*/

        List<List<Integer>> numeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        // Tu código aquí para obtener los números pares
        //Salida esperada ☠️☠️[2, 4, 6, 8, 10, 12]

        List<Integer> numerosAgrupados =
                numeros.stream()
                        .flatMap(List::stream)
                        .filter(n -> n % 2 == 0)
                        .toList();

        numerosAgrupados.forEach(System.out::println);


    /*TODO: Ejercicio 2: Obtener palabras de frases
        Tienes una lista de frases. Usa flatMap para obtener
        una lista con todas las palabras individuales.*/

        List<String> frases = Arrays.asList(
                "Java es poderoso",
                "Me gusta programar en Java",
                "Aprendiendo Streams"
        );

// Tu código aquí para obtener las palabras
        List<String> pa = frases.stream()
                .map(a -> a.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        pa.forEach(System.out::println);

        /*TODO: Ejercicio 3: Filtrar palabras largas
                Modifica el ejercicio anterior, pero ahora usa flatMap para
                obtener solo las palabras que tienen más de 5 letras.*/

        List<String> cincoLetras = frases.stream()
                .map(a -> a.split(" "))
                .flatMap(Arrays::stream)
                .filter(a -> a.length() >= 5)
                .distinct()
                .collect(Collectors.toList());

        cincoLetras.forEach(System.out::println);

        /*TODO: Ejercicio 4: Extraer correos de una lista de usuarios
                Tienes una lista de Usuario, y cada usuario tiene una
                lista de correos electrónicos. Usa flatMap para extraer
                todos los correos en una sola lista.*/

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Carlos", Arrays.asList("carlos@gmail.com", "carlos@empresa.com")),
                new Usuario("Ana", Arrays.asList("ana@hotmail.com")),
                new Usuario("Pedro", Arrays.asList("pedro@yahoo.com", "pedro@trabajo.com"))
        );

        // Tu código aquí para extraer todos los correos
        List<String> correosUsuarios = usuarios.stream()
                .flatMap(u -> u.getCorreos().stream())
                .toList();

//        Map<String, List<String>> usuarioConCorreo = usuarios.stream()
//                        .reduce((a, b) -> a.getNombre() + b.getNombre())
//                .;
//

        correosUsuarios.forEach(System.out::println);
    }
}

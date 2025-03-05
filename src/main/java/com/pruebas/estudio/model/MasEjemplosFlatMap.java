package com.pruebas.estudio.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MasEjemplosFlatMap {

    public static void main(String[] args) {
        /*TODO: Ejercicio 5: Obtener productos de pedidos
            Tienes una lista de Pedido, y cada pedido tiene una lista de
            Producto. Usa flatMap para extraer solo los nombres de los productos en una sola lista.*/

        List<Pedido> pedidos;
        pedidos = Arrays.asList(
                new Pedido(Arrays.asList(new Productos("Laptop"), new Productos("Mouse"))),
                new Pedido(Arrays.asList(new Productos("Teclado"), new Productos("Monitor"))),
                new Pedido(Arrays.asList(new Productos("Impresora")))
        );

        List<String> nombresProductoPedido = pedidos.stream()
                .flatMap(p -> p.getProductos().stream())
                .map(Productos::getNombre)
                .toList();

        nombresProductoPedido.forEach(System.out::println);

        List<String> frases = Arrays.asList(
                "Java es poderoso",
                "Me gusta programar en Java",
                "Aprendiendo Streams"
        );
        /*TODO Bonus Usa flatMap para contar cuántas veces aparece
           cada palabra en una lista de frases.*/

                List<String> cincoLetras = frases.stream()
                .map(a -> a.split(" "))
                .flatMap(Arrays::stream)
                .toList();


        cincoLetras.forEach(System.out::println);
    }
}

package com.pruebas.estudio;

import com.pruebas.estudio.model.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterEmpty {

    public static void main(String[] args) {

        /*TODO: Pruebas con filter y count(), siendo esta ultima función la que nos permite
        *   contar datos a partir de un filtro realizada a una lista de datos
        *   esto puedo ayudar mucho por ejemplo a ver cuantos prodcutos pertenecen a cierta
        *   categoría y mas como precios o incluso descuentos similares.*/

//       long banderaStream = Stream.of("Peru", "Chile", "Brasil", "Uruguay", "Venezuela", "")
//                .filter(String::isEmpty)
//                .count();
//
//        System.out.println(banderaStream);


        /*TODO: Distinc: Este operador nos va ayudar a que nosotros podamos eliminar, elementos respetidos
        *   dentro de un flujo de datos (lista), de modo que no elimina informacion, solo hace
        *   que al momento de trabajar o imprimir datos los repetidos se omitan*/

//        Stream<String> nombres = Stream
//                .of("Luis", "Luis", "Ernesto","Ernesto", "Mateo", "Adriano", "Nil")
//                .distinct();
//
//                nombres.forEach(System.out::println);

       /*TODO: Reduce: */

//        Stream<String> n2 = Stream
//                .of("Luis", "Luis", "Ernesto","Ernesto", "Mateo", "Adriano", "Nil")
//                .distinct();
//
//        String resultado = n2.reduce(" ", (a, b) -> a + ", " + b);
//        System.out.println("resultado = " + resultado);

        /*TODO: Ejercicios con reduce, porque de otra manera no le entiendo ;V
        *   Ejercicio one, Dada una lista de productos, obtén el total de la suma de todos los precios.*/

        List<Producto> productos = Arrays.asList(
                new Producto(1L, "Laptop", 1200.0, 100, "Tecnologia", 10),
                new Producto(2L, "Mouse", 25.5, 240, "Tecnologia", 20),
                new Producto(3L, "Teclado", 75.0, 140, "Tecnologia", 50));

        double totalPrecios = productos.stream()
                .map(Producto::getPrecio)
                .reduce(0.0, Double::sum);

        // TODO Otro metodo seria, usar mapToDouble() para simplificar:

        /* double totalPrecios = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
                Más directo que reduce(0.0, Double::sum)*/

        System.out.println("totalPrecios = " + totalPrecios);


        /*TODO: TWO Exercise: 2️⃣ Encontrar el número más grande en una lista 🔢
            Dada una lista de números, encuentra el valor máximo.*/

        List<Integer> numeros = Arrays.asList(34, 12, 98, 54, 75, 120);

        Optional<Integer> numeroGrande = numeros.stream()
                .reduce((n1, n2) -> n1 > n2 ? n1 : n2);

        /*TODO: Alternativa más limpia con Integer::max:*/
        //Optional<Integer> numeroGrande = numeros.stream().reduce(Integer::max);

        numeroGrande.ifPresent(System.out::println);


        /*TODO: Concatenar nombres en una sola cadena 📝*/

        List<String> nombres = Arrays.asList("Luis", "Ana", "Carlos", "Maria");
        
        String nombreReduce = nombres.stream().reduce("", String::concat);

        //TODO  Usa joining() de Collectors para mejor rendimiento:

        //String nombreReduce = nombres.stream().collect(Collectors.joining(", "));

        System.out.println("nombreReduce = " + nombreReduce);


        /*TODO: 4️⃣ Contar el total de caracteres en una lista de palabras 🔠
               Dada una lista de palabras, cuenta el total de caracteres de todas ellas.*/

        List<String> palabras = Arrays.asList("Java", "Stream", "Reduce", "Lambda");

        String palabraReduce = palabras.stream().reduce("", String::concat);

        //TODO: Mejor opción con mapToInt() y sum():

        /* int totalCaracteres = palabras.stream()
                .mapToInt(String::length)
                .sum();*/

        System.out.println("palabraReduceCantidad = " + palabraReduce.length());

        /*TODO Reto HardCore 🔥🔥🗣️☠️: Análisis de Ventas de Productos
            Tienes una lista de productos vendidos en una tienda, cada uno con un nombre, precio y cantidad vendida.
            Debes responder estas preguntas usando Streams y reduce():

            1️⃣ Obtener el total de ingresos generados 💰

            Multiplica el precio de cada producto por su cantidad vendida y suma el total.
            2️⃣ Encontrar el producto más vendido (mayor cantidad vendida) 📈

            Usa reduce() para hallar el producto con más ventas.
            3️⃣ Concatenar los nombres de los productos vendidos en una sola cadena 📝

            Formato: "Laptop, Mouse, Teclado"
            4️⃣ Calcular la cantidad total de productos vendidos 📊

            Suma todas las cantidades vendidas.*/

        //TODO: Datos de Ejemplo ☠️☠️
        List<Producto> productosList = Arrays.asList(
                new Producto(1L, "Laptop", 1200.0, 100, "Tecnologia", 5),
                new Producto(2L, "Mouse", 25.5, 240, "Tecnologia", 10),
                new Producto(3L, "Teclado", 75.0, 140, "Tecnologia", 8),
                new Producto(4L, "Monitor", 300.0, 20, "Tecnologia", 0));


        //TODO: Calculo de Ingresos generados EASY
        double sumaIngresos = productosList.stream()
                .mapToDouble(a -> a.getCantidadVendida() * a.getPrecio())
                .sum();

        //TODO: Encontrar el producto más vendido (mayor cantidad vendida) MEDIUM
        Optional<Producto> productoMasVendido = productosList.stream()
                .reduce((a, b) -> a.getCantidadVendida() > b.getCantidadVendida() ? a : b);

        //TODO: Concatenar los nombres de los productos vendidos en una sola cadena HARD

//        String nombresPopulares = productosList.stream().reduce(", ", (a, b) -> a.getCantidadVendida() > 0 && b.getCantidadVendida() > 0 ? a.getNombre().concat(b.getNombre()) : b.getNombre().concat(a.getNombre()).toString());

//        System.out.println("nombresPopulares = " + nombresPopulares);

        //TODO: Cantidades vendidas suma total
        int sumaCantidadTotal = productosList
                .stream()
                .mapToInt(Producto::getCantidadVendida)
                .sum();






    }
}

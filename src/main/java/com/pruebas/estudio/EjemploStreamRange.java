package com.pruebas.estudio;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class EjemploStreamRange {

    public static void main(String[] args) {

        /*TODO suma todo los numeros de un rango pero dicho metodo range()
        *   no es soportado por stream de modo que debemos usar IntStream, el cual no tiene
        *   generico pues se sobre entiende que recibe solo enteros :V*/
        IntStream n = IntStream.range(2, 9).peek(System.out::println);
        /*TODO: Al sugerir este rango solo se contaran los numero del 2 hasta el 8 debido a que
        *   el ultimo numero se ovbia, pero si no deseamos eso, podemos usar lo siguiente:
        *   IntStream n = IntStream.rangeClose(2, 9).peek(System.out::println);
        *   de este modo se incluye el nueve tambien en el rango.
        * */




        IntSummaryStatistics statistics = n.summaryStatistics();
        System.out.println("Numero mayor = " + statistics.getMax());
        System.out.println("Promedio de numeros: " + statistics.getAverage());
        System.out.println("Suma de todo: " + statistics.getSum());
        System.out.println("Total: " + statistics.getCount() );

    }
}

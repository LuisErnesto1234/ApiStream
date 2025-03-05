package com.pruebas.estudio;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStreamInfinitoGenerate {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        Stream.generate(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return atomicInteger.incrementAndGet();
        })
                .limit(5)
                .forEach(System.out::println);
    }
}

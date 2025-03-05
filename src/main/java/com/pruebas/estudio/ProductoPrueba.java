package com.pruebas.estudio;

import com.pruebas.estudio.model.Producto;
import com.pruebas.estudio.service.ProductoService;

public class ProductoPrueba {

    public static void main(String[] args) {
        ProductoService productoService = new ProductoService();

        // Agregamos productos
        productoService.agregarProducto(new Producto(1L, "Laptop", 1200, 5, "Tecnología", 2));
        productoService.agregarProducto(new Producto(2L, "Teclado", 45, 6, "Tecnología", 0));
        productoService.agregarProducto(new Producto(3L, "Zapatillas", 60, 10, "Moda", 0));
        productoService.agregarProducto(new Producto(4L, "Mouse", 25, 20, "Tecnología", 0));
        productoService.agregarProducto(new Producto(5L, "Estuche", 40, 60, "Oficina", 0));

        // Listar productos
        System.out.println("📌 Lista de productos:");
        productoService.findAll().forEach(System.out::println);

        // Buscar producto por ID
        System.out.println("\n📌 Buscar producto con ID 2:");
        productoService.findById(2L).ifPresent(System.out::println);

        // Filtrar por categoría
        System.out.println("\n📌 Productos de categoría Tecnología:");
        productoService.findByCategory("Tecnología").forEach(System.out::println);

        // Verificar si existe un producto
        System.out.println("\n📌 ¿Existe un producto llamado 'Zapatillas'? " + productoService.existeProductoNombre("Zapatillas"));

        // Eliminar un producto
        productoService.eliminarProducto(3L);
        System.out.println("\n📌 Lista después de eliminar el producto con ID 3:");
        productoService.findAll().forEach(System.out::println);

        //Actualizar producto: modficar el precio
        productoService.actualizarProductoById(1L, 1500);
        System.out.println("\n📌 Modificacion de precio en el producto con ID 01, paso de ser 1200 a 1500 :v");
        productoService.findAll().forEach(System.out::println);

        //Filtro para productos por precio minimo y maximo :)
        System.out.println("\n📌 Se muestran productos, precios de 40 a 2000 mangos :v");
        productoService.productoMaxMin(40, 2000).forEach(System.out::println);

        //Filtro productos de menor a mayor
        System.out.println("\n📌 Se muestran productos, precios de menor a mayor XD");
        productoService.ordenarMaxMin().forEach(System.out::println);

        //Productos por categoria - cantidad
        System.out.println("\n📌 Se muestra, la cantidad de productos de la categoria Tecnologia");
        System.out.println(productoService.countCategory("Tecnología"));

        System.out.println("Filtrar por categoria y poner en mayusculas los nombres ");
        productoService.filtrarProductosPorCategoria("Tecnología").forEach(System.out::println);

    }

}

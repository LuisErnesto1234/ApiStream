package com.pruebas.estudio.service;

import com.pruebas.estudio.model.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductoService {

    /*TODO se crea una lista que contendra los datos :V*/

    List<Producto> productoList = new ArrayList<>();

    /*TODO Ahora se agregaran metodos crud, ya sabes los mas basicos*/
    public List<Producto> findAll(){
        return productoList;
    }

    public void agregarProducto(Producto p){
        productoList.add(p);
    }

    /*TODO: Vamos con un ejemplo mas real buscar por id :(*/
    public Optional<Producto> findById(Long id){
        return productoList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    /*TODO: Filtrar por categoria, GO O NO GO?*/
    public List<Producto> findByCategory(String c){
        return productoList.stream()
                .filter(p -> p.getCategoria().equals(c))
                .collect(Collectors.toList());
    }

    /*TODO: Ahora veamos si existe un producto o nelson GOOOOOOOOO 🔥🔥*/
    public boolean existeProductoNombre(String n){
        return productoList.stream()
                .anyMatch(b -> b.getNombre().equalsIgnoreCase(n));
    }

    public void eliminarProducto(Long id){
        productoList.removeIf(p -> p.getId().equals(id));
    }

    /*TODO: Actualizar un producto: Agregar un método para modificar el precio de un producto dado su id.
    * Filtrar productos por precio mínimo/máximo.
    * Ordenar productos por precio de menor a mayor usando .sorted().
    * Contar cuántos productos hay por categoría.*/

    public void actualizarProductoById(Long id, double precio){
        productoList = productoList.stream()
                .map(p -> p.getId().equals(id) ? new Producto(p.getId(), p.getNombre(), precio, p.getStock(), p.getCategoria(), p.getCantidadVendida()) : p)
                .collect(Collectors.toList());
    }

    public List<Producto> productoMaxMin(int min, int max){
        return productoList.stream()
                .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .toList();
    }

    public List<Producto> ordenarMaxMin(){
        return productoList.stream()
                .sorted(Comparator.comparing(Producto::getPrecio))
                .toList();
    }

    public long countCategory (String c){
        return productoList.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(c))
                .count();
    }


    public void actualizarStock(Long id, int cantidad) {
        productoList = productoList.stream()
                .map(u -> u.getId().equals(id) ? new Producto(u.getId(),
                        u.getNombre(), u.getPrecio(), u.getStock() + cantidad, u.getCategoria(), u.getCantidadVendida()) : u)
                .collect(Collectors.toList());
    }

    /*TODO: Reto: Filtrar productos por categoría y convertirlos en nombres de mayúsculas
Tienes una lista de productos y debes hacer lo siguiente:

✅ Filtrar solo los productos que pertenecen a una categoría específica.
✅ Convertir los nombres de esos productos a mayúsculas.
✅ Guardarlos en una nueva lista de nombres (List<String>).*/

    public List<String> filtrarProductosPorCategoria(String categoria) {
        return productoList.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .map(p -> p.getNombre().toUpperCase())
                .collect(Collectors.toList());
    }

    }

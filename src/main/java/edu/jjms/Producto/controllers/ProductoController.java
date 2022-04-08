package edu.jjms.Producto.controllers;

import edu.jjms.Producto.entities.Producto;
import edu.jjms.Producto.services.ProductoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoServiceImpl productoService;

    @GetMapping
    public List<Producto> listarProducto(){
        return productoService.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto buscarProducto(@PathVariable Long id){
        return productoService.buscarProducto(id);
    }

    @PostMapping
    public void crearProducto(@RequestBody Producto producto){
        productoService.crearProducto(producto);
    }

    @PutMapping
    public void actualizarProducto(@RequestBody Producto producto){
        productoService.actualizarProducto(producto);
    }

    @DeleteMapping
    public void borrarProducto(@RequestBody Producto producto){
        productoService.borrarProducto(producto);
    }
}

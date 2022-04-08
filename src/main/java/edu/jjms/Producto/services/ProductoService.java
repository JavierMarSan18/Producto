package edu.jjms.Producto.services;

import edu.jjms.Producto.entities.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listarProductos();
    Producto buscarProducto(Long id);
    void crearProducto(Producto producto);
    void actualizarProducto(Producto producto);
    void borrarProducto(Producto producto);
}

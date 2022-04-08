package edu.jjms.Producto.services;

import edu.jjms.Producto.entities.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductoServiceImpl implements ProductoService{
    private static final AtomicLong sequence = new AtomicLong();
    private static final List<Producto> lista = new ArrayList<>(){{
        add(new Producto(sequence.incrementAndGet(),"audifonos", "sony","bluetooth", 100));
    }};

    @Override
    public List<Producto> listarProductos() {
        return lista;
    }

    @Override
    public Producto buscarProducto(Long id) {
        for(Producto p : lista){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void crearProducto(Producto producto) {
        producto.setId(sequence.incrementAndGet());
        lista.add(producto);
    }

    @Override
    public void actualizarProducto(Producto producto) {
        Long id = producto.getId();
        Producto p = buscarProducto(id);
        producto.setId(id);
        lista.set(lista.indexOf(p), producto);
    }

    @Override
    public void borrarProducto(Producto producto) {
        lista.remove(producto);
    }
}

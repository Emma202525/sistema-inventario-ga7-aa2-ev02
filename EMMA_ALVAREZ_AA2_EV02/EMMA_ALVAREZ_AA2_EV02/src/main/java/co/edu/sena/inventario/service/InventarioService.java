package co.edu.sena.inventario.service;

import co.edu.sena.inventario.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que administra los productos.
 * Para esta evidencia se utiliza una lista en memoria.
 */
public class InventarioService {

    private static final List<Producto> productos = new ArrayList<>();
    private static int siguienteId = 4;

    static {
        productos.add(new Producto(1, "Arroz 1 kg", "Granos", 20, 4500));
        productos.add(new Producto(2, "Aceite 1 L", "Abarrotes", 15, 7500));
        productos.add(new Producto(3, "Galletas", "Snacks", 30, 2500));
    }

    public List<Producto> listar() {
        return new ArrayList<>(productos);
    }

    public Producto buscarPorId(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return listar();
        }

        String texto = nombre.trim().toLowerCase();

        return productos.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(texto))
                .collect(Collectors.toList());
    }

    public void guardar(Producto producto) {
        producto.setId(siguienteId++);
        productos.add(producto);
    }

    public boolean actualizar(Producto productoActualizado) {
        Producto producto = buscarPorId(productoActualizado.getId());

        if (producto == null) {
            return false;
        }

        producto.setNombre(productoActualizado.getNombre());
        producto.setCategoria(productoActualizado.getCategoria());
        producto.setCantidad(productoActualizado.getCantidad());
        producto.setPrecio(productoActualizado.getPrecio());

        return true;
    }

    public boolean eliminar(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
}

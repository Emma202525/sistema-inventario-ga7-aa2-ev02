package co.edu.sena.inventario.service;

import co.edu.sena.inventario.model.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarioServiceTest {

    @Test
    void debeEncontrarProductoPorId() {
        InventarioService servicio = new InventarioService();

        Producto producto = servicio.buscarPorId(1);

        assertNotNull(producto);
        assertEquals("Arroz 1 kg", producto.getNombre());
    }

    @Test
    void debeRegistrarProducto() {
        InventarioService servicio = new InventarioService();
        int cantidadInicial = servicio.listar().size();

        servicio.guardar(new Producto(0, "Pan", "Panadería", 10, 2000));

        assertEquals(cantidadInicial + 1, servicio.listar().size());
    }

    @Test
    void debeEliminarProducto() {
        InventarioService servicio = new InventarioService();

        boolean eliminado = servicio.eliminar(2);

        assertTrue(eliminado);
        assertNull(servicio.buscarPorId(2));
    }
}

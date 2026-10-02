package co.edu.sena.inventario.servlet;

import co.edu.sena.inventario.model.Producto;
import co.edu.sena.inventario.service.InventarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * Servlet principal para gestionar las operaciones del inventario.
 */
@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {

    private InventarioService servicio;

    @Override
    public void init() {
        servicio = new InventarioService();
    }

    /**
     * GET: listar, buscar, mostrar formulario de edición y eliminar.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("nuevo".equals(accion)) {
            request.getRequestDispatcher("/producto-form.jsp").forward(request, response);
            return;
        }

        if ("editar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Producto producto = servicio.buscarPorId(id);
            request.setAttribute("producto", producto);
            request.getRequestDispatcher("/producto-form.jsp").forward(request, response);
            return;
        }

        if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            servicio.eliminar(id);
            response.sendRedirect("productos?mensaje=Producto+eliminado");
            return;
        }

        String buscar = request.getParameter("buscar");
        request.setAttribute("productos", servicio.buscarPorNombre(buscar));
        request.getRequestDispatcher("/productos.jsp").forward(request, response);
    }

    /**
     * POST: registrar o actualizar productos.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String idTexto = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String categoria = request.getParameter("categoria");
        String cantidadTexto = request.getParameter("cantidad");
        String precioTexto = request.getParameter("precio");

        try {
            int cantidad = Integer.parseInt(cantidadTexto);
            double precio = Double.parseDouble(precioTexto);

            if (nombre == null || nombre.trim().isEmpty()
                    || categoria == null || categoria.trim().isEmpty()
                    || cantidad < 0 || precio < 0) {
                throw new IllegalArgumentException("Datos inválidos");
            }

            Producto producto = new Producto();
            producto.setNombre(nombre.trim());
            producto.setCategoria(categoria.trim());
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);

            if (idTexto == null || idTexto.isEmpty()) {
                servicio.guardar(producto);
                response.sendRedirect("productos?mensaje=Producto+registrado+correctamente");
            } else {
                producto.setId(Integer.parseInt(idTexto));
                servicio.actualizar(producto);
                response.sendRedirect("productos?mensaje=Producto+actualizado+correctamente");
            }

        } catch (Exception e) {
            request.setAttribute("error", "Verifique los datos ingresados.");
            request.setAttribute("producto", new Producto());
            request.getRequestDispatcher("/producto-form.jsp").forward(request, response);
        }
    }
}

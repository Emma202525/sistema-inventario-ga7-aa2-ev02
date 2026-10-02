<%@ page import="java.util.List" %>
<%@ page import="co.edu.sena.inventario.model.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    String mensaje = request.getParameter("mensaje");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inventario</title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<header>
    <h1>Inventario de productos</h1>
</header>

<main class="contenedor">
    <% if (mensaje != null) { %>
        <div class="mensaje"><%= mensaje %></div>
    <% } %>

    <div class="barra">
        <form action="productos" method="get">
            <input type="text" name="buscar" placeholder="Buscar por nombre">
            <button type="submit">Buscar</button>
        </form>
        <a class="boton" href="productos?accion=nuevo">+ Nuevo producto</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Producto</th>
            <th>Categoría</th>
            <th>Cantidad</th>
            <th>Precio</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <% if (productos != null && !productos.isEmpty()) {
            for (Producto p : productos) { %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getNombre() %></td>
                <td><%= p.getCategoria() %></td>
                <td><%= p.getCantidad() %></td>
                <td>$ <%= String.format("%,.0f", p.getPrecio()) %></td>
                <td>
                    <a href="productos?accion=editar&id=<%= p.getId() %>">Editar</a>
                    |
                    <a href="productos?accion=eliminar&id=<%= p.getId() %>"
                       onclick="return confirm('¿Desea eliminar este producto?');">Eliminar</a>
                </td>
            </tr>
        <% }} else { %>
            <tr>
                <td colspan="6">No hay productos registrados.</td>
            </tr>
        <% } %>
        </tbody>
    </table>

    <p><a href="index.jsp">Volver al inicio</a></p>
</main>
</body>
</html>

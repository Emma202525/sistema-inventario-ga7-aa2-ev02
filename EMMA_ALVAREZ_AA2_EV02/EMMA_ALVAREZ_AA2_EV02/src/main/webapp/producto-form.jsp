<%@ page import="co.edu.sena.inventario.model.Producto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Producto producto = (Producto) request.getAttribute("producto");
    boolean editar = producto != null && producto.getId() > 0;
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><%= editar ? "Editar producto" : "Nuevo producto" %></title>
    <link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<header>
    <h1><%= editar ? "Editar producto" : "Registrar producto" %></h1>
</header>

<main class="contenedor">
    <% if (error != null) { %>
        <div class="error"><%= error %></div>
    <% } %>

    <form class="formulario" action="productos" method="post">
        <% if (editar) { %>
            <input type="hidden" name="id" value="<%= producto.getId() %>">
        <% } %>

        <label>Nombre del producto</label>
        <input type="text" name="nombre"
               value="<%= editar ? producto.getNombre() : "" %>"
               required maxlength="80">

        <label>Categoría</label>
        <input type="text" name="categoria"
               value="<%= editar ? producto.getCategoria() : "" %>"
               required maxlength="50">

        <label>Cantidad</label>
        <input type="number" name="cantidad" min="0"
               value="<%= editar ? producto.getCantidad() : 0 %>" required>

        <label>Precio</label>
        <input type="number" name="precio" min="0" step="0.01"
               value="<%= editar ? producto.getPrecio() : 0 %>" required>

        <button type="submit"><%= editar ? "Actualizar" : "Guardar" %></button>
        <a class="boton secundario" href="productos">Cancelar</a>
    </form>
</main>
</body>
</html>

# Descripción del módulo

## Nombre
Módulo de gestión de inventario.

## Objetivo
Permitir a una pequeña tienda registrar y administrar los productos disponibles en su inventario.

## Alcance
El módulo implementa:
- Registro de productos.
- Consulta de productos.
- Búsqueda por nombre.
- Actualización de productos.
- Eliminación de productos.

## Datos manejados
- ID.
- Nombre.
- Categoría.
- Cantidad.
- Precio.

## Arquitectura
Se utiliza una estructura sencilla por capas:
- `model`: representa los datos.
- `service`: contiene la lógica de negocio.
- `servlet`: recibe las solicitudes HTTP y coordina las operaciones.
- `jsp`: presenta la información al usuario.

## Métodos HTTP
GET se utiliza para consultas, búsqueda, edición y eliminación.
POST se utiliza para registrar y actualizar información.

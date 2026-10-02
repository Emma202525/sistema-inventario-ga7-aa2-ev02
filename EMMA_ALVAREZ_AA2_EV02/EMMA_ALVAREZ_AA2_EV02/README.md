# Sistema de Inventario para Tiendas

## Evidencia
GA7-220501096-AA2-EV02 - Módulos de software codificados y probados.

## Descripción
Aplicación web básica para administrar el inventario de una tienda. Permite registrar, consultar, editar y eliminar productos.

## Tecnologías
- Java 11
- Jakarta Servlets 6
- JSP
- HTML5
- CSS3
- Maven
- Git/GitHub
- JUnit 5
- Servidor recomendado: Apache Tomcat 10.1

## Funcionalidades
1. Listar productos.
2. Registrar productos mediante formulario HTML.
3. Editar productos.
4. Eliminar productos.
5. Buscar productos por nombre.
6. Mostrar alertas de operación.
7. Validar datos básicos del formulario.

## Métodos HTTP utilizados
- GET: consulta, búsqueda, edición y eliminación.
- POST: registro y actualización.

## Estructura
src/main/java/co/edu/sena/inventario/
- model/Producto.java
- service/InventarioService.java
- servlet/ProductoServlet.java

src/main/webapp/
- index.jsp
- productos.jsp
- producto-form.jsp
- css/estilos.css
- WEB-INF/web.xml

## Ejecución
1. Instalar JDK 11 o superior y Maven.
2. Instalar Apache Tomcat 10.1.
3. Abrir el proyecto en NetBeans, IntelliJ IDEA o Eclipse como proyecto Maven.
4. Ejecutar `mvn clean test package`.
5. Copiar `target/sistema-inventario.war` a la carpeta `webapps` de Tomcat.
6. Iniciar Tomcat.
7. Abrir:
   http://localhost:8080/sistema-inventario/

## Versionamiento
Crear un repositorio en GitHub y ejecutar:

git init
git add .
git commit -m "GA7-220501096-AA2-EV02 - modulo inventario"
git branch -M main
git remote add origin URL_DEL_REPOSITORIO
git push -u origin main

## Nota
El proyecto utiliza almacenamiento en memoria para mantenerlo sencillo y apropiado para la evidencia. Al reiniciar el servidor, los datos de ejemplo vuelven a cargarse.

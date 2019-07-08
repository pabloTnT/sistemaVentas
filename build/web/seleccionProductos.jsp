<%-- 
    Document   : listarBodegas
    Created on : 07-07-2019, 20:31:13
    Author     : PabloTnT
--%>

<%@page import="negocio.ProductoDto"%>
<%@page import="datos.daoImpl.ProductoDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    </head>
    <body background="imagenes/fondoSistemaVentas.jpg">
        <ul class="h-menu mega">
            <li><a href="seleccionModulo.jsp"><i style="margin-right: 15px" class="fas fa-home"></i>Inicio</a></li>
            <li>
                <a href="#" class="dropdown-toggle">Bodegas</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearBodega.jsp">Crear Bodega</a></li>
                    <li><a href="listarBodegas.jsp">Listar Bodegas</a></li>
                </ul>
            </li>
            <li>
                <a href="#" class="dropdown-toggle">Productos</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearProducto.jsp">Crear Producto</a></li>
                    <li><a href="listarProductos.jsp">Listar Productos</a></li>
                </ul>
            </li>
            <li>
                <a href="#" class="dropdown-toggle">Proveedores</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearProveedor.jsp">Crear Proveedor</a></li>
                    <li><a href="listarProveedores.jsp">Listar Proveedores</a></li>
                </ul>
            </li>
            <li>
                <a href="#" class="dropdown-toggle">Usuarios</a>
                <ul class="d-menu" data-role="dropdown">
                    <li><a href="crearUsuario.jsp">Crear Usuario</a></li>
                    <li><a href="listarUsuarios.jsp">Listar Usuarios</a></li>
                </ul>
            </li>
        </ul> 
        <form action="Productos_controller.do" method="post">
            <div style="margin-left: 200px; margin-right: 200px; margin-top: 100px">
                <table class="table" data-role="table" data-show-search="false" data-rows="10" data-show-rows-steps="false">
                    <thead>
                        <tr>
                            <th data-sortable="true" data-sort-dir="asc">ID</th>
                            <th data-sortable="true">Nombre Producto</th>
                            <th data-sortable="true">Precio</th>
                            <th data-sortable="true" data-format="money">Stock</th>
                            <th data-sortable="true">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ProductoDaoImpl prod = new ProductoDaoImpl();
                            for (ProductoDto dto : prod.listarProducto()) {
                                int idProd = dto.getIdProducto();
                                String nombre = dto.getNombre();
                                int precioProd = dto.getPrecio();
                                int stock = dto.getStock();

                        %>
                        <tr>
                            <td><%=idProd%></td>
                            <td><%=nombre%></td>
                            <td><%=precioProd%></td>
                            <td><%=stock%></td>
                            <td>
                                <button class="button success outline" name="btn_editarProducto"  data-role="hint"
                                        data-hint-text="Editar Productos" onClick="window.open('editarProductos.jsp?codProducto='+<%=idProd%>, '_blank', 'width=1000,height=600');
                                                return false"> <i class="fas fa-edit"></i></button>
                                <button class="button success outline" name="btn_editarProducto"  data-role="hint"
                                        data-hint-text="Eliminar Productos" value="<%=idProd%>" name="btn_eliminarProducto"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <%
                                    }
                        %>
                    </tbody>
                </table>
            </div>
        </form>
                    <script>
                        function actualizar(){location.reload(true);}
                        setInterval("actualizar()",4000);
                    </script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>

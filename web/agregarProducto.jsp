<%-- 
Document   : admSistema
Created on : 08-07-2019, 17:29:55
Author     : PabloTnT
--%>

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
        <%
            if (request.getParameter("agregado") != null) {
        %>
        <script>
            opener.location.reload();
            window.close();
        </script>
        <%
            }
        %>
        <form action="Administrador_controller.do" method="post">
            <div align="center">
                <div style="margin-top: 150px" id="crearProductos">
                    <table>
                        <tr>
                            <td><h6>ID: </h6></td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="text" name="txt_idProducto"></td>
                        </tr>
                        <tr>
                            <td><h6>Nombre:</h6></td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="text" name="txt_nombreProducto"></td>
                        </tr>
                        <tr>
                            <td><h6>Stock:</h6> </td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="text" name="txt_stock"></td>
                        </tr>
                        <tr>
                            <td><h6>Precio:</h6> </td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="text" name="txt_precio"></td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 50px; width: 200px" class="button success rounded" name="btn_guardarProducto">Guardar</button>
                </div>
            </div>

        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>

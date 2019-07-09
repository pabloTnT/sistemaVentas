<%-- 
    Document   : creacionUsuario
    Created on : 28-05-2019, 20:06:07
    Author     : PabloTnT
--%>

<%@page session="true" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet"  href="estilos/estiloPrincipal.css">
        <link rel="stylesheet" href="https://cdn.metroui.org.ua/v4/css/metro-all.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body background="imagenes/fondoSistemaVentas.jpg">
        <form action="Administrador_controller.do" method="post">
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
            <div align="center">
                <div style="margin-top: 150px" id="crearProductos">
                    <table>
                        <tr>
                            <td><h6>Usuario:</h6> </td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="text" name="txt_idUsuario"></td>
                        </tr>
                        <tr>
                            <td><h6>Nombre:</h6> </td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="text" name="txt_nombreUsuario"></td>
                        </tr>
                        <tr>
                            <td><h6>Apellidos:</h6> </td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="text" name="txt_apellidosUsuario"></td>
                        </tr>
                        <tr>
                            <td><h6>Contraseña:</h6> </td>
                            <td><input style="margin-left: 15px" class="inputModulos" type="password" name="txt_contraUsuario"></td>
                        </tr>
                    </table>
                    <button align="center" style="margin-top: 50px; width: 200px" class="button success rounded" name="btn_guardarUsuario">Guardar</button>
                </div>
            </div>

        </form>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.metroui.org.ua/v4/js/metro.min.js"></script>
    </body>
</html>

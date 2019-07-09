<%-- 
    Document   : agregaCompra
    Created on : 08-07-2019, 21:32:28
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
    </head>
    <body background="imagenes/fondoSistemaVentas.jpg">
        <form action="Carrocompras_controller.do" method="post">
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
            <div align="center" style="margin-top: 250px">
                <%
                    int idProducto = Integer.valueOf(request.getParameter("idProd"));
                    ProductoDaoImpl dao = new ProductoDaoImpl();
                    ProductoDto producto = dao.seleccionarPorId(idProducto);
                    String nombreProducto = producto.getNombre();
                    int codProducto = producto.getIdProducto();
                %>
                <table>
                    <tr>
                        <td>Cod. Producto:</td>
                        <td><input type="text" name="txt_codProducto" style="margin-left: 20px" readonly="readonly" value="<%=codProducto%>"></td>
                    </tr>
                    <tr>
                        <td>Producto:</td>
                        <td><input type="text" style="margin-left: 20px; margin-top: 20px" readonly="readonly" value="<%=nombreProducto%>"</td>
                    </tr>
                    <tr>
                        <td>Cantidad:</td>
                        <td>
                            <select name="opt_cantidad">
                                <%
                                    int cantidad = producto.getStock();
                                    int cant = 0;
                                    for (cant = 0; cant <= cantidad; cant++) {
                                %>
                                <option value="<%=cant%>"><%=cant%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
            <div align="center">
                <button class="button success" name="btn_agregarProductos" style="margin-top: 50px">Aceptar</button>
            </div>
        </form>
    </body>
</html>

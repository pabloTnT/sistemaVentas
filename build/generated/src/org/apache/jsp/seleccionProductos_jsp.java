package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import negocio.ProductoDto;
import datos.daoImpl.ProductoDaoImpl;

public final class seleccionProductos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\"  href=\"estilos/estiloPrincipal.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.metroui.org.ua/v4/css/metro-all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.2/css/all.css\" integrity=\"sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body background=\"imagenes/fondoSistemaVentas.jpg\">\n");
      out.write("        <form action=\"Productos_controller.do\" method=\"post\">\n");
      out.write("            <div style=\"margin-left: 200px; margin-right: 200px; margin-top: 100px\">\n");
      out.write("                <table class=\"table\" data-role=\"table\" data-show-search=\"false\" data-rows=\"10\" data-show-rows-steps=\"false\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr>\n");
      out.write("                            <th data-sortable=\"true\" data-sort-dir=\"asc\">ID</th>\n");
      out.write("                            <th data-sortable=\"true\">Nombre Producto</th>\n");
      out.write("                            <th data-sortable=\"true\">Precio</th>\n");
      out.write("                            <th data-sortable=\"true\">Stock</th>\n");
      out.write("                            <th data-sortable=\"true\">Opciones</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        ");

                            ProductoDaoImpl prod = new ProductoDaoImpl();
                            for (ProductoDto dto : prod.listarProducto()) {
                                int idProd = dto.getIdProducto();
                                String nombre = dto.getNombre();
                                int precioProd = dto.getPrecio();
                                int stock = dto.getStock();

                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td>");
      out.print(idProd);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(nombre);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(precioProd);
      out.write("</td>\n");
      out.write("                            <td>");
      out.print(stock);
      out.write("</td>\n");
      out.write("                            <td>\n");
      out.write("                                <button class=\"button success\" name=\"btn_editarProducto\"  data-role=\"hint\"\n");
      out.write("                                        data-hint-text=\"Agregar Productos\" onClick=\"window.open('agregaCompra.jsp?idProd8='+");
      out.print(idProd);
      out.write(", '_blank', 'width=1000,height=600');\n");
      out.write("                                                return false\"> <i class=\"fas fa-plus\"></i></button>\n");
      out.write("                                <button class=\"button success\" name=\"btn_editarProducto\"  data-role=\"hint\"\n");
      out.write("                                        data-hint-text=\"Quitar Productos\" value=\"");
      out.print(idProd);
      out.write("\" name=\"btn_eliminarProducto\"><i class=\"fas fa-times-circle\"></i></button>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");

                                    }
                        
      out.write("\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.metroui.org.ua/v4/js/metro.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

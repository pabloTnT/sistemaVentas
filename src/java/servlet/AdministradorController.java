/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.daoImpl.ProductoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.ProductoDto;

/**
 *
 * @author PROGESA
 */
public class AdministradorController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("btn_guardarProducto") != null) {
                ProductoDaoImpl producto = new ProductoDaoImpl();
                int codigoProducto = Integer.valueOf(request.getParameter("txt_idProducto"));
                String nombreProducto = request.getParameter("txt_nombreProducto");
                int stock = Integer.valueOf(request.getParameter("txt_stock"));
                int precio = Integer.valueOf(request.getParameter("txt_precio"));
                ProductoDto dto = new ProductoDto();
                dto.setIdProducto(codigoProducto);
                dto.setNombre(nombreProducto);
                dto.setStock(stock);
                dto.setPrecio(precio);
                try {
                    producto.crearProducto(dto);
                } catch (Exception ex) {
                    Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("agregarProducto.jsp?agregado="+"ok");
            }
            if(request.getParameter("btn_eliminarProducto")!=null){
                int codProducto = Integer.valueOf(request.getParameter("btn_eliminarProducto"));
                ProductoDaoImpl dao = new ProductoDaoImpl();
                try {
                    dao.eliminarProducto(codProducto);
                } catch (Exception ex) {
                    Logger.getLogger(AdministradorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect("vistaAdministrador.jsp?eliminarProducto="+"ok");
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoImpl;

import datos.Conexion;
import datos.dao.ProductoDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.ProductoDto;

/**
 *
 * @author PabloTnT
 */
public class ProductoDaoImpl implements ProductoDao{

    private static final String SQL_INSERT = "INSERT INTO producto (id_producto, nombre, stock, precio) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre=?, stock=?, precio=? WHERE id_producto=?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_producto = ?";
    private static final String SQL_SELECTALL = "SELECT * FROM producto";
    private static final String SQL_SELECTID = "SELECT * FROM producto WHERE id_producto = ?";

    private static final Conexion conn = Conexion.estadoConexion();
    
        @Override
    public boolean crearProducto(ProductoDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getIdProducto());
            ps.setString(2, dto.getNombre());
            ps.setInt(3, dto.getStock());
            ps.setInt(4, dto.getStock());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    

    @Override
    public boolean eliminarProducto(Object key) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    

    @Override
    public boolean modificarProducto(ProductoDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre());
            ps.setInt(2, dto.getStock());
            ps.setInt(3, dto.getStock());
            ps.setInt(4, dto.getIdProducto());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    

    @Override
    public List<ProductoDto> listarProducto() throws Exception {
        PreparedStatement ps;
        ResultSet res;
        List<ProductoDto> prod = new ArrayList();
        try {
            ps = conn.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                prod.add(mapear(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return prod;
    }

    @Override
    public ProductoDto seleccionarPorId(Object key) throws Exception {
        PreparedStatement ps;
        ResultSet res;
        ProductoDto prod = null;
        try {

            ps = conn.getCnn().prepareStatement(SQL_SELECTID);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                prod = mapear(res);
            }
            return prod;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return prod;
    }


    private static ProductoDto mapear(ResultSet res)
            throws SQLException {
        ProductoDto producto = new ProductoDto();
        producto.setIdProducto(res.getInt("id_producto"));
        producto.setNombre(res.getString("nombre"));
        producto.setStock(res.getInt("stock"));
        producto.setPrecio(res.getInt("precio"));
        return producto;
    }


}

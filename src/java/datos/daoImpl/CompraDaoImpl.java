/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoImpl;

import datos.Conexion;
import datos.dao.CompraDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.CompraDto;

/**
 *
 * @author PabloTnT
 */
public class CompraDaoImpl implements CompraDao{

    private static final String SQL_INSERT = "INSERT INTO compra ( id_usuario, id_producto, cantidad) VALUES ( ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE compra SET id_usuario=?, id_producto=?, cantidad=? WHERE id_compra=?";
    private static final String SQL_DELETE = "DELETE FROM compra WHERE id_compra = ?";
    private static final String SQL_SELECTALL = "SELECT * FROM compra";
    private static final String SQL_SELECTID = "SELECT * FROM compra WHERE id_compra = ?";

    private static final Conexion conn = Conexion.estadoConexion();

        @Override
    public boolean generarCompra(CompraDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getIdUsuario());
            ps.setInt(2, dto.getIdProducto());
            ps.setInt(3, dto.getCantidad());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    
    }

    @Override
    public boolean eliminarCompra(Object key) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    

    @Override
    public boolean modificarCompra(CompraDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getIdUsuario());
            ps.setInt(2, dto.getIdProducto());
            ps.setInt(3, dto.getCantidad());
            ps.setInt(4, dto.getIdCompra());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    

    @Override
    public List<CompraDto> listarCompras() throws Exception {
        PreparedStatement ps;
        ResultSet res;
        List<CompraDto> compra = new ArrayList();
        try {
            ps = conn.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                compra.add(mapear(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return compra;
    }

    @Override
    public CompraDto seleccionarPorId(Object key) {
        PreparedStatement ps;
        ResultSet res;
        CompraDto compra = null;
        try {

            ps = conn.getCnn().prepareStatement(SQL_SELECTID);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                compra = mapear(res);
            }
            return compra;
        } catch (SQLException ex) {
            Logger.getLogger(CompraDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return compra;
    }


    
    private static CompraDto mapear(ResultSet res)
            throws SQLException {
        CompraDto compra = new CompraDto();
        compra.setIdCompra(res.getInt("id_compra"));
        compra.setIdUsuario(res.getString("id_usuario"));
        compra.setIdProducto(res.getInt("id_producto"));
        compra.setCantidad(res.getInt("cantidad"));
        return compra;
    }


}

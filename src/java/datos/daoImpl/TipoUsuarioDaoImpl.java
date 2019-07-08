/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoImpl;

import datos.Conexion;
import datos.dao.TipoUsuarioDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.TipoUsuarioDto;

/**
 *
 * @author PabloTnT
 */
public class TipoUsuarioDaoImpl implements TipoUsuarioDao {

    private static final String SQL_INSERT = "INSERT INTO tipo_usuario (id_tipo, nombre_tipo) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE tipo_usuario SET nombre_tipo=? WHERE id_tipo=?";
    private static final String SQL_DELETE = "DELETE FROM tipo_usuario WHERE id_tipo = ?";
    private static final String SQL_SELECTALL = "SELECT * FROM tipo_usuario";
    private static final String SQL_SELECTID = "SELECT * FROM tipo_usuario WHERE id_tipo = ?";

    private static final Conexion conn = Conexion.estadoConexion();

    
        @Override
    public boolean crearTipoUsuario(TipoUsuarioDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getIdTipo());
            ps.setString(2, dto.getNombreTipo());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    

    @Override
    public boolean eliminarTipoUsuario(Object key) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    

    @Override
    public boolean modificarTipoUsuario(TipoUsuarioDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombreTipo());
            ps.setInt(2, dto.getIdTipo());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
    
    @Override
    public List<TipoUsuarioDto> listarTipoUsuarios() throws Exception {
        PreparedStatement ps;
        ResultSet res;
        List<TipoUsuarioDto> tipoUs = new ArrayList();
        try {
            ps = conn.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                tipoUs.add(mapear(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return tipoUs;
    }
    

    @Override
    public TipoUsuarioDto seleccionarPorId(Object key) throws Exception {
        PreparedStatement ps;
        ResultSet res;
        TipoUsuarioDto tipoUs = null;
        try {

            ps = conn.getCnn().prepareStatement(SQL_SELECTID);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                tipoUs = mapear(res);
            }
            return tipoUs;
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return tipoUs;
    }



    private static TipoUsuarioDto mapear(ResultSet res)
            throws SQLException {
        TipoUsuarioDto usuario = new TipoUsuarioDto();
        usuario.setIdTipo(res.getInt("id_tipo"));
        usuario.setNombreTipo(res.getString("nombre_tipo"));
        return usuario;
    }


}

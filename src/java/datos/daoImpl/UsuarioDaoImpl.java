/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.daoImpl;

import datos.Conexion;
import datos.dao.UsuarioDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.UsuarioDto;

/**
 *
 * @author PabloTnT
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private static final String SQL_INSERT = "INSERT INTO usuario (id_usuario, nombre, apellido, tipo_usuario, clave) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET nombre=?, apellido=?, tipo_usuario=?, clave=? WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
    private static final String SQL_SELECTALL = "SELECT * FROM usuario";
    private static final String SQL_SELECTID = "SELECT * FROM usuario WHERE id_usuario = ?";
    private static final String SQL_USUARIO_CONTRASEÑA = "SELECT * FROM usuario WHERE id_usuario=? AND clave=?";

    private static final Conexion conn = Conexion.estadoConexion();

    
        public boolean UsuarioContraseña(String usuario, String clave) {
        PreparedStatement ps;
        ResultSet res;
        try {
            ps = conn.getCnn().prepareStatement(SQL_USUARIO_CONTRASEÑA);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            res = ps.executeQuery();
            if (res.absolute(1)) {
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }
        
    @Override
    public boolean crearUsuario(UsuarioDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getIdUsuario());
            ps.setString(2, dto.getNombre());
            ps.setString(3, dto.getApellido());
            ps.setInt(4, dto.getTipoUsuario());
            ps.setString(5, dto.getClave());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean eliminarUsuario(Object key) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean modificarUsuario(UsuarioDto dto) throws Exception {
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombre());
            ps.setString(2, dto.getApellido());
            ps.setInt(3, dto.getTipoUsuario());
            ps.setString(4, dto.getClave());
            ps.setString(5, dto.getIdUsuario());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return false;
    }

    @Override
    public UsuarioDto seleccionarPorId(Object key) throws Exception {
        PreparedStatement ps;
        ResultSet res;
        UsuarioDto us = null;
        try {

            ps = conn.getCnn().prepareStatement(SQL_SELECTID);
            ps.setString(1, key.toString());

            res = ps.executeQuery();

            while (res.next()) {
                us = mapear(res);
            }
            return us;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return us;
    }

    @Override
    public List<UsuarioDto> listarUsuarios() throws Exception {
        PreparedStatement ps;
        ResultSet res;
        List<UsuarioDto> usuario = new ArrayList();
        try {
            ps = conn.getCnn().prepareStatement(SQL_SELECTALL);
            res = ps.executeQuery();

            while (res.next()) {
                usuario.add(mapear(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.cerrarConexion();
        }
        return usuario;
    }

    private static UsuarioDto mapear(ResultSet res)
            throws SQLException {
        UsuarioDto usuario = new UsuarioDto();
        usuario.setIdUsuario(res.getString("id_usuario"));
        usuario.setNombre(res.getString("nombre"));
        usuario.setApellido(res.getString("apellido"));
        usuario.setTipoUsuario(res.getInt("tipo_usuario"));
        usuario.setClave(res.getString("clave"));
        return usuario;
    }
}

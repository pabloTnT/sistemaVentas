/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import java.util.List;
import negocio.UsuarioDto;

/**
 *
 * @author PabloTnT
 */
public interface UsuarioDao {
    
    public boolean crearUsuario(UsuarioDto dto) throws Exception;

    public boolean eliminarUsuario(Object key) throws Exception;

    public boolean modificarUsuario(UsuarioDto dto) throws Exception;

    public UsuarioDto seleccionarPorId(Object key) throws Exception;

    public List<UsuarioDto> listarUsuarios() throws Exception;
}

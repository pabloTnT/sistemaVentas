/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import java.util.List;
import negocio.TipoUsuarioDto;

/**
 *
 * @author PabloTnT
 */
public interface TipoUsuarioDao {
    
    public boolean crearTipoUsuario(TipoUsuarioDto dto) throws Exception;

    public boolean eliminarTipoUsuario(Object key) throws Exception;

    public boolean modificarTipoUsuario(TipoUsuarioDto dto) throws Exception;

    public TipoUsuarioDto seleccionarPorId(Object key) throws Exception;

    public List<TipoUsuarioDto> listarTipoUsuarios() throws Exception;
}

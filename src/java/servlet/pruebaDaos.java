/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import datos.dao.UsuarioDao;
import datos.daoImpl.UsuarioDaoImpl;
import negocio.UsuarioDto;

/**
 *
 * @author PabloTnT
 */
public class pruebaDaos {
    
    public static void main (String [ ] args) throws Exception {

        UsuarioDao dao = new UsuarioDaoImpl();
        UsuarioDto dto = new UsuarioDto();
        dto.setIdUsuario("pablo");
        dto.setNombre("pablo");
        dto.setApellido("soto");
        dto.setClave("1234");
        dto.setTipoUsuario(1);
        dao.crearUsuario(dto);
        }
}

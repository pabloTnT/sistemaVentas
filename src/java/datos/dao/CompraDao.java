/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import java.util.List;
import negocio.CompraDto;

/**
 *
 * @author PabloTnT
 */
public interface CompraDao {

    public boolean generarCompra(CompraDto dto) throws Exception;

    public boolean eliminarCompra(Object key) throws Exception;

    public boolean modificarCompra(CompraDto dto) throws Exception;

    public CompraDto seleccionarPorId(Object key) throws Exception;

    public List<CompraDto> listarCompras() throws Exception;
}

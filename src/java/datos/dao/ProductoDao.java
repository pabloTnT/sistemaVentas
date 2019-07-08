/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.dao;

import java.util.List;
import negocio.ProductoDto;

/**
 *
 * @author PabloTnT
 */
public interface ProductoDao {
    
    public boolean crearProducto(ProductoDto dto) throws Exception;

    public boolean eliminarProducto(Object key) throws Exception;

    public boolean modificarProducto(ProductoDto dto) throws Exception;

    public ProductoDto seleccionarPorId(Object key) throws Exception;

    public List<ProductoDto> listarProducto() throws Exception;
}

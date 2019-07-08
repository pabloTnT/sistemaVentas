/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author PabloTnT
 */
public class CompraDto {
    private int idCompra;
    private String idUsuario;
    private int idProducto;
    private int cantidad;

    public CompraDto() {
        idCompra=0;
        idUsuario = null;
        idProducto = 0;
        cantidad = 0;
    }

    public CompraDto(int idCompra, String idUsuario, int idProducto, int cantidad) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdCompra(){
        return idCompra;
    }
    
    public void setIdCompra(int idCompra){
        this.idCompra = idCompra;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}

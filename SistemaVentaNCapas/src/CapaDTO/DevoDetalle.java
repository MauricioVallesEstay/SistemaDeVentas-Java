/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

/**
 *
 * @author xTheBlackKeYx
 */
public class DevoDetalle {
    private int idDevoDetalle;
    private String codProducto;
    private String descProducto;
    private int  cantidad;
    private int idDevoCabecera;

    /**
     * @return the idDevoDetalle
     */
    public int getIdDevoDetalle() {
        return idDevoDetalle;
    }

    /**
     * @param idDevoDetalle the idDevoDetalle to set
     */
    public void setIdDevoDetalle(int idDevoDetalle) {
        this.idDevoDetalle = idDevoDetalle;
    }

    /**
     * @return the codProducto
     */
    public String getCodProducto() {
        return codProducto;
    }

    /**
     * @param codProducto the codProducto to set
     */
    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    /**
     * @return the descProducto
     */
    public String getDescProducto() {
        return descProducto;
    }

    /**
     * @param descProducto the descProducto to set
     */
    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precioProducto
     */

    /**
     * @return the idDevoCabecera
     */
    public int getIdDevoCabecera() {
        return idDevoCabecera;
    }

    /**
     * @param idDevoCabecera the idDevoCabecera to set
     */
    public void setIdDevoCabecera(int idDevoCabecera) {
        this.idDevoCabecera = idDevoCabecera;
    }
    
    
    
}

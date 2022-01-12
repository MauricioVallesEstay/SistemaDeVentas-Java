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
public class DetalleVenta {
    private int idDetalleVenta;
    private String cod_pro;
    private int cantidad;
    private double precio;
    private int idVentaCabecera;

    /**
     * @return the idDetalleVenta
     */
    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    /**
     * @param idDetalleVenta the idDetalleVenta to set
     */
    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    /**
     * @return the cod_pro
     */
    public String getCod_pro() {
        return cod_pro;
    }

    /**
     * @param cod_pro the cod_pro to set
     */
    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
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
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the idVentaCabecera
     */
    public int getIdVentaCabecera() {
        return idVentaCabecera;
    }

    /**
     * @param idVentaCabecera the idVentaCabecera to set
     */
    public void setIdVentaCabecera(int idVentaCabecera) {
        this.idVentaCabecera = idVentaCabecera;
    }
    
    
}

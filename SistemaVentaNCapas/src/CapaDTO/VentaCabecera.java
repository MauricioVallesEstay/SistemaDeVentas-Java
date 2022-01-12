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
public class VentaCabecera {
    private int idVentaCabecera;
    private String cliente;
    private String vendedor;
    private String fecha;
    private double total;
    
    
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

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vendedor
     */
    public String getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
}

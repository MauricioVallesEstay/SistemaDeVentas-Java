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
public class Despacho {
    private int idDespacho;
    private String cliente;
    private String direccion;
    private String repartidor;
    private String fecha;

    /**
     * @return the idDespacho
     */
    public int getIdDespacho() {
        return idDespacho;
    }

    /**
     * @param idDespacho the idDespacho to set
     */
    public void setIdDespacho(int idDespacho) {
        this.idDespacho = idDespacho;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the repartidor
     */
    public String getRepartidor() {
        return repartidor;
    }

    /**
     * @param repartidor the repartidor to set
     */
    public void setRepartidor(String repartidor) {
        this.repartidor = repartidor;
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
    
    
    
}

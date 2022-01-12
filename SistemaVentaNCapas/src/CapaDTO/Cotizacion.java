/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDTO;

/**
 *
 * @author crist
 */
public class Cotizacion {
    
    private int idCotizacion;
    private String nombreTienda;
    private String direccionTienda;
    private int telefonoTienda;
    private String urlPagTienda;
    private String distribucion;
    
    
    
    // Setters and Getters

    /**
     * @return the idCotizacion
     */
    public int getIdCotizacion() {
        return idCotizacion;
    }

    /**
     * @param idCotizacion the idCotizacion to set
     */
    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    /**
     * @return the nombreTienda
     */
    public String getNombreTienda() {
        return nombreTienda;
    }

    /**
     * @param nombreTienda the nombreTienda to set
     */
    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    /**
     * @return the direccionTienda
     */
    public String getDireccionTienda() {
        return direccionTienda;
    }

    /**
     * @param direccionTienda the direccionTienda to set
     */
    public void setDireccionTienda(String direccionTienda) {
        this.direccionTienda = direccionTienda;
    }

    /**
     * @return the telefonoTienda
     */
    public int getTelefonoTienda() {
        return telefonoTienda;
    }

    /**
     * @param telefonoTienda the telefonoTienda to set
     */
    public void setTelefonoTienda(int telefonoTienda) {
        this.telefonoTienda = telefonoTienda;
    }

    /**
     * @return the urlPagTienda
     */
    public String getUrlPagTienda() {
        return urlPagTienda;
    }

    /**
     * @param urlPagTienda the urlPagTienda to set
     */
    public void setUrlPagTienda(String urlPagTienda) {
        this.urlPagTienda = urlPagTienda;
    }

    /**
     * @return the distribucion
     */
    public String getDistribucion() {
        return distribucion;
    }

    /**
     * @param distribucion the distribucion to set
     */
    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
    }
    
    // FIN Setters and Getters
}

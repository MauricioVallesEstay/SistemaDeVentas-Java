/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySql;
import CapaDTO.Cotizacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NegocioCotizacion{
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    
    // Guardar cotizacion
    public void insertarCotizacion(Cotizacion cotizacion){
        String sql = "INSERT INTO cotizacion (nomTienda, direccion, telefono, urlPagTienda, distribucion)"
                + " VALUES (?,?,?,?,?)";
                
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cotizacion.getNombreTienda());
            ps.setString(2, cotizacion.getDireccionTienda());
            ps.setInt(3, cotizacion.getTelefonoTienda());
            ps.setString(4, cotizacion.getUrlPagTienda());
            ps.setString(5, cotizacion.getDistribucion());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    //Eliminar Cliente
    public boolean EliminarCotizacion(int idCotizacion){
        String sql = "DELETE FROM cotizacion WHERE idCotizacion = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCotizacion);
            ps.execute();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    //modificar Cliente
    public boolean actualizarCotizacion(Cotizacion cotizacion){
        String sql = "UPDATE cotizacion SET nomTienda=?, direccion=?, telefono=?, urlPagTienda=?, distribucion=? "
                + "WHERE idCotizacion=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, cotizacion.getNombreTienda());
            ps.setString(2, cotizacion.getDireccionTienda());
            ps.setInt(3, cotizacion.getTelefonoTienda());
            ps.setString(4, cotizacion.getUrlPagTienda());
            ps.setString(5, cotizacion.getDistribucion());
            ps.setInt(6, cotizacion.getIdCotizacion());
            ps.execute();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    //Listar Cliente
   public List listarCotizacion(){
       List<Cotizacion> ListaCotizacion = new ArrayList();
       String sql = "SELECT * FROM cotizacion";
       try
       {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               Cotizacion cotizacion = new Cotizacion();
               cotizacion.setIdCotizacion(rs.getInt("idCotizacion"));
               cotizacion.setNombreTienda(rs.getString("nomTienda"));
               cotizacion.setDireccionTienda(rs.getString("direccion"));
               cotizacion.setTelefonoTienda(rs.getInt("Telefono"));
               cotizacion.setUrlPagTienda(rs.getString("urlPagTienda"));
               cotizacion.setDistribucion(rs.getString("distribucion"));
               ListaCotizacion.add(cotizacion);
           }
       }catch(Exception ex){
           System.out.println(ex.toString());
       }
       return ListaCotizacion;
   }
    
}

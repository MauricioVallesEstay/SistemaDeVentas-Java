/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;
 
import CapaConexion.ConexionMySql;
import CapaDTO.Repartidor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
 
 
/**
 *
 * @author Crist
 */
public class NegocioRepartidor {
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    
    // Guardar CLiente
    public void insertarRepartidor(Repartidor repartidor){
        String sql = "INSERT INTO repartidor (rutRepartidor, nomRepartidor, direccion, telefono) VALUES (?,?,?,?)";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, repartidor.getRutRepartidor());
            ps.setString(2, repartidor.getNombreRepartidor());
            ps.setString(3, repartidor.getDireccion());
            ps.setInt(4, repartidor.getTelefono());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    //Eliminar Cliente
    public boolean eliminarRepartidor(int idRepartidor){
        String sql = "DELETE FROM repartidor WHERE idRepartidor = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idRepartidor);
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
    public boolean actualizarRepartidor(Repartidor repartidor){
        String sql = "UPDATE repartidor SET rutRepartidor=?, nomRepartidor=?, direccion=?,"
                + " Telefono=?  WHERE idRepartidor=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, repartidor.getRutRepartidor());
            ps.setString(2, repartidor.getNombreRepartidor());
            ps.setString(3, repartidor.getDireccion());
            ps.setInt(4, repartidor.getTelefono());
            ps.setInt(5, repartidor.getIdRepartidor());
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
   public List ListarRepartidor(){
       List<Repartidor> ListaRepartidor = new ArrayList();
       String sql = "SELECT * FROM repartidor";
       try
       {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               Repartidor repartidor = new Repartidor();
               repartidor.setIdRepartidor(rs.getInt("idRepartidor"));
               repartidor.setRutRepartidor(rs.getString("rutRepartidor"));
               repartidor.setNombreRepartidor(rs.getString("nomRepartidor"));
               repartidor.setDireccion(rs.getString("direccion"));
               repartidor.setTelefono(rs.getInt("Telefono"));
               ListaRepartidor.add(repartidor);
           }
       }catch(Exception ex){
           System.out.println(ex.toString());
       }
       return ListaRepartidor;
   }
   
   
   public Repartidor BuscarRepartidor(int rutRepartidor){
       Repartidor repartidor = new Repartidor();
       String sql = "SELECT * FROM repartidor WHERE rutRepartidor = ?";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, rutRepartidor);
           rs = ps.executeQuery();
           if(rs.next()){
               repartidor.setIdRepartidor(rs.getInt("idRepartidor"));
               repartidor.setNombreRepartidor(rs.getString("nomRepartidor"));
           }
       }catch(SQLException ex){
           System.out.println(ex.toString());
       }
       return repartidor;
   }
}
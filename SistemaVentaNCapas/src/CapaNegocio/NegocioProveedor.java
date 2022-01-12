/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySql;
import CapaDTO.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author xTheBlackKeYx
 */
public class NegocioProveedor
{
   Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    
    // Guardar CLiente
    public void insertarProveedor(Proveedor proveedor){
        String sql = "INSERT INTO proveedor (rutProveedor, nomProveedor, direccion, Telefono"
                + ", correo ) VALUES (?,?,?,?,?)";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getRutProveedor());
            ps.setString(2, proveedor.getNombreProveedor());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    //Eliminar Cliente
    public boolean eliminarProveedor(int idProveedor){
        String sql = "DELETE FROM proveedor WHERE idProveedor = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
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
    public boolean actualizarProveedor(Proveedor proveedor){
        String sql = "UPDATE proveedor SET rutProveedor=?, nomProveedor=?, direccion=?, Telefono=?, correo=? "
                + "WHERE idProveedor=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, proveedor.getRutProveedor());
            ps.setString(2, proveedor.getNombreProveedor());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getCorreo());
            ps.setInt(6, proveedor.getIdProveedor());
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
    
    
   public List listarProveedor(){
       List<Proveedor> ListaProveedor = new ArrayList();
       String sql = "SELECT * FROM proveedor";
       try
       {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               Proveedor proveedor = new Proveedor();
               proveedor.setIdProveedor(rs.getInt("idProveedor"));
               proveedor.setRutProveedor(rs.getString("rutProveedor"));
               proveedor.setNombreProveedor(rs.getString("nomProveedor"));
               proveedor.setDireccion(rs.getString("direccion"));
               proveedor.setTelefono(rs.getInt("Telefono"));
               proveedor.setCorreo(rs.getString("correo"));
               ListaProveedor.add(proveedor);
           }
       }catch(Exception ex){
           System.out.println(ex.toString());
       }
       return ListaProveedor;
   }
    
}
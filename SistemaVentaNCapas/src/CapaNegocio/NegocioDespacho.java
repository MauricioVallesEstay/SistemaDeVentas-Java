/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySql;
import CapaDTO.Despacho;
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
public class NegocioDespacho {
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    
    public void generarDespacho(Despacho despacho){
        String sql = "INSERT INTO despacho (cliente, direccion, repartidor, fecha) VALUES (?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, despacho.getCliente());
            ps.setString(2, despacho.getDireccion());
            ps.setString(3, despacho.getRepartidor());
            ps.setString(4, despacho.getFecha());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    
    public List ListarDespacho(){
        List<Despacho> ListaDespacho = new ArrayList();
        String sql = "SELECT * FROM despacho";
        try{
            con= cn.getConnection();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Despacho despacho = new Despacho();
                despacho.setIdDespacho(rs.getInt("idDespacho"));
                despacho.setCliente(rs.getString("cliente"));
                despacho.setDireccion(rs.getString("direccion"));
                despacho.setRepartidor(rs.getString("repartidor"));
                despacho.setFecha(rs.getString("fecha"));
                ListaDespacho.add(despacho);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return ListaDespacho;
    }
    
    
    public boolean EliminarDespacho(int idDespacho){
        String sql = "DELETE FROM despacho WHERE idDespacho = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDespacho);
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
    
    
    
    
}

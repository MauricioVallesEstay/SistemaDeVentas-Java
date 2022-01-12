/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySql;
import CapaDTO.DevoCabecera;
import CapaDTO.DevoDetalle;
import CapaDTO.Producto;
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
public class NegocioDevolucion {
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    
    public void RegistrarDevoCabecera(DevoCabecera devoCabecera){
        String sql = "INSERT INTO devoCabecera (cliente, idVenta, situacion, observacion, OpDevolucion) "
                + "VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, devoCabecera.getCliente());
            ps.setInt(2, devoCabecera.getIdVenta());
            ps.setString(3, devoCabecera.getSituacion());
            ps.setString(4, devoCabecera.getObservacion());
            ps.setString(5, devoCabecera.getOpDevolucion());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        
    }
    
    public void RegistrarDevoDetalle(DevoDetalle devoDetalle){
        String sql = "INSERT INTO devoDetalle (cod_producto, descProducto,  cantidad) "
                + "VALUES (?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, devoDetalle.getCodProducto());
            ps.setString(2, devoDetalle.getDescProducto());
            ps.setInt(3, devoDetalle.getCantidad());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        
    }
    
    public List ListarDevoProducto(){
        List<DevoDetalle> ListDevoPro = new ArrayList();
        String sql = "SELECT * FROM devoDetalle";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                DevoDetalle devoDetalle = new DevoDetalle();
                devoDetalle.setIdDevoDetalle(rs.getInt("idDevoDetalle"));
                devoDetalle.setCodProducto(rs.getString("cod_producto"));
                devoDetalle.setDescProducto(rs.getString("descProducto"));
                devoDetalle.setCantidad(rs.getInt("cantidad"));
                ListDevoPro.add(devoDetalle);
            }          
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return ListDevoPro;
    }
    
    
    public List ListarDevoInfo(){
        List<DevoCabecera> ListaDevoInfo = new ArrayList();
        String sql = "SELECT * FROM DevoCabecera";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                DevoCabecera devoCabecera = new DevoCabecera();
                devoCabecera.setCliente(rs.getString("Cliente"));
                devoCabecera.setIdVenta(rs.getInt("IdVenta"));
                devoCabecera.setSituacion(rs.getString("situacion"));
                devoCabecera.setObservacion(rs.getString("observacion"));
                devoCabecera.setOpDevolucion(rs.getString("OpDevolucion"));
                ListaDevoInfo.add(devoCabecera);
            }          
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return ListaDevoInfo;
        
    }
    
    
    
}

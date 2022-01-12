/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaConexion.ConexionMySql;
import CapaDTO.Reclamo;
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
public class NegocioReclamo {
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void GenerarReclamo(Reclamo reclamo){
        String sql = "INSERT INTO reclamo (rutCliente, nomCliente, comentario, fecha, idVenta) VALUES (?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reclamo.getRutCliente());
            ps.setString(2, reclamo.getNomCliente());
            ps.setString(3, reclamo.getComentario());
            ps.setString(4, reclamo.getFecha());
            ps.setInt(5, reclamo.getIdVenta());
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public List ListarReclamo(){
        List<Reclamo> ListaReclamo = new ArrayList();
        String sql = "SELECT * FROM reclamo";
        try{
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Reclamo reclamo = new Reclamo();
                reclamo.setIdReclamo(rs.getInt("idReclamo"));
                reclamo.setIdVenta(rs.getInt("idVenta"));
                reclamo.setRutCliente(rs.getString("rutCliente"));
                reclamo.setNomCliente(rs.getString("nomCliente"));
                reclamo.setFecha(rs.getString("fecha"));
                reclamo.setComentario(rs.getString("comentario"));
                ListaReclamo.add(reclamo);
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return ListaReclamo;
    }
    
    public boolean eliminarReclamo(int idReclamo){
        String sql = "DELETE FROM reclamo WHERE idReclamo = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idReclamo);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import CapaDTO.Usuario;
import CapaConexion.ConexionMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NegocioUsuario {
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    
    
    
    public Usuario log(String correo, String pass){
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM usuario WHERE correo = ? AND pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, pass);
            rs= ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setRut(rs.getString("rutUsuario"));
                usuario.setNombre(rs.getString("nomUsuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPass(rs.getString("pass"));
                usuario.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return usuario;
    }
    
    
    
    
    
    public boolean insertarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuario (rutUsuario, nomUsuario, correo, pass, rol) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getRut());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getPass());
            ps.setString(5, usuario.getRol());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
   
    
    public List ListarUsuario(){
        List<Usuario> ListaUsuario = new ArrayList();
        String sql = "SELECT * FROM usuario";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setRut(rs.getString("rutUsuario"));
                usuario.setNombre(rs.getString("nomUsuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setPass(rs.getString("pass"));
                usuario.setRol(rs.getString("rol"));
                ListaUsuario.add(usuario);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return ListaUsuario;
    }
    
    public boolean EliminarUsuario(int idUsuario){
       String sql = "DELETE FROM usuario WHERE idUsuario = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, idUsuario);
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println(ex.toString());
           }
       }
   }
    
    public boolean ModificarUsuario(Usuario usuario){
       String sql = "UPDATE usuario SET rutUsuario=?, nomUsuario=?, correo=?, pass=?, rol=? WHERE idUsuario=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, usuario.getRut());
           ps.setString(2, usuario.getNombre());
           ps.setString(3, usuario.getCorreo());
           ps.setString(4, usuario.getPass());
           ps.setString(5, usuario.getRol());
           ps.setInt(6, usuario.getIdUsuario());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       }finally{
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
    
}    
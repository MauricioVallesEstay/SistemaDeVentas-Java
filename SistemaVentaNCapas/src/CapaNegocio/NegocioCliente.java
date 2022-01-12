
package CapaNegocio;

import CapaConexion.ConexionMySql;
import CapaDTO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class NegocioCliente{
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    
    // Guardar CLiente
    public void insertarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (rutCliente, nomCliente, direccion, Telefono"
                + ", correo ) VALUES (?,?,?,?,?)";
        try
        {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getRutCliente());
            ps.setString(2, cliente.getNombreCliente());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    //Eliminar Cliente
    public void eliminarCliente(int idCliente){
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
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
    
    //modificar Cliente
    public void actualizarCliente(Cliente cliente){
        String sql = "UPDATE cliente SET rutCliente=?, nomCliente=?, direccion=?, Telefono=?, correo=? "
                + "WHERE idCliente=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getRutCliente());
            ps.setString(2, cliente.getNombreCliente());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.setInt(6, cliente.getIdCliente());
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
    
    //Listar Cliente
   public ArrayList<Cliente> ListarCliente(){
       ArrayList<Cliente> ListaCliente = new ArrayList();
       String sql = "SELECT * FROM cliente";
       try
       {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               Cliente cliente = new Cliente();
               cliente.setIdCliente(rs.getInt("idCliente"));
               cliente.setRutCliente(rs.getString("rutCliente"));
               cliente.setNombreCliente(rs.getString("nomCliente"));
               cliente.setDireccion(rs.getString("direccion"));
               cliente.setTelefono(rs.getInt("Telefono"));
               cliente.setCorreo(rs.getString("correo"));
               ListaCliente.add(cliente);
           }
       }catch(Exception ex){
           System.out.println(ex.toString());
       }
       return ListaCliente;
   }
   
   public Cliente Buscarcliente(int rutCliente){
       Cliente cliente = new Cliente();
       String sql = "SELECT * FROM cliente WHERE rutCliente = ?";
       try {
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setInt(1, rutCliente);
           rs = ps.executeQuery();
           if (rs.next()) {
               cliente.setIdCliente(rs.getInt("idCliente"));
               cliente.setNombreCliente(rs.getString("nomCliente"));
               cliente.setDireccion(rs.getString("direccion"));
               cliente.setTelefono(rs.getInt("telefono"));
               cliente.setCorreo(rs.getString("correo"));
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return cliente;
   }
            
}
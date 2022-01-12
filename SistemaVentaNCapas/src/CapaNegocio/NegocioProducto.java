
package CapaNegocio;

import CapaConexion.ConexionMySql;
import CapaDTO.Empresa;
import CapaDTO.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class NegocioProducto {
    Connection con;
    ConexionMySql cn = new ConexionMySql();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProductos(Producto producto){
        String sql = "INSERT INTO producto (codigo, descripcion, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getProveedor());
            ps.setInt(4, producto.getStock());
            ps.setDouble(5, producto.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public void ConsultarProveedor(JComboBox proveedor){
        String sql = " SELECT nomProveedor FROM proveedor";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
               proveedor.addItem(rs.getString("nomProveedor"));
            }
        } catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    public List ListarProductos(){
        List<Producto> ListaProducto = new ArrayList();
        String sql = "SELECT * FROM producto";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setProveedor(rs.getString("proveedor"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
                ListaProducto.add(producto);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return ListaProducto;
    }
    
    public boolean EliminarProductos(int idProducto){
       String sql = "DELETE FROM producto WHERE idProducto = ?";
       try {
           ps = con.prepareStatement(sql);
           ps.setInt(1, idProducto);
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
    
    public boolean ModificarProductos(Producto producto){
       String sql = "UPDATE producto SET codigo=?, descripcion=?, proveedor=?, stock=?, precio=? WHERE idProducto=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, producto.getCodigo());
           ps.setString(2, producto.getDescripcion());
           ps.setString(3, producto.getProveedor());
           ps.setInt(4, producto.getStock());
           ps.setDouble(5, producto.getPrecio());
           ps.setInt(6, producto.getIdProducto());
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
    
    
    public Producto BuscarPro(String codigo){
      Producto producto = new Producto();
        String sql = "SELECT * FROM producto WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
    
    
}    


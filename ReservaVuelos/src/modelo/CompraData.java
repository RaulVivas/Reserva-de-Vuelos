/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias Sanchez
 */
public class CompraData {
    private Connection connection = null;
    private Conexion conexion;

    public CompraData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion "+ ex.getMessage());
        }
    }
    
    
    public void guardarCompra(Compra compra){
        try {
            
            String sql = "INSERT INTO compra (id_cliente, id_asiento, valor , fecha_compra , estado) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, compra.getCliente().getId());
            statement.setInt(2, compra.getAsiento().getId());
            statement.setDouble(3, compra.getValor());
            statement.setDate(4, Date.valueOf(compra.getFechaCompra()));
            statement.setBoolean(5, compra.isEstado());
           
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                compra.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una compra");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una compra: " + ex.getMessage());
        }
    }
    
    public List<Compra> obtenerCompra(){
        List<Compra> compras = new ArrayList<Compra>();
            

        try {
            String sql = "SELECT * FROM compra;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Compra compra;
            while(resultSet.next()){
                compra = new Compra();
                
                Cliente cliente=buscarCliente(resultSet.getInt("id_cliente"));
                compra.setCliente(cliente);
                
                Asiento asiento=buscarAsiento(resultSet.getInt("id_asiento"));
                compra.setAsiento(asiento);
                
                compra.setValor(resultSet.getDouble("valor"));
                
                compra.setFechaCompra(resultSet.getDate("fecha_compra").toLocalDate());
                
                compra.setEstado(resultSet.getBoolean("estado"));
                
                
                
                
                compras.add(compra);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener lass compras: " + ex.getMessage());
        }
        
        
        return compras;
    }
    
    public Cliente buscarCliente(int id){
        
        ClienteData c=new ClienteData(conexion);
        
        return c.buscarCliente(id);
        
    }
    
    public Asiento buscarAsiento(int id){
        
        AsientoData a=new AsientoData(conexion);
        
        return a.buscarAsiento(id);
        
    }
    
    public void borrarCompra(int id){
    try {
            
            String sql = "DELETE FROM compra WHERE id_compra =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar compra: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarCompra(Compra compra){
    
        try {
            
            String sql = "UPDATE compra SET id_compra = ?, id_asiento = ? , valor = ? , fecha_compra = ? , estado = ?  WHERE id_compra = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, compra.getCliente().getId());
            statement.setInt(2, compra.getAsiento().getId());
            statement.setDouble(3, compra.getValor());
            statement.setDate(4, Date.valueOf(compra.getFechaCompra()));
            statement.setBoolean(5, compra.isEstado());
            statement.setInt(6, compra.getId());
            statement.executeUpdate();
            
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar compra: " + ex.getMessage());
        }
    
    }
    
    public Compra buscarCompra(int id){
     Compra compra=null;
    try {
            
            String sql = "SELECT * FROM compra WHERE id_compra =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                compra = new Compra();
                 Cliente cliente=buscarCliente(resultSet.getInt("id_cliente"));
                compra.setCliente(cliente);
                
                Asiento asiento=buscarAsiento(resultSet.getInt("id_asiento"));
                compra.setAsiento(asiento);
                
                compra.setValor(resultSet.getDouble("valor"));
                
                compra.setFechaCompra(resultSet.getDate("fecha_compra").toLocalDate());
                
                compra.setEstado(resultSet.getBoolean("estado"));

                
            }      
            statement.close();
                        
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar compra: " + ex.getMessage());
        }
        
        return compra;
    }
}

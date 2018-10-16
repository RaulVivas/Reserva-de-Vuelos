/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.Cliente;
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
 * @author matias
 */
public class ClienteData {
    private Connection connection = null;

    public ClienteData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion "+ ex.getMessage());
        }
    }
    
    
    public void guardarCliente(Cliente cliente){
        try {
            
            String sql = "INSERT INTO cliente (nombre_cliente, edad_cliente, telefono_cliente, nro_pasaporte, nro_tarjeta) VALUES ( ? , ? , ? , ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNombreCliente());
            statement.setInt(2, cliente.getEdadCliente());
            statement.setString(3, cliente.getTelefonoCliente());
            statement.setString(4, cliente.getNroPasaporte());
            statement.setString(5, cliente.getNroTarjeta());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                cliente.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un cliente");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un cliente: " + ex.getMessage());
        }
    }
    
    public List<Cliente> obtenerClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
            

        try {
            String sql = "SELECT * FROM cliente;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Cliente cliente;
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
                cliente.setEdadCliente(resultSet.getInt("edad_cliente"));
                cliente.setTelefonoCliente(resultSet.getString("telefono_cliente"));
                cliente.setNroPasaporte(resultSet.getString("nro_pasaporte"));
                cliente.setNroTarjeta(resultSet.getString("nro_tarjeta"));
                
                
                clientes.add(cliente);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los clientes: " + ex.getMessage());
        }
        
        
        return clientes;
    }
    
    public void borrarCliente(int id){
    try {
            
            String sql = "DELETE FROM cliente WHERE id_cliente =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar cliente: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarCliente(Cliente cliente){
    
        try {
            
            String sql = "UPDATE cliente SET nombre_cliente = ?, edad_cliente = ? , telefono_cliente =? , nro_pasaporte=? , nro_tarjeta=? WHERE id_cliente = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cliente.getNombreCliente());
            statement.setInt(2, cliente.getEdadCliente());
            statement.setString(3, cliente.getTelefonoCliente());
            statement.setString(4, cliente.getNroPasaporte());
            statement.setString(5, cliente.getNroTarjeta());
            statement.setInt(6, cliente.getId());
            statement.executeUpdate();
            
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar cliente: " + ex.getMessage());
        }
    
    }
    
    public Cliente buscarCliente(int id){
     Cliente cliente=null;
    try {
            
            String sql = "SELECT * FROM cliente WHERE id_cliente =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("id_cliente"));
                cliente.setNombreCliente(resultSet.getString("nombre_cliente"));
                cliente.setEdadCliente(resultSet.getInt("edad_cliente"));
                cliente.setTelefonoCliente(resultSet.getString("telefono_cliente"));
                cliente.setNroPasaporte(resultSet.getString("nro_pasaporte"));
                cliente.setNroTarjeta(resultSet.getString("nro_tarjeta"));

                
            }      
            statement.close();
                        
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar cliente: " + ex.getMessage());
        }
        
        return cliente;
    }
    
}

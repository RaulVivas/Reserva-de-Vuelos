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
public class AsientoData {
    
    private Connection connection = null;
    private Conexion conexion;

    public AsientoData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion "+ ex.getMessage());
        }
    }
    
    
    public void guardarAsiento(Asiento asiento){
        try {
            
            String sql = "INSERT INTO asiento (id_vuelo, fila_asiento, letra_asiento, disponibilidad, precio) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, asiento.getVuelo().getId());
            statement.setInt(2, asiento.getFilaAsiento());
            statement.setString(3, asiento.getLetraAsiento());
            statement.setBoolean(4, asiento.isDisponibilidad());
            statement.setDouble(5, asiento.getPrecio());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                asiento.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un asiento");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un asiento: " + ex.getMessage());
        }
    }
    
    public List<Asiento> obtenerAsiento(){
        List<Asiento> asientos = new ArrayList<Asiento>();
            

        try {
            String sql = "SELECT * FROM asiento;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Asiento asiento;
            while(resultSet.next()){
                asiento = new Asiento();
                
                Vuelo v=buscarVuelo(resultSet.getInt("id_vuelo"));
                asiento.setVuelo(v);
                asiento.setFilaAsiento(resultSet.getInt("fila_asiento"));
                asiento.setLetraAsiento(resultSet.getString("letra_asiento"));
                asiento.setDisponibilidad(resultSet.getBoolean("disponibilidad"));
                asiento.setPrecio(resultSet.getDouble("precio"));
                
              
                
                asientos.add(asiento);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los asientos: " + ex.getMessage());
        }
        
        
        return asientos;
    }
    
    public Vuelo buscarVuelo(int id){
        
        VueloData v=new VueloData(conexion);
        
        return v.buscarVuelo(id);
        
    }
    
    
    
    public void actualizarAsiento(Asiento asiento){
    
        try {
            
            String sql = "UPDATE asiento SET id_vuelo = ?, fila_asiento = ? , letra_asiento =? , disponibilidad=? , precio=?  WHERE id_asiento = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, asiento.getVuelo().getId());
            statement.setInt(2, asiento.getFilaAsiento());
            statement.setString(3, asiento.getLetraAsiento());
            statement.setBoolean(4, asiento.isDisponibilidad());
            statement.setDouble(5, asiento.getPrecio());
            statement.setInt(6, asiento.getId());
            statement.executeUpdate();
            
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar asiento: " + ex.getMessage());
        }
    
    }
    
    public Asiento buscarAsiento(int id){
     Asiento asiento=null;
    try {
            
            String sql = "SELECT * FROM asiento WHERE id_asiento =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                asiento = new Asiento();
                
                Vuelo v=buscarVuelo(resultSet.getInt("id_vuelo"));
                asiento.setVuelo(v);
                asiento.setFilaAsiento(resultSet.getInt("fila_asiento"));
                asiento.setLetraAsiento(resultSet.getString("letra_asiento"));
                asiento.setDisponibilidad(resultSet.getBoolean("disponibilidad"));
                asiento.setPrecio(resultSet.getDouble("precio"));

                
            }      
            statement.close();
                        
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar asiento: " + ex.getMessage());
        }
        
        return asiento;
    }
    
}

    


/*
 *To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
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
public class CiudadData {
    private Connection connection = null;

    public CiudadData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion "+ ex.getMessage());
        }
    }
    
    
    public void guardarCiudad(Ciudad ciudad){
        try {
            
            String sql = "INSERT INTO cliente (nombre_pais, nombre_ciudad, codigo_ciudad) VALUES ( ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ciudad.getNombrePais());
            statement.setString(2, ciudad.getNombreCiudad());
            statement.setString(3, ciudad.getCodigoCiudad());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                ciudad.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar una ciudad");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar una ciudad: " + ex.getMessage());
        }
    }
    
    public List<Ciudad> obtenerCiudades(){
        List<Ciudad> ciudades = new ArrayList<Ciudad>();
            

        try {
            String sql = "SELECT * FROM ciudad;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Ciudad ciudad;
            while(resultSet.next()){
                ciudad = new Ciudad();
                ciudad.setId(resultSet.getInt("id_ciudad"));
                ciudad.setNombrePais(resultSet.getString("nombre_pais"));
                ciudad.setNombreCiudad(resultSet.getString("nombre_ciudad"));
                ciudad.setCodigoCiudad(resultSet.getString("codigo_ciudad"));
                
                
                ciudades.add(ciudad);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las ciudades: " + ex.getMessage());
        }
        
        
        return ciudades;
    }
    
    public void borrarCiudad(int id){
    try {
            
            String sql = "DELETE FROM ciudad WHERE id_ciudad =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar la ciudad: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarCiudad(Ciudad ciudad){
    
        try {
            
            String sql = "UPDATE ciudad SET nombre_pais = ?, nombre_ciudad = ? ,codigo_ciudad =? WHERE id_ciudad = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ciudad.getNombrePais());
            statement.setString(2, ciudad.getNombreCiudad());
            statement.setString(3, ciudad.getCodigoCiudad());
            statement.setInt(4, ciudad.getId());
            statement.executeUpdate();
            
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar ciudad: " + ex.getMessage());
        }
    
    }
    
    public Ciudad buscarCiudad(int id){
     Ciudad ciudad=null;
    try {
            
            String sql = "SELECT * FROM ciudad WHERE id_ciudad =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                ciudad = new Ciudad();
                ciudad.setId(resultSet.getInt("id_ciudad"));
                ciudad.setNombrePais(resultSet.getString("nombre_pais"));
                ciudad.setNombreCiudad(resultSet.getString("nombre_ciudad"));
                ciudad.setCodigoCiudad(resultSet.getString("codigo_ciudad"));

                
            }      
            statement.close();
                        
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar ciudad: " + ex.getMessage());
        }
        
        return ciudad;
    }
    
}

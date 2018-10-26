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
public class VueloData {
    private Connection connection = null;
    private Conexion conexion;

    public VueloData(Conexion conexion) {
        try {
            connection = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error al abrir al obtener la conexion "+ ex.getMessage());
        }
    }
    
    
    public void guardarVuelo(Vuelo vuelo){
        try {
            
            String sql = "INSERT INTO vuelo (numero_de_vuelo, id_ciudad_origen, id_ciudad_destino, fecha_salida, fecha_llegada, aerolinea, avion) VALUES ( ? , ? , ? , ? , ? , ? , ?);";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, vuelo.getNroVuelo());
            statement.setInt(2, vuelo.getCiudadOrigen().getId());
            statement.setInt(3, vuelo.getCiudadDestino().getId());
            statement.setDate(4, Date.valueOf(vuelo.getFechaSalida()));
            statement.setDate(5, Date.valueOf(vuelo.getFechaLlegada()));
            statement.setString(6, vuelo.getAerolinea());
            statement.setString(7, vuelo.getAvion());
            
            statement.executeUpdate();
            
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                vuelo.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un vuelo");
            }
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un vuelo: " + ex.getMessage());
        }
    }
    
    public List<Vuelo> obtenerVuelo(){
        List<Vuelo> vuelos = new ArrayList<Vuelo>();
            

        try {
            String sql = "SELECT * FROM vuelo;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Vuelo vuelo;
            while(resultSet.next()){
                vuelo = new Vuelo();
                vuelo.setId(resultSet.getInt("id_vuelo"));
                vuelo.setNroVuelo(resultSet.getInt("numero_de_vuelo"));
                
                //Ciudad ciudadOrigen=buscarCiudad(resultSet.getInt("id_ciudad_origen"));
                //vuelo.setCiudadOrigen(ciudadOrigen);
                
                //Ciudad ciudadDestino=buscarCiudad(resultSet.getInt("id_ciudad_destino"));
                //vuelo.setCiudadOrigen(ciudadDestino);
                
                
                vuelo.setFechaLlegada(resultSet.getDate("fecha_salida").toLocalDate());
                vuelo.setFechaLlegada(resultSet.getDate("fecha_llegada").toLocalDate());
                vuelo.setAerolinea(resultSet.getString("aerolinea"));
                vuelo.setAvion(resultSet.getString("avion"));
                
                
                
                vuelos.add(vuelo);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los vuelos: " + ex.getMessage());
        }
        
        
        return vuelos;
    }
    
    public Ciudad buscarCiudad(int id){
        
        CiudadData cd=new CiudadData(conexion);
        
        return cd.buscarCiudad(id);
        
    }
    
    public void borrarVuelo(int id){
    try {
            
            String sql = "DELETE FROM vuelo WHERE id_vuelo =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            statement.executeUpdate();
            
            
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al borrar vuelo: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarVuelo(Vuelo vuelo){
    
        try {
            
            String sql = "UPDATE vuelo SET numero_de_vuelo = ?, id_ciudad_origen = ? , id_ciudad_destino =? , fecha_salida=? , fecha_llegada=? , aerolinea = ? , avion =? WHERE id_vuelo = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, vuelo.getNroVuelo());
            statement.setInt(2, vuelo.getCiudadOrigen().getId());
            statement.setInt(3, vuelo.getCiudadDestino().getId());
            statement.setDate(4, Date.valueOf(vuelo.getFechaSalida()));
            statement.setDate(5, Date.valueOf(vuelo.getFechaLlegada()));
            statement.setString(6, vuelo.getAerolinea());
            statement.setString(7, vuelo.getAvion());
            statement.setInt(8, vuelo.getId());
            statement.executeUpdate();
            
            
          
            statement.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al actualizar Vuelo: " + ex.getMessage());
        }
    
    }
    
    public Vuelo buscarVuelo(int id){
     Vuelo vuelo=null;
    try {
            
            String sql = "SELECT * FROM vuelo WHERE id_vuelo =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
           
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                vuelo = new Vuelo();
                vuelo.setId(resultSet.getInt("id_vuelo"));
                vuelo.setNroVuelo(resultSet.getInt("numero_de_vuelo"));
                
                //Ciudad ciudadOrigen=buscarCiudad(resultSet.getInt("id_ciudad_origen"));
                //vuelo.setCiudadOrigen(ciudadOrigen);
                
                //Ciudad ciudadDestino=buscarCiudad(resultSet.getInt("id_ciudad_destino"));
                //vuelo.setCiudadOrigen(ciudadDestino);
                
                
                vuelo.setFechaLlegada(resultSet.getDate("fecha_salida").toLocalDate());
                vuelo.setFechaLlegada(resultSet.getDate("fecha_llegada").toLocalDate());
                vuelo.setAerolinea(resultSet.getString("aerolinea"));
                vuelo.setAvion(resultSet.getString("avion"));

                
            }      
            statement.close();
                        
    
        } catch (SQLException ex) {
            System.out.println("Error al buscar vuelo: " + ex.getMessage());
        }
        
        return vuelo;
    }
    
}

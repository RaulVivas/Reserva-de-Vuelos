/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vivas Raúl
 */
public class Conexion {
    private String nombreBD = "reserva_de_vuelos"; //Nombre de la base de datos
    private String url; //Direccion de la base de datos
    private Connection conn; //Conexion
    
    public Conexion() throws ClassNotFoundException {
        url = "jdbc:mysql://localhost:3307/"+nombreBD; //Inicializa el atributo de la direccion de la base de datos
        Class.forName("org.mariadb.jdbc.Driver"); //Carga las librerias de MySQL o MariaDB

    }
    
    public Connection getConexion() throws SQLException{
        if(conn == null){
            conn = DriverManager.getConnection(url, "root", ""); //Obtenemos la conexion
        }
        //Devolvemos la conexion
        return conn;
    }
    
}

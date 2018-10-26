/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservavuelos;

import java.util.ArrayList;
import modelo.Asiento;
import modelo.AsientoData;
import modelo.Ciudad;
import modelo.CiudadData;
import modelo.Conexion;
import modelo.Vuelo;

/**
 *
 * @author Matias Sanchez
 */
public class TestAsiento {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            AsientoData asientoData = new AsientoData(conexion);
            
            Vuelo vuelo = new Vuelo();
            vuelo.setId(1);
            
            //Asiento asiento = new Asiento(vuelo,3,"a",true,30.59);
            
            //asientoData.guardarAsiento(asiento);
            
            asientoData.buscarAsiento(1);
            /*ArrayList<Ciudad> lista=(ArrayList)ciudadData.obtenerCiudades();
            for(Ciudad a:lista){
               System.out.println(a.getNombreCiudad());
            }*/
            //Ciudad ciudadActualizar=new Ciudad(32,"Argentina","Villa Mercedes" , "1234");
            //ciudadData.actualizarCiudad(ciudadActualizar);
             //ciudadData.buscarCiudad(32);
             //ciudadData.borrarCiudad(32);
            
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("SE PORODUJO UNA EXCEPCION: "+ ex.getMessage());
        }
        
        // TODO code application logic here
    }
}

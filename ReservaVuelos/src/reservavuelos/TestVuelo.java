/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservavuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelo.Ciudad;
import modelo.CiudadData;
import modelo.Conexion;
import modelo.Vuelo;
import modelo.VueloData;

/**
 *
 * @author Matias Sanchez
 */
public class TestVuelo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            VueloData vueloData = new VueloData(conexion);
            
            Ciudad ciudadOrigen = new Ciudad();
            ciudadOrigen.setId(33);
            Ciudad ciudadDestino = new Ciudad();
            ciudadDestino.setId(35);
            
            //Vuelo vuelo = new Vuelo(2,ciudadOrigen,ciudadDestino,LocalDate.now(),LocalDate.now(),"12312","assdcsd");
            //vueloData.guardarVuelo(vuelo);
            //vueloData.borrarVuelo(2);
            
            
            ArrayList<Vuelo> lista=(ArrayList)vueloData.obtenerVuelo();
            for(Vuelo a:lista){
               System.out.println(a.getAerolinea());
            }
            
            
            //Vuelo vueloactualizar = new Vuelo(1,3,ciudadOrigen,ciudadDestino,LocalDate.now(),LocalDate.now(),"1234","aqsdasd");
            //vueloData.actualizarVuelo(vueloactualizar);
            //vueloData.buscarVuelo(1);
            
            
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("SE PORODUJO UNA EXCEPCION: "+ ex.getMessage());
        }
        
        // TODO code application logic here
    }
    
    
}

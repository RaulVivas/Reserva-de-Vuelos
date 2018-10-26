/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservavuelos;

import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Asiento;
import modelo.Ciudad;
import modelo.CiudadData;
import modelo.Cliente;
import modelo.Compra;
import modelo.CompraData;
import modelo.Conexion;

/**
 *
 * @author Matias Sanchez
 */
public class TestCompra {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            CompraData compraData = new CompraData(conexion);
            
            Asiento asiento = new Asiento();
            asiento.setId(1);
            Cliente cliente = new Cliente();
            cliente.setId(1);
            
           
            
            //Compra compra = new Compra(cliente,asiento,30.21,LocalDate.now(),true);
            //compraData.guardarCompra(compra);
            
            
           
            ArrayList<Compra> lista=(ArrayList)compraData.obtenerCompra();
            for(Compra a:lista){
               System.out.println(a.getId());
            }
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

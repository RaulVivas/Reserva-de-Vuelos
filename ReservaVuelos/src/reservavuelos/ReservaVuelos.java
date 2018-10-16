/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservavuelos;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.ClienteData;
import modelo.Conexion;
import java.text.ParseException;

/**
 *
 * @author Vivas Raul
 */
public class ReservaVuelos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion conexion = new Conexion();
            ClienteData clientedata = new ClienteData(conexion);
            //Cliente cliente = new Cliente("matias sanchez", 33, "12812384", "87236444", "384712393");
            //clientedata.guardarCliente(cliente);
            //System.out.println("El id del cliente es: " + cliente.getId());
            
            /*ArrayList<Cliente> lista=(ArrayList)clientedata.obtenerClientes();
            for(Cliente a:lista){
               System.out.println(a.getNombreCliente());
            }*/
            clientedata.borrarCliente(12);
            clientedata.borrarCliente(12);
            Cliente clienteActualizar = new Cliente(7,"carlitos", 22, "as12384", "asd36444", "asd712393");
           
            clientedata.actualizarCliente(clienteActualizar);
            
            clientedata.buscarCliente(2);
            clientedata.buscarCliente(7);
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            System.out.println("SE PORODUJO UNA EXCEPCION: "+ ex.getMessage());
        }
        
        // TODO code application logic here
    }
    
}

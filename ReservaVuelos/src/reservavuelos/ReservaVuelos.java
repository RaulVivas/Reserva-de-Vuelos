
package reservavuelos;

import modelo.Cliente;
import modelo.ClienteData;
import modelo.Conexion;

/**
 *
 * @author Vivas Raúl
 */
public class ReservaVuelos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion c1 = new Conexion();
            ClienteData cd = new ClienteData(c1);
            Cliente cliente1 = new Cliente("loki", 33, 12884, 876444, 384793);
            cd.guardarCliente(cliente1);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("SE PORODUJO UNA EXCEPCION: "+ ex.getMessage());
        }
        
    }
    
}

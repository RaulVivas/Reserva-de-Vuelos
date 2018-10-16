/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author micho rizo
 */
public class Ciudad {
    
    private int id=-1;
    private String nombrePais;
    private String nombreCiudad;
    private String codigoCiudad;

    public Ciudad(String nombrePais, String nombreCiudad, String codigoCiudad) {
        this.nombrePais = nombrePais;
        this.nombreCiudad = nombreCiudad;
        this.codigoCiudad = codigoCiudad;
    }
    
    public Ciudad(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }
    
    
    
}

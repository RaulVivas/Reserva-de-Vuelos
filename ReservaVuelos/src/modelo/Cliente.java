/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



/**
 *
 * @author matias
 */
public class Cliente {
    private int id = -1;
    private String nombreCliente;
    private int edadCliente;
    private String telefonoCliente;
    private String nroPasaporte;
    private String nroTarjeta;

    public Cliente(String nombreCliente, int edadCliente, String telefonoCliente, String nroPasaporte, String nroTarjeta) {
        this.nombreCliente = nombreCliente;
        this.edadCliente = edadCliente;
        this.telefonoCliente = telefonoCliente;
        this.nroPasaporte = nroPasaporte;
        this.nroTarjeta = nroTarjeta;
    }
    public Cliente(int id,String nombreCliente, int edadCliente, String telefonoCliente, String nroPasaporte, String nroTarjeta) {
        this.id=id;
        this.nombreCliente = nombreCliente;
        this.edadCliente = edadCliente;
        this.telefonoCliente = telefonoCliente;
        this.nroPasaporte = nroPasaporte;
        this.nroTarjeta = nroTarjeta;
    }

    public Cliente() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getNroPasaporte() {
        return nroPasaporte;
    }

    public void setNroPasaporte(String nroPasaporte) {
        this.nroPasaporte = nroPasaporte;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }
    
    
}

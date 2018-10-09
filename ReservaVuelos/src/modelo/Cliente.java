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
    private int telefonoCliente;
    private int nroPasaporte;
    private int nroTarjeta;

    public Cliente(String nombreCliente, int edadCliente, int telefonoCliente, int nroPasaporte, int nroTarjeta) {
        this.nombreCliente = nombreCliente;
        this.edadCliente = edadCliente;
        this.telefonoCliente = telefonoCliente;
        this.nroPasaporte = nroPasaporte;
        this.nroTarjeta = nroTarjeta;
    }

    public Cliente() {
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

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public int getNroPasaporte() {
        return nroPasaporte;
    }

    public void setNroPasaporte(int nroPasaporte) {
        this.nroPasaporte = nroPasaporte;
    }

    public int getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Matias Sanchez
 */
public class Vuelo {
    private int id=-1;
    private int nroVuelo;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private String aerolinea;
    private String avion;

    public Vuelo(int nroVuelo, Ciudad ciudadOrigen, Ciudad ciudadDestino, LocalDate fechaSalida, LocalDate fechaLlegada, String aerolinea, String avion) {
        this.nroVuelo = nroVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.aerolinea = aerolinea;
        this.avion = avion;
    }

    public Vuelo(int id,int nroVuelo, Ciudad ciudadOrigen, Ciudad ciudadDestino, LocalDate fechaSalida, LocalDate fechaLlegada, String aerolinea, String avion) {
        this.id=id;
        this.nroVuelo = nroVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.aerolinea = aerolinea;
        this.avion = avion;
    }
    
    
    
    
    public Vuelo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNroVuelo() {
        return nroVuelo;
    }

    public void setNroVuelo(int nroVuelo) {
        this.nroVuelo = nroVuelo;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getAvion() {
        return avion;
    }

    public void setAvion(String avion) {
        this.avion = avion;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Matias Sanchez
 */
public class Asiento {
    
    private int id = -1;
    private Vuelo vuelo;
    private int filaAsiento;
    private String letraAsiento;
    private boolean disponibilidad;
    private double precio;

    public Asiento(Vuelo vuelo, int filaAsiento, String letraAsiento, boolean disponibilidad, double precio) {
        this.vuelo = vuelo;
        this.filaAsiento = filaAsiento;
        this.letraAsiento = letraAsiento;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }

    public Asiento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getFilaAsiento() {
        return filaAsiento;
    }

    public void setFilaAsiento(int filaAsiento) {
        this.filaAsiento = filaAsiento;
    }

    public String getLetraAsiento() {
        return letraAsiento;
    }

    public void setLetraAsiento(String letraAsiento) {
        this.letraAsiento = letraAsiento;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
}

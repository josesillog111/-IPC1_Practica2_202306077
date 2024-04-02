package src;

import java.io.Serializable;


public class constructorSerializado implements Serializable{
    private String id;
    private String fechaInicio;
    private String fechaFin;
    private String distancia;
    private String vehiculo;
    private double gasolina;

    public constructorSerializado() {
    }

    public constructorSerializado(String id, String fechaInicio, String fechaFin, String distancia, String vehiculo, double gasolina) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.distancia = distancia;
        this.vehiculo = vehiculo;
        this.gasolina = gasolina;
    }   
    
    public String getId() {
        return id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public String getDistancia() {
        return distancia;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public double getGasolina() {
        return gasolina;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setGasolina(double gasolina) {
        this.gasolina = gasolina;
    }
    
}

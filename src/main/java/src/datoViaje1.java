package src;

public class datoViaje1 {
    
    private int id;
    private String fechaInicio;
    private String fechaFin;
    private String distancia;
    private String vehiculo;
    private double gasolina;

    public datoViaje1() {
    }
    
    public int getId() {
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

    public void setId(int id) {
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

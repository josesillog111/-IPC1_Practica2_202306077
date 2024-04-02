package src;

/**
 *
 * @author Jose
 */
public class infoViaje {
    String vehiculo;
    String incio;
    String destino;
    String distancia;

    public infoViaje() {
    }

    public infoViaje(String vehiculo, String incio, String destino, String distancia) {
        this.vehiculo = vehiculo;
        this.incio = incio;
        this.destino = destino;
        this.distancia = distancia;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public String getIncio() {
        return incio;
    }

    public String getDestino() {
        return destino;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setIncio(String incio) {
        this.incio = incio;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }
    
    
    
    
}

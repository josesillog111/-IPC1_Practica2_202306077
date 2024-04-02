package src;

import java.io.File;

public class Recorrido {
    
    String id;
    String inicio_recorrido;
    String fin_recorrido;
    String distancia;

    public Recorrido() {
    }

    public Recorrido(String id, String inicio_recorrido, String fin_recorrido, String distancia) {
        this.id = id;
        this.inicio_recorrido = inicio_recorrido;
        this.fin_recorrido = fin_recorrido;
        this.distancia = distancia;
    }

    public String getId() {
        return id;
    }


    public String getInicio_recorrido() {
        return inicio_recorrido;
    }

    public String getFin_recorrido() {
        return fin_recorrido;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInicio_recorrido(String inicio_recorrido) {
        this.inicio_recorrido = inicio_recorrido;
    }

    public void setFin_recorrido(String fin_recorrido) {
        this.fin_recorrido = fin_recorrido;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }


}

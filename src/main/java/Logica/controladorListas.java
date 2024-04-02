package Logica;

import java.util.LinkedList;
import src.Recorrido;

public class controladorListas {
    
    static LinkedList<Recorrido> recorridosList = new LinkedList<>();
    ControladorCSV controlador;
    Recorrido recorrido;

    // Método para agregar un nuevo recorrido a la lista
    public void agregarRecorrido(Recorrido recorrido) {
        recorridosList.add(recorrido);
    }
    
}

package Logica;

import GUI.formTabla;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import src.Recorrido;

/**
 *
 * @author Jose
 */
public class ControladorCSV {

    LinkedList<Recorrido> recorridos = new LinkedList<>();
    static File archivoSeleccionado;
    
    public  File getArchivoSeleccionado() {
        return archivoSeleccionado;
    }

    public void setArchivoSeleccionado(File archivoSeleccionado) {
        this.archivoSeleccionado = archivoSeleccionado;
    }

    public void setRecorridos(LinkedList<Recorrido> recorridos) {
        this.recorridos = recorridos;
    }
    

    public LinkedList<Recorrido> getRecorridos() {
        return recorridos;
    }

    public ControladorCSV() {
 
    }
    
    
    public void guardarArchivo(File archivo){
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            
            for(Recorrido re: recorridos){
                
            }
            
            
        }
        catch(IOException e){
        }
        finally{
            try{
                if(fichero != null){
                    fichero.close();
                }
            }
            catch(IOException e){
        }
        }
    }
    
    public void cargarArchivo(File archivo){
        
        formTabla tabla=new formTabla();
         try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] arreglo = line.split(",");
            if (arreglo.length >= 4) {
                Recorrido re = new Recorrido();
                re.setId(arreglo[0]);
                re.setInicio_recorrido(arreglo[1]);
                re.setFin_recorrido(arreglo[2]);
                re.setDistancia(arreglo[3]);
                recorridos.add(re);
            }
        }
        tabla.llenarTabla();
    } catch (IOException e) {
        e.printStackTrace(); // Imprimir información de error
    }
    }
    
    
    
    
    
}

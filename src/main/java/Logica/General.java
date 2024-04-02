package Logica;

import GUI.formReporte;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import src.constructorSerializado;

/**
 *
 * @author Jose
 */
public class General implements Serializable {
    
    
    
    public static General general = null;
    
    static {
        iniciarDatos();
    }

    
    public General() {

    }
    
public static void iniciarDatos() {
    General tmpGeneral = serializado.deserializarObjeto("EstadoProductos.dat", General.class);
    if (tmpGeneral == null) {
        System.out.println("Creando los Datos Iniciales");
        General.general = new General(); // Llama al constructor sin argumentos
    } else {
        System.out.println("Cargando Datos del Archivo");
        General.general = tmpGeneral;
    }
}
    ////////////////////////////////////////////
    
    private List<constructorSerializado> productos1 = new LinkedList<>();
    private List<constructorSerializado> productos2 = new LinkedList<>();
    private List<constructorSerializado> productos3 = new LinkedList<>();
    private DefaultTableModel modeloTablaProductos;
    

     public General(DefaultTableModel modeloTablaProductos) {
        this.modeloTablaProductos = modeloTablaProductos;
        iniciarListadoProductos();
    }

    private void iniciarListadoProductos() {
        formReporte reporte = new formReporte(modeloTablaProductos);
        modeloTablaProductos.setRowCount(0);

        // Recorrer la lista de productos 1 y agregar cada uno a la lista de productos en General.general y a la tabla
        for (constructorSerializado producto : productos1) {
            General.general.getProductos1().add(producto);
            reporte.insertarFilaEnTabla(producto);
        }

        // Recorrer la lista de productos 2 y agregar cada uno a la lista de productos en General.general y a la tabla
        for (constructorSerializado producto : productos2) {
            General.general.getProductos2().add(producto);
            reporte.insertarFilaEnTabla(producto);
        }

        // Recorrer la lista de productos 3 y agregar cada uno a la lista de productos en General.general y a la tabla
        for (constructorSerializado producto : productos3) {
            General.general.getProductos3().add(producto);
            reporte.insertarFilaEnTabla(producto);
        }
    }

    public void guardar() {
        serializado.serializarObjeto("EstadoProductos.dat", this);
    }

    public List<constructorSerializado> getProductos1() {
        return productos1;
    }

    public void setProductos1(List<constructorSerializado> productos1) {
        movimientoCarro1 carro1 = new movimientoCarro1();
        productos1=carro1.getLista1();
        this.productos1 = productos1;
    }

    public List<constructorSerializado> getProductos2() {
        
        return productos2;
    }

    public void setProductos2(List<constructorSerializado> productos2) {
        movimientoCarro2 carro2 = new movimientoCarro2();
        productos2=carro2.getLista2();
        this.productos2 = productos2;
    }

    public List<constructorSerializado> getProductos3() {
        
        return productos3;
    }

    public void setProductos3(List<constructorSerializado> productos3) {
        movimientoCarro3 carro3 = new movimientoCarro3();
        productos3=carro3.getLista3();
        this.productos3 = productos3;
    }


}

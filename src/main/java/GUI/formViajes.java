package GUI;

import Logica.ControladorCSV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import src.Recorrido;
import src.fechaActual;

/**
 *
 * @author Jose
 */
public class formViajes extends javax.swing.JFrame {
    
    static List<String> lista1 = new ArrayList<>();
    static List<String> lista2 = new ArrayList<>();
    static List<String> lista3 = new ArrayList<>();
    public String horaInicio;
    LinkedList<Recorrido> recorridosList = new LinkedList<>();
    ControladorCSV controlador;
    Recorrido recorrido;
    fechaActual fecha;

    public List<String> getLista1() {
        return lista1;
    }

    public List<String> getLista2() {
        return lista2;
    }

    public List<String> getLista3() {
        return lista3;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public formViajes() {
        initComponents();
        
        fecha = new fechaActual();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        controlador = new ControladorCSV();
        recorrido = new Recorrido();
        
        
        File file = controlador.getArchivoSeleccionado();
        controlador.cargarArchivo(file);
        
        
        LinkedList<Recorrido> recorridos = controlador.getRecorridos();
        HashSet<String> destinosUnicos = new HashSet<>();
        for (Recorrido recorrido : recorridos) {
        destinosUnicos.add(recorrido.getInicio_recorrido());
        }

        cboInicio.removeAllItems();

        for (String destino : destinosUnicos) {
            cboInicio.addItem(destino);
        }
        cboInicio.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener el destino seleccionado en el primer JComboBox
            String destinoSeleccionado = (String) cboInicio.getSelectedItem();
            
            // Limpiar y llenar el segundo JComboBox con los destinos posibles para el destino seleccionado
            cboFin.removeAllItems();
            for (Recorrido recorrido : recorridos) {
                if (recorrido.getInicio_recorrido().equals(destinoSeleccionado)) {
                    cboFin.addItem(recorrido.getFin_recorrido());
                }
            }
            cboFin.setEnabled(cboFin.getItemCount() > 0);
        }
    });
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboFin = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboInicio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboVehiculo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccionar punto inicial:");

        cboFin.setEnabled(false);

        jLabel2.setText("Seleccionar punto final:");

        cboInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboInicioActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione el tipo de transporte");

        cboVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motocicleta 1", "Motocicleta 2", "Motocicleta 3", "Vehículo estándar 1", "Vehículo estándar 2", "Vehículo estándar 3", "Vehículo premium 1", "Vehículo premium 2", "Vehículo premium 3" }));
        cboVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVehiculoActionPerformed(evt);
            }
        });

        jButton1.setText("Generar viaje");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(cboFin, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(36, 36, 36)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(cboVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cboFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String puntoInicial = (String) cboInicio.getSelectedItem();
        String puntoFinal = (String) cboFin.getSelectedItem();
        String vehiculo = (String) cboVehiculo.getSelectedItem();
        String rutaImagen;
        String vehiculoUtilizado = null; 
        switch (vehiculo) {
            case "Motocicleta 1":
            case "Motocicleta 2":
            case "Motocicleta 3":
                vehiculoUtilizado= "Motocicleta";
                rutaImagen = "src/main/java/assets/motocicleta.png";
        break;
            case "Vehículo estándar 1":
            case "Vehículo estándar 2":
            case "Vehículo estándar 3":
                vehiculoUtilizado= "Vehículo";
                rutaImagen = "src/main/java/assets/Carro.png";
        break;
            case "Vehículo premium 1":
            case "Vehículo premium 2":
            case "Vehículo premium 3":
                vehiculoUtilizado= "Vehículo premium";
                rutaImagen = "src/main/java/assets/carroPremium.png";
        break;
        default:
                rutaImagen = null;
        break;
}
    
    String distancia = obtenerDistancia(puntoInicial, puntoFinal);

// Agregar los datos a la lista adecuada
List<List<String>> listas = Arrays.asList(lista1, lista2, lista3);
boolean datosAgregados = false;

for (List<String> lista : listas) {
    if (lista == null) {
        JOptionPane.showMessageDialog(this, "Todos nuestros pilotos están ocupados, inténtelo más tarde", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    if (lista.size() < 3) {
        // Si no está llena, agregar los datos y salir del ciclo
        lista.add(puntoInicial);
        lista.add(puntoFinal);
        lista.add(vehiculoUtilizado);
        lista.add(rutaImagen);
        lista.add(String.valueOf(distancia)); // Convertir la distancia a String antes de agregarla
        System.out.println("Datos seleccionados en esta lista: " + lista);
        datosAgregados = true;
        break;
    }
}

        if (!datosAgregados) {
    JOptionPane.showMessageDialog(this, "Todos nuestros pilotos están ocupados, inténtelo más tarde", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed
}
    private void cboInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboInicioActionPerformed

    }//GEN-LAST:event_cboInicioActionPerformed

    private void cboVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboVehiculoActionPerformed

    
    private String obtenerDistancia(String recorridoInicial, String recorridoFinal) {
    LinkedList<Recorrido> listaRecorrido = controlador.getRecorridos();
    String distancia = ""; // Valor predeterminado si no se encuentra la distancia

    for (Recorrido recorrido : listaRecorrido) {
        if (recorrido.getInicio_recorrido().equals(recorridoInicial) && recorrido.getFin_recorrido().equals(recorridoFinal)) {
            distancia = recorrido.getDistancia();
            String horaInicio = fecha.obtenerFechaYHoraActual();
            setHoraInicio(horaInicio);
            break; // Detener el bucle una vez que se encuentre el recorrido
        }
    }

    return distancia;
}
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboFin;
    private javax.swing.JComboBox<String> cboInicio;
    private javax.swing.JComboBox<String> cboVehiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

/*public void cargarInicio(){
    LinkedList<Recorrido> recorridos = controlador.getRecorridos();
        if (recorridos != null){
            ArrayList<String> elementosComboBox = new ArrayList<>();
                for (Recorrido recorrido : recorridos) {
            elementosComboBox.add(recorrido.getInicio_recorrido());
            }
            String[] opciones = elementosComboBox.toArray(new String[0]);
            DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<>(opciones);
            cboInicio.setModel(modeloComboBox);
        }
        else{
            JOptionPane.showMessageDialog(this, "Lista vacía", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
}*/
public void agregarElementosComboBox(javax.swing.JComboBox<String> comboBox) {
        // Crear un conjunto para almacenar los destinos únicos
        HashSet<String> destinosUnicos = new HashSet<>();

        // Limpiar el combo box antes de agregar nuevos elementos
        comboBox.removeAllItems();

        // Iterar sobre los recorridos y agregar los destinos únicos al conjunto
        for (Recorrido recorrido : recorridosList) {
            destinosUnicos.add(recorrido.getInicio_recorrido());
        }

        // Agregar los destinos únicos al combo box
        for (String destino : destinosUnicos) {
            comboBox.addItem(destino);
        }
    }

}

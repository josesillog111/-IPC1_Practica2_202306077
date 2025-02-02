package GUI;

import Logica.General;
import javax.swing.table.DefaultTableModel;
import src.constructorSerializado;

public class formReporte extends javax.swing.JFrame {
    
     DefaultTableModel modeloTablaProductos;

     
    public formReporte(DefaultTableModel modeloTablaProductos) {
        initComponents();
        this.modeloTablaProductos = modeloTablaProductos;
        actualizarDatos();
    }
    
    public void actualizarDatos() {
        crearModeloTablaProductos();
        agregarDatosDeTodasLasListas();
    }
    
    private void crearModeloTablaProductos() {
        String[] columnas = new String[]{"ID", "Fecha de Inicio", "Fecha de Fin", "Distancia", "Vehículo", "Gasolina"};
        modeloTablaProductos = new DefaultTableModel(columnas, 0);
        tblReporte.setModel(modeloTablaProductos);
    }
    
    private void agregarDatosDeTodasLasListas() {
        // Limpiar la tabla antes de cargar nuevos datos
        modeloTablaProductos.setRowCount(0);
        
        // Agregar los productos de la primera lista
        for (constructorSerializado producto : General.general.getProductos1()) {
            insertarFilaEnTabla(producto);
        }
        
        // Agregar los productos de la segunda lista
        for (constructorSerializado producto : General.general.getProductos2()) {
            insertarFilaEnTabla(producto);
        }
        
        // Agregar los productos de la tercera lista
        for (constructorSerializado producto : General.general.getProductos3()) {
            insertarFilaEnTabla(producto);
        }
    }
    
    public void insertarFilaEnTabla(constructorSerializado constructor) {
        modeloTablaProductos.addRow(crearValoresObjetoParaFila(constructor));
    }
    
    private Object[] crearValoresObjetoParaFila(constructorSerializado constructor) {
        return new Object[]{
            constructor.getId(),
            constructor.getFechaInicio(),
            constructor.getFechaFin(), 
            constructor.getDistancia(),
            constructor.getVehiculo(),
            constructor.getGasolina()};
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        General.general.guardar();
    }       /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Reporte");

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReporte;
    // End of variables declaration//GEN-END:variables
}

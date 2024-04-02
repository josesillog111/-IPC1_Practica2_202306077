package GUI;

import java.util.List;

/**
 *
 * @author Jose
 */
public class formInformacion extends javax.swing.JFrame {

    formViajes lista;
    
    public formInformacion() {
        initComponents();
        lista = new formViajes();
        List<String> obtenerLista = lista.getLista3();
        String distancia = obtenerLista.get(4);
        String inicio = obtenerLista.get(0);
        String fin = obtenerLista.get(1);
        String vehiculo = obtenerLista.get(2);
        
        lbDistancia.setText("Distancia del viaje: " + distancia);
        lbFin.setText("Destino: " + fin);
        lbInicio.setText("Inicio: " + inicio);
        lbVehiculo.setText("Vehículo elgido: " + vehiculo);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbDistancia = new javax.swing.JLabel();
        lbFin = new javax.swing.JLabel();
        lbInicio = new javax.swing.JLabel();
        lbVehiculo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbDistancia.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbDistancia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDistancia.setText("jLabel1");
        lbDistancia.setToolTipText("");

        lbFin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbFin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbFin.setText("jLabel1");

        lbInicio.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbInicio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbInicio.setText("jLabel1");

        lbVehiculo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbVehiculo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbVehiculo.setText("jLabel1");

        jButton1.setText("Regresar");
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
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDistancia)
                    .addComponent(lbFin)
                    .addComponent(lbVehiculo)
                    .addComponent(lbInicio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(366, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(lbDistancia)
                .addGap(32, 32, 32)
                .addComponent(lbInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(lbFin)
                .addGap(34, 34, 34)
                .addComponent(lbVehiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbDistancia;
    private javax.swing.JLabel lbFin;
    private javax.swing.JLabel lbInicio;
    private javax.swing.JLabel lbVehiculo;
    // End of variables declaration//GEN-END:variables
}

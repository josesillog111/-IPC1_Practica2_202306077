
package GUI;

import Logica.movimientoCarro1;
import Logica.movimientoCarro2;
import Logica.movimientoCarro3;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import src.Paleta;

/**
 *
 * @author Jose
 */
public class formCarro extends javax.swing.JFrame {

    public formCarro(String title) throws HeadlessException {
        super(title);
        this.setSize(new Dimension(960, 650));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        GridLayout gridLayout = new GridLayout(3, 1, 80, 4);
        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));

        this.setContentPane(jPanel);
        this.add(new movimientoCarro1());
        this.add(new movimientoCarro2());
        this.add(new movimientoCarro3());
        this.setVisible(true);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
}

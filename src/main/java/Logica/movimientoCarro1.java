package Logica;

import GUI.formInformacion;
import GUI.formTabla;
import GUI.formViajes;
import static Logica.movimientoCarro3.generarID;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;
import src.Fuentes;
import src.Paleta;
import src.constructorSerializado;
import src.fechaActual;

/**
 *
 * @author Jose
 */
public class movimientoCarro1 extends JPanel {
    formViajes lista;
    constructorSerializado constructor;
    static java.util.List<constructorSerializado> lista1;

    public void setLista1(java.util.List<constructorSerializado> lista1) {
        this.lista1 = lista1;
    }

    public java.util.List<constructorSerializado> getLista1() {
        return lista1;
    }
    
    fechaActual fecha;
    JLabel image;
    JButton boton;
    int segmentos;
    int numeroMovimientos;
    double contadorGasolina;
    double valorGasolina;
    double gastoGasolina;
    JButton nuevoBoton;
    ControladorCSV controlador;
    formInformacion info;

    public double getValorGasolina() {
        return valorGasolina;
    }

    public void setValorGasolina(double valorGasolina) {
        this.valorGasolina = valorGasolina;
    }
    
    public double getContadorGasolina() {
        return contadorGasolina;
    }

    public void setContadorGasolina(double contadorGasolina) {
        this.contadorGasolina = contadorGasolina;
    }

    public void setSegmentos(int segmentos) {
        this.segmentos = segmentos;
    }

    public int getSegmentos() {
        return segmentos;
    }

    public int getNumeroMovimientos() {
        return numeroMovimientos;
    }

    public void setNumeroMovimientos(int numeroMovimientos) {
        this.numeroMovimientos = numeroMovimientos;
            
    }
    
    
    
    public movimientoCarro1() {
        BorderLayout borderLayout = new BorderLayout(0, 0);
        this.setBackground(Paleta.fondo);
        this.setBorder(new EmptyBorder(16,24, 16, 24));
        this.setLayout(borderLayout);

        JButton btInicio = new JButton("Inicio");
        btInicio.setForeground(Paleta.fondo);
        btInicio.setBackground(Paleta.secundario);
        btInicio.setFont(Fuentes.normal);
        btInicio.addActionListener(this::onBtInicioClick);
        this.add(btInicio, BorderLayout.WEST);
        
        lista = new formViajes();
        info = new formInformacion();
        imagen();
        java.util.List<String> datos = lista.getLista1();
        String distancia = datos.get(4);
        int distanciaInt = Integer.parseInt(distancia);
        setSegmentos(distanciaInt);
       
    }   

    
public void onBtInicioClick(ActionEvent e) {
    boton.setVisible(true);
    nuevoBoton.setVisible(true);
    int posicionActualX = image.getBounds().x; 
    if (posicionActualX <385){
    int movimientos = getNumeroMovimientos();

    if (movimientos <= 385) {
        int numeroRestante;
        int destinoX;
        int seg = getSegmentos();

    if (seg >= movimientos) {
            // El usuario tiene suficientes movimientos para cubrir todas las casillas
            numeroRestante = 0;
    } else {
            // El usuario no tiene suficientes movimientos para cubrir todas las casillas
            numeroRestante = movimientos - seg;
        }

        System.out.print(numeroRestante);
        setNumeroMovimientos(numeroRestante);
        destinoX = ((movimientos * 385) / seg) + image.getBounds().x;

        Thread hiloInicio = new Thread(() -> {
            int posicionActualXA = image.getBounds().x; // Obtener la posición actual de la imagen
            for (int i = posicionActualXA; i <= destinoX && i <= 385; i += 4) { // Ajustar la condición de parada del bucle
                
                image.setBounds(i, 5, 128, 128);
                boton.setBounds(i, 133, 62, 25); // Actualizar la posición del botón principal
                nuevoBoton.setBounds(i+64, 5 + 128, 62, 25); // Actualizar la posición del nuevo botón
                
                try {
                    Thread.sleep(35);
                } catch (InterruptedException excepcion) {
                    System.out.println(excepcion.getMessage());
                }

                // Repintar la imagen y los botones para actualizar sus posiciones
                image.repaint();
                boton.repaint();
                nuevoBoton.repaint();
            }

        });

        hiloInicio.start();
    } else {
        JOptionPane.showMessageDialog(
                null,
                "Ya no puedes avanzar, cantidad de movimientos insuficientes."
        );
    }
    }
    else if(posicionActualX>=385){
        hiloRegresar();
        
        java.util.List<String> datos = lista.getLista2();
        String vehiculo = datos.get(2);
        String distancia = datos.get(4);
        String horaFin = fecha.obtenerFechaYHoraActual();
        String hora = lista.getHoraInicio();
        String id = generarID();
        double gasolina = getContadorGasolina();

        // Crear un nuevo objeto constructorSerializado
        constructorSerializado nuevoReporte = new constructorSerializado(id, hora, horaFin, distancia, vehiculo, gasolina);
        

        // Agregar el nuevo objeto a la lista
        java.util.List<constructorSerializado> listaNueva = new LinkedList<>();
        listaNueva.add(nuevoReporte);

        // Establecer la lista nueva en el objeto 'lista3'
        setLista1(listaNueva);
    }
    
    int movimientosRestantes = getNumeroMovimientos();
    double tanqueLleno=getValorGasolina();
    double gasolinaActual;
    if (movimientosRestantes==0){
        double gasolinaAnterior = getContadorGasolina();
        eligirGasolina();
        gasolinaActual=gasolinaAnterior + tanqueLleno;
        setContadorGasolina(gasolinaActual);
        System.out.print(gasolinaActual);
    }
    else{
        double gasolinaSobrante=gastoGasolina*movimientosRestantes;
        double gasolinaAnterior = getContadorGasolina();
        gasolinaActual=gasolinaAnterior + gasolinaSobrante;
        System.out.print(gasolinaActual);
    }
}
public static String generarID() {
        // Utilizar la clase UUID para generar un ID único al azar
        String uuid = UUID.randomUUID().toString();
        // Tomar los primeros 4 caracteres del UUID
        return uuid.substring(0, 4);
    }

private void imagen(){
    
    java.util.List<String> datos = lista.getLista1();
    String rutaImagen = datos.get(3);
    String vehiculo = datos.get(2);
    String recorrido = datos.get(4);
    int recorridoInt = Integer.parseInt(recorrido);
    setSegmentos(recorridoInt);

    System.out.print(rutaImagen + "\n");
    System.out.print(vehiculo + "\n");
    System.out.print(recorrido + "\n");
    System.out.print(recorridoInt + "\n");

    File imagenFile = new File(rutaImagen);
    FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
    JPanel panelImagen = new JPanel(flowLayout);
    panelImagen.setBackground(Paleta.fondo);
    image = new JLabel();
    
    boton = new JButton("Llenar");
    boton.setPreferredSize(new Dimension(62, 20));
    boton.setBounds(0, 5 + 128, 62, 25);
    boton.setVisible(false);
    boton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int cantidadDistacia;
            switch (vehiculo) {
                case "Motocicleta":
                    cantidadDistacia = 60;
                    setNumeroMovimientos(cantidadDistacia);
                    break;
                case "Vehículo":
                    cantidadDistacia = 33;
                    setNumeroMovimientos(cantidadDistacia);
                    break;
                case "Vehículo premium":
                    cantidadDistacia = 27;
                    setNumeroMovimientos(cantidadDistacia);
                    break;
            }
        }
    });

    nuevoBoton = new JButton("Info");
    nuevoBoton.setPreferredSize(new Dimension(62, 20));
    nuevoBoton.setBounds(64, 5 + 128, 62, 25);
    nuevoBoton.setVisible(false);
    nuevoBoton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             info.setVisible(true);
        }
    });
    

    BufferedImage bufferedImage = null;
    try {
        bufferedImage = ImageIO.read(imagenFile);
        Image nuevaImagen = bufferedImage.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(nuevaImagen);
        image.setIcon(imageIcon);
    } catch (IOException exception) {
        System.out.println(exception.getMessage());
        image.setText("Imagen");
    }
    image.setPreferredSize(new Dimension(128, 128));
    panelImagen.add(image, BorderLayout.CENTER);
    panelImagen.add(boton, BorderLayout.SOUTH);
    panelImagen.add(nuevoBoton, BorderLayout.EAST); // Agregar el nuevo botón en el lado este del panel
    this.add(panelImagen, BorderLayout.CENTER);
    this.setSize(600, 400);
    
}

private void hiloRegresar() {
        Thread hiloviaje = new Thread(() -> {
        int posicionActualX = image.getBounds().x;
        for (int i = posicionActualX; i >= 0; i -= 5) {
            // Establecer la nueva posición de la imagen y los botones
            image.setBounds(i, 5, 128, 128);
            boton.setBounds(i, 133, 62, 25); // Actualizar la posición del botón principal
            nuevoBoton.setBounds(i + 64, 5 + 128, 62, 25); // Actualizar la posición del nuevo botón
            try {
                // Pausar el hilo para animar el movimiento
                Thread.sleep(35);
            } catch (InterruptedException excepcion) {
                System.out.println(excepcion.getMessage());
            }

            // Repintar la imagen y los botones para actualizar sus posiciones
            image.repaint();
            boton.repaint();
            nuevoBoton.repaint();

        }

        });

        hiloviaje.start();
    }



private void eligirGasolina(){
    java.util.List<String> datos = lista.getLista1();
    String vehiculo = datos.get(2);
            double cantidadGasolina;
            switch (vehiculo) {
                case "Motocicleta":
                    cantidadGasolina = 6.0;
                    gastoGasolina=0.1;
                    setValorGasolina(cantidadGasolina);
                    break;
                case "Vehículo":
                    cantidadGasolina = 10.0;
                    gastoGasolina=0.3;
                    setValorGasolina(cantidadGasolina);
                    break;
                case "Vehículo premium":
                    cantidadGasolina = 12.0;
                    gastoGasolina=0.45;
                    setValorGasolina(cantidadGasolina);
                    break;
            }
    }

}
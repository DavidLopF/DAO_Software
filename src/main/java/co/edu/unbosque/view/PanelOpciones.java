package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelOpciones extends JPanel {

    private JComboBox opciones;
    private JButton aceptar;

    private JButton verData;
    private JLabel fondo;
    public PanelOpciones(){
        setLayout(null);
        setVisible(true);
        setBackground(Color.white);
        inicializarComponentes();
    }

    public JButton getVerData() {
        return verData;
    }

    public void setVerData(JButton verData) {
        this.verData = verData;
    }

    public void inicializarComponentes(){
       
        opciones = new JComboBox();
        opciones.setBounds(160, 250, 400, 30);
        opciones.addItem("1. guardar persona en un arreglo");
        opciones.addItem("2. guardar persona en un archivo binario");
        opciones.addItem("3. guardar persona en sqlite");
        opciones.addItem("4. guardar persona en un archivo cassandra");
        add(opciones);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(160, 300, 400, 30);
        aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aceptar.setActionCommand("ACEPTAR_OPCION");
        add(aceptar);

        verData = new JButton("Ver data");
        verData.setBounds(160, 350, 400, 30);
        verData.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verData.setActionCommand("VER_DATA");
        add(verData);

        fondo = new JLabel();
        fondo.setBounds(0, 0, 700, 600);
        fondo.setIcon(new ImageIcon(getClass().getResource("/fondo.png")));
        add(fondo);
    }
    public JComboBox getOpciones() {
        return opciones;
    }

    public void setOpciones(JComboBox opciones) {
        this.opciones = opciones;
    }

    public JButton getAceptar() {
        return aceptar;
    }

    public void setAceptar(JButton aceptar) {
        this.aceptar = aceptar;
    }
}

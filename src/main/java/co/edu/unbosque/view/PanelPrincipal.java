package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JFrame {

    private PanelOpciones panelOpciones;
    private PanelFormPersona panelFormPersona;

    public PanelPrincipal(){
        setTitle("Taller DAO");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(10, 10));
        inicializarComponentes();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void inicializarComponentes(){
        panelOpciones = new PanelOpciones();
        getContentPane().add(panelOpciones, BorderLayout.CENTER);

        panelFormPersona = new PanelFormPersona();

    }

    public void changePanel(JPanel panel){
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setVisible(true);
        getContentPane().repaint();
        
    }
    public void showMesasge(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public PanelOpciones getPanelOpciones() {
        return panelOpciones;
    }

    public void setPanelOpciones(PanelOpciones panelOpciones) {
        this.panelOpciones = panelOpciones;
    }

    public PanelFormPersona getPanelFormPersona() {
        return panelFormPersona;
    }

    public void setPanelFormPersona(PanelFormPersona panelFormPersona) {
        this.panelFormPersona = panelFormPersona;
    }
}

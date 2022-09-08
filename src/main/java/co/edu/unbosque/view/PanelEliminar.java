package co.edu.unbosque.view;

import co.edu.unbosque.model.persistence.Persona;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelEliminar extends JPanel {

    private JLabel titulo;
    private JComboBox options;
    private JButton verArray;
    private JButton verBinario;
    private JButton verSqlite;
    private JButton verCasandra;

    private JButton eliminar;

    private JLabel fondo;

    private JButton volver;

    public PanelEliminar(){
        setLayout(null);
        setVisible(false);
        setBackground(Color.white);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        verArray = new JButton("eliminar array");
        verArray.setBounds(10, 80, 150, 30);
        verArray.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verArray.setActionCommand("ELIMINAR_ARRAY");
        add(verArray);

        verBinario = new JButton("eliminar binario");
        verBinario.setBounds(10, 130, 150, 30);
        verBinario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verBinario.setActionCommand("ELIMINAR_BINARIO");
        add(verBinario);

        verSqlite = new JButton("eliminar sqlite");
        verSqlite.setBounds(10, 180, 150, 30);
        verSqlite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verSqlite.setActionCommand("ELIMINAR_SQLITE");
        add(verSqlite);

        verCasandra = new JButton("eliminar cassandra");
        verCasandra.setBounds(10, 230, 150, 30);
        verCasandra.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verCasandra.setActionCommand("ELIMINAR_CASSANDRA");
        add(verCasandra);

        titulo = new JLabel("Eliminar una persona");
        titulo.setBounds(250, 80, 200, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(titulo);

        options = new JComboBox();
        options.setBounds(250, 200, 400, 30);
        options.setVisible(false);
        add(options);


        eliminar = new JButton("Eliminar");
        eliminar.setBounds(250, 250, 400, 30);
        eliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        eliminar.setActionCommand("ELIMINAR");
        eliminar.setVisible(false);
        add(eliminar);

        volver = new JButton("Volver");
        volver.setBounds(10, 500, 120, 30);
        volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        volver.setActionCommand("VOLVER");
        add(volver);

        fondo = new JLabel();
        fondo.setBounds(0, 0, 700, 600);
        fondo.setIcon(new ImageIcon(getClass().getResource("/fondo_form.png")));
        add(fondo);
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void llenarSelect(ArrayList<Persona> personas){
        if(personas.size() > 0){
            this.options.removeAllItems();
            for (Persona persona : personas) {
                this.options.addItem(persona.getName());
            }
            this.options.setVisible(true);
            this.eliminar.setVisible(true);
        }else{
            this.options.setVisible(false);
            this.eliminar.setVisible(false);
            JOptionPane.showMessageDialog(null, "No hay personas registradas");
        }

    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JComboBox getOptions() {
        return options;
    }

    public void setOptions(JComboBox options) {
        this.options = options;
    }

    public JButton getVerArray() {
        return verArray;
    }

    public void setVerArray(JButton verArray) {
        this.verArray = verArray;
    }

    public JButton getVerBinario() {
        return verBinario;
    }

    public void setVerBinario(JButton verBinario) {
        this.verBinario = verBinario;
    }

    public JButton getVerSqlite() {
        return verSqlite;
    }

    public void setVerSqlite(JButton verSqlite) {
        this.verSqlite = verSqlite;
    }

    public JButton getVerCasandra() {
        return verCasandra;
    }

    public void setVerCasandra(JButton verCasandra) {
        this.verCasandra = verCasandra;
    }

    public JButton getVolver() {
        return volver;
    }

    public void setVolver(JButton volver) {
        this.volver = volver;
    }

    public JButton getEliminar() {
        return eliminar;
    }

    public void setEliminar(JButton eliminar) {
        this.eliminar = eliminar;
    }

}

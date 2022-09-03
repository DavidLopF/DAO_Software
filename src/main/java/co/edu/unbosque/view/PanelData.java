package co.edu.unbosque.view;

import co.edu.unbosque.model.persistence.Persona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class PanelData extends JPanel {

    //4 botones para las opciones y un jtable para mostrar la data
    private JButton verArray;
    private JButton verBinario;
    private JButton verSqlite;
    private JButton verCasandra;

    private JButton volver;

    private JTable table;
    private JLabel fondo;

    public PanelData(){
        setLayout(null);
        setVisible(false);
        setBackground(Color.white);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        //los botones a la izquierda y el jtable a la derecha
        verArray = new JButton("Ver array");
        verArray.setBounds(10, 80, 120, 30);
        verArray.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verArray.setActionCommand("VER_ARRAY");
        add(verArray);

        verBinario = new JButton("Ver binario");
        verBinario.setBounds(10, 130, 120, 30);
        verBinario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verBinario.setActionCommand("VER_BINARIO");
        add(verBinario);

        verSqlite = new JButton("Ver sqlite");
        verSqlite.setBounds(10, 180, 120, 30);
        verSqlite.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verSqlite.setActionCommand("VER_SQLITE");
        add(verSqlite);

        verCasandra = new JButton("Ver cassandra");
        verCasandra.setBounds(10, 230, 120, 30);
        verCasandra.setCursor(new Cursor(Cursor.HAND_CURSOR));
        verCasandra.setActionCommand("VER_CASSANDRA");
        add(verCasandra);

        volver = new JButton("Volver");
        volver.setBounds(10, 500, 120, 30);
        volver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        volver.setActionCommand("VOLVER");
        add(volver);

        //jtable


        fondo = new JLabel();
        fondo.setBounds(0, 0, 700, 600);
        fondo.setIcon(new ImageIcon(getClass().getResource("/fondo_form.png")));
        add(fondo);

    }
    public void llenarTabla(ArrayList<Persona> personas){
        table = new JTable();
        table.setBounds(160, 80, 500, 400);
        add(table);
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nombre", "Sexo", "Edad", "Numero de telefono"}, personas.size());
        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            modelo.setValueAt(persona.getName(), i, 0);
            modelo.setValueAt(persona.getSex(), i, 1);
            modelo.setValueAt(persona.getAge(), i, 2);
            modelo.setValueAt(persona.getPhoneNumber(), i, 3);
        }
        table.setModel(modelo);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(160, 80, 500, 400);
        add(scroll);

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

    public JLabel getFondo() {
        return fondo;
    }

    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    public JButton getVolver() {
        return volver;
    }
}

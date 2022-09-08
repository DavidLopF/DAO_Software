package co.edu.unbosque.view;

import co.edu.unbosque.model.persistence.Persona;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PanelUpdate extends JPanel {

    private JButton updateArray, updateFile, updateSQL, updateCassandra, aceptar;
    private JComboBox<String> comboBox;
    private JLabel title, lblName, lblSex, lblPhoneNumber, lblAge, fondo;
    private JTextField txtName, txtSex, txtPhoneNumber, txtAge;
    public PanelUpdate(){
        setLayout(null);
        setVisible(false);
        setBackground(Color.white);
        inicializarComponentes();
    }
    private void inicializarComponentes() {
        updateArray = new JButton("Actualizar Array");
        updateArray.setBounds(10, 70, 190, 30);
        updateArray.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateArray.setActionCommand("UPDATE_ARRAY");
        add(updateArray);

        updateFile = new JButton("Actualizar Binario");
        updateFile.setBounds(10, 130, 190, 30);
        updateFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateFile.setActionCommand("UPDATE_BINARIO");
        add(updateFile);

        updateSQL = new JButton("Actualizar SQLite");
        updateSQL.setBounds(10, 180, 190, 30);
        updateSQL.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateSQL.setActionCommand("UPDATE_SQLITE");
        add(updateSQL);

        updateCassandra = new JButton("Actualizar Cassandra");
        updateCassandra.setBounds(10, 230, 190, 30);
        updateCassandra.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateCassandra.setActionCommand("UPDATE_CASSANDRA");
        add(updateCassandra);

        title = new JLabel("Actualizar una persona");
        title.setBounds(350, 80, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        comboBox = new JComboBox<>();
        comboBox.setBounds(350, 130, 300, 30);
        comboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(comboBox);

        lblName = new JLabel("Nombre");
        lblName.setBounds(350, 180, 100, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(350, 220, 300, 30);
        add(txtName);

        lblSex = new JLabel("Sexo");
        lblSex.setBounds(350, 260, 100, 30);
        add(lblSex);

        txtSex = new JTextField();
        txtSex.setBounds(350, 300, 300, 30);
        add(txtSex);

        lblPhoneNumber = new JLabel("Telefono");
        lblPhoneNumber.setBounds(350, 340, 100, 30);
        add(lblPhoneNumber);

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(350, 380, 300, 30);
        add(txtPhoneNumber);

        lblAge = new JLabel("Edad");
        lblAge.setBounds(350, 420, 100, 30);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(350, 460, 300, 30);
        add(txtAge);

        aceptar = new JButton("Aceptar");
        aceptar.setBounds(350, 500, 300, 30);
        aceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aceptar.setActionCommand("ACEPTAR_UPDATE");
        aceptar.setVisible(false);
        add(aceptar);

        fondo = new JLabel();
        fondo.setBounds(0, 0, 700, 600);
        fondo.setIcon(new ImageIcon(getClass().getResource("/fondo_form.png")));
        add(fondo);
    }

    public void llenarSelect(ArrayList<Persona> personas){
        for (int i = 0; i < personas.size(); i++) {
            comboBox.addItem(personas.get(i).getName());
        }
        aceptar.setVisible(true);
    }

    public Persona validarCampos(){
        if (txtName.getText().equals("") || txtSex.getText().equals("") || txtPhoneNumber.getText().equals("") || txtAge.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
            txtAge.setText("");
            txtName.setText("");
            txtPhoneNumber.setText("");
            txtSex.setText("");
            return null;
        }else{
            return new Persona(txtName.getText(), txtSex.getText(), txtPhoneNumber.getText(), Integer.parseInt(txtAge.getText()));
        }
    }

    public JButton getUpdateArray() {
        return updateArray;
    }

    public void setUpdateArray(JButton updateArray) {
        this.updateArray = updateArray;
    }

    public JButton getUpdateFile() {
        return updateFile;
    }

    public void setUpdateFile(JButton updateFile) {
        this.updateFile = updateFile;
    }

    public JButton getUpdateSQL() {
        return updateSQL;
    }

    public void setUpdateSQL(JButton updateSQL) {
        this.updateSQL = updateSQL;
    }

    public JButton getUpdateCassandra() {
        return updateCassandra;
    }

    public void setUpdateCassandra(JButton updateCassandra) {
        this.updateCassandra = updateCassandra;
    }

    public JButton getAceptar() {
        return aceptar;
    }

    public void setAceptar(JButton aceptar) {
        this.aceptar = aceptar;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getLblName() {
        return lblName;
    }

    public void setLblName(JLabel lblName) {
        this.lblName = lblName;
    }

    public JLabel getLblSex() {
        return lblSex;
    }

    public void setLblSex(JLabel lblSex) {
        this.lblSex = lblSex;
    }

    public JLabel getLblPhoneNumber() {
        return lblPhoneNumber;
    }

    public void setLblPhoneNumber(JLabel lblPhoneNumber) {
        this.lblPhoneNumber = lblPhoneNumber;
    }

    public JLabel getLblAge() {
        return lblAge;
    }

    public void setLblAge(JLabel lblAge) {
        this.lblAge = lblAge;
    }

    public JLabel getFondo() {
        return fondo;
    }

    public void setFondo(JLabel fondo) {
        this.fondo = fondo;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JTextField getTxtSex() {
        return txtSex;
    }

    public void setTxtSex(JTextField txtSex) {
        this.txtSex = txtSex;
    }

    public JTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public void setTxtPhoneNumber(JTextField txtPhoneNumber) {
        this.txtPhoneNumber = txtPhoneNumber;
    }

    public JTextField getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(JTextField txtAge) {
        this.txtAge = txtAge;
    }
}

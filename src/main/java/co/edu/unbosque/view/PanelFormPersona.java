package co.edu.unbosque.view;

import co.edu.unbosque.model.persistence.Persona;

import javax.swing.*;

import java.awt.*;

public class PanelFormPersona extends JPanel{

    private JLabel title;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblSex;
    private JTextField txtSex;
    private JLabel lblPhoneNumber;
    private JTextField txtPhoneNumber;
    private JLabel lblAge;
    private JTextField txtAge;

    private JLabel fondo;

    private JButton volver;


    private JButton btnSave;
    

    public PanelFormPersona(){
        setLayout(null);
        setVisible(false);
        setBackground(Color.white);
        inicializarComponentes();  
      }

    private void inicializarComponentes() {

        title  = new JLabel("Formulario de persona");
        title.setBounds(160, 20, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        lblName = new JLabel("Nombre");
        lblName.setBounds(160, 60, 400, 30);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(160, 100, 400, 30);
        add(txtName);

        lblSex = new JLabel("Sexo");
        lblSex.setBounds(160, 140, 400, 30);
        add(lblSex);

        txtSex = new JTextField();
        txtSex.setBounds(160, 180, 400, 30);
        add(txtSex);

        lblPhoneNumber = new JLabel("Telefono");
        lblPhoneNumber.setBounds(160, 220, 400, 30);
        add(lblPhoneNumber);

        txtPhoneNumber = new JTextField();
        txtPhoneNumber.setBounds(160, 260, 400, 30);
        add(txtPhoneNumber);

        lblAge = new JLabel("Edad");
        lblAge.setBounds(160, 300, 400, 30);
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(160, 340, 400, 30);
        add(txtAge);

        btnSave = new JButton("Guardar");
        btnSave.setBounds(160, 400, 400, 30);
        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSave.setActionCommand("GUARDAR_PERSONA");
        add(btnSave);

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

     public Persona getPersona(){
        try{
            Persona persona = new Persona(txtName.getText().trim(), txtSex.getText().trim(), txtPhoneNumber.getText().trim(), Integer.parseInt(txtAge.getText().trim()));
            txtName.setText("");
            txtSex.setText("");
            txtPhoneNumber.setText("");
            txtAge.setText("");
            return persona;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona");
            return null;
        }
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

    public JTextField getTxtName() {
        return txtName;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public JLabel getLblSex() {
        return lblSex;
    }

    public void setLblSex(JLabel lblSex) {
        this.lblSex = lblSex;
    }

    public JTextField getTxtSex() {
        return txtSex;
    }

    public void setTxtSex(JTextField txtSex) {
        this.txtSex = txtSex;
    }

    public JLabel getLblPhoneNumber() {
        return lblPhoneNumber;
    }

    public void setLblPhoneNumber(JLabel lblPhoneNumber) {
        this.lblPhoneNumber = lblPhoneNumber;
    }

    public JTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public void setTxtPhoneNumber(JTextField txtPhoneNumber) {
        this.txtPhoneNumber = txtPhoneNumber;
    }

    public JLabel getLblAge() {
        return lblAge;
    }

    public void setLblAge(JLabel lblAge) {
        this.lblAge = lblAge;
    }

    public JTextField getTxtAge() {
        return txtAge;
    }

    public void setTxtAge(JTextField txtAge) {
        this.txtAge = txtAge;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getVolver() {
        return volver;
    }
}

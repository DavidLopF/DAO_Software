package co.edu.unbosque.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    

    public PanelFormPersona(){
        setLayout(null);
        setVisible(false);
        setBackground(Color.white);
        inicializarComponentes();  
      }

    private void inicializarComponentes() {

        title  = new JLabel("Formulario de persona");
        title.setBounds(160, 20, 400, 30);
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

    }
    
}

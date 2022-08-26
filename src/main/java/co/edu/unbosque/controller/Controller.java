package co.edu.unbosque.controller;

import co.edu.unbosque.view.PanelPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private PanelPrincipal panelPrincipal;
    public Controller(){
        panelPrincipal = new PanelPrincipal();
        giveListeners();
        
    }

    private void giveListeners(){
        panelPrincipal.getPanelOpciones().getAceptar().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "ACEPTAR_OPCION":
                String opcion = panelPrincipal.getPanelOpciones().getOpciones().getSelectedItem().toString().substring(0, 1);
                panelPrincipal.changePanel(panelPrincipal.getPanelFormPersona());

                break;
        }

    }
}

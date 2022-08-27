package co.edu.unbosque.controller;

import co.edu.unbosque.model.persistence.Persona;
import co.edu.unbosque.model.PersonaImpl;
import co.edu.unbosque.model.persistence.Sqlite;
import co.edu.unbosque.view.PanelPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller implements ActionListener {

    private String opcion;

    private PanelPrincipal panelPrincipal;
    private PersonaImpl personaDAO;

    private static final String acept_option = "ACEPTAR_OPCION";
    public Controller() throws IOException {
        panelPrincipal = new PanelPrincipal();
        personaDAO = new PersonaImpl();
        giveListeners();

    }

    private void giveListeners() {
        panelPrincipal.getPanelOpciones().getAceptar().addActionListener(this);
        panelPrincipal.getPanelFormPersona().getBtnSave().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "ACEPTAR_OPCION":
                opcion = panelPrincipal.getPanelOpciones().getOpciones().getSelectedItem().toString().substring(0, 1);
                panelPrincipal.changePanel(panelPrincipal.getPanelFormPersona());
                break;
            case "GUARDAR_PERSONA":
                Persona persona = panelPrincipal.getPanelFormPersona().getPersona();
                boolean flag = false;
                switch (opcion) {
                    case "1":
                        flag = personaDAO.saveInArray(persona);
                        if (flag) {
                            panelPrincipal.showMesasge("Persona guardada correctamente\nlas personas guardadas son: \n" + personaDAO.getPersonas().toString());
                        } else {
                            panelPrincipal.showMesasge("Error al guardar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;

                    case "2":
                        flag = personaDAO.saveInBinaryFile(persona);
                        if (flag) {
                            panelPrincipal.showMesasge("Persona guardada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al guardar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                    case "3":
                        flag = personaDAO.saveInSQLite(persona);
                        if (flag) {
                            panelPrincipal.showMesasge("Persona guardada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al guardar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;

                }
        }

    }
}

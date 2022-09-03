package co.edu.unbosque.controller;

import co.edu.unbosque.model.persistence.Cassandra;
import co.edu.unbosque.model.persistence.Persona;
import co.edu.unbosque.model.PersonaImpl;
import co.edu.unbosque.model.persistence.Sqlite;
import co.edu.unbosque.view.PanelPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Controller implements ActionListener {

    private String opcion;

    private PanelPrincipal panelPrincipal;
    private PersonaImpl personaDAO;

    private static final String acept_option = "ACEPTAR_OPCION";
    private static final String save_person = "GUARDAR_PERSONA";
    private static final String show_data = "VER_DATA";
    private static final String show_array = "VER_ARRAY";
    private static final String show_binary = "VER_BINARIO";
    private static final String show_sqlite = "VER_SQLITE";
    private static final String show_cassandra = "VER_CASSANDRA";

    private static final String volver = "VOLVER";

    private ArrayList<Persona> personas;

    public Controller() throws IOException {
        panelPrincipal = new PanelPrincipal();
        personaDAO = new PersonaImpl();
        giveListeners();

    }

    private void giveListeners() {
        panelPrincipal.getPanelOpciones().getAceptar().addActionListener(this);
        panelPrincipal.getPanelFormPersona().getBtnSave().addActionListener(this);
        panelPrincipal.getPanelOpciones().getVerData().addActionListener(this);
        panelPrincipal.getPanelData().getVerArray().addActionListener(this);
        panelPrincipal.getPanelData().getVerSqlite().addActionListener(this);
        panelPrincipal.getPanelData().getVerCasandra().addActionListener(this);
        panelPrincipal.getPanelData().getVerBinario().addActionListener(this);
        panelPrincipal.getPanelData().getVolver().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case acept_option:
                opcion = panelPrincipal.getPanelOpciones().getOpciones().getSelectedItem().toString().substring(0, 1);
                panelPrincipal.changePanel(panelPrincipal.getPanelFormPersona());
                break;
            case save_person:
                Persona persona = panelPrincipal.getPanelFormPersona().getPersona();
                boolean flag = false;
                switch (opcion) {
                    case "1":
                        //guardar en array
                        flag = personaDAO.saveInArray(persona);
                        if (flag) {
                            panelPrincipal.showMesasge("Persona guardada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al guardar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;

                    case "2":
                        //guardar en archivo binario
                        flag = personaDAO.saveInBinaryFile(persona);
                        if (flag) {
                            panelPrincipal.showMesasge("Persona guardada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al guardar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                    case "3":
                        //guardar en sqlite
                        flag = personaDAO.saveInSQLite(persona);
                        if (flag) {
                            panelPrincipal.showMesasge("Persona guardada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al guardar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                    case "4":
                        //guardar en cassandra
                        flag = personaDAO.saveInCassandra(persona);
                        if (flag) {
                            panelPrincipal.showMesasge("Persona guardada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al guardar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                }
                break;

            case show_data:
                panelPrincipal.changePanel(panelPrincipal.getPanelData());
                break;

            case show_array:
                personas = personaDAO.getPersonas();
                if (personas.size() > 0) {
                    panelPrincipal.getPanelData().llenarTabla(personas);
                } else {
                    panelPrincipal.showMesasge("No hay personas guardadas");
                    panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                }
                break;

            case show_binary:
                personas = personaDAO.getPersonasBinaryFile();
                if (personas.size() > 0) {
                    panelPrincipal.getPanelData().llenarTabla(personas);
                } else {
                    panelPrincipal.showMesasge("No hay personas guardadas");
                    panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                }
                break;
            case show_sqlite:
                personas = personaDAO.getPersonasSQLite();
                if (personas.size() > 0) {
                    panelPrincipal.getPanelData().llenarTabla(personas);
                } else {
                    panelPrincipal.showMesasge("No hay personas guardadas");
                    panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                }
                break;
            case show_cassandra:
                personas = personaDAO.getPersonasCassandra();
                if (personas.size() > 0) {
                    panelPrincipal.getPanelData().llenarTabla(personas);
                } else {
                    panelPrincipal.showMesasge("No hay personas guardadas");
                    panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                }
                break;
            case volver:
                panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                break;
        }

    }
}

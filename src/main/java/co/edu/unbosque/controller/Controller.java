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

    private String delete;

    private String update;

    private static final String acept_option = "ACEPTAR_OPCION";
    private static final String save_person = "GUARDAR_PERSONA";
    private static final String show_data = "VER_DATA";
    private static final String show_array = "VER_ARRAY";
    private static final String show_binary = "VER_BINARIO";
    private static final String show_sqlite = "VER_SQLITE";
    private static final String show_cassandra = "VER_CASSANDRA";

    private static final String back = "VOLVER";

    private static final String show_delete = "VER_ELIMINAR";

    private ArrayList<Persona> personas;

    public Controller() throws IOException {
        panelPrincipal = new PanelPrincipal();
        personaDAO = new PersonaImpl();
        delete = "";
        update = "";
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
        panelPrincipal.getPanelFormPersona().getVolver().addActionListener(this);
        panelPrincipal.getPanelOpciones().getVerEliminar().addActionListener(this);
        panelPrincipal.getPanelEliminar().getVerArray().addActionListener(this);
        panelPrincipal.getPanelEliminar().getVerBinario().addActionListener(this);
        panelPrincipal.getPanelEliminar().getVerSqlite().addActionListener(this);
        panelPrincipal.getPanelEliminar().getVerCasandra().addActionListener(this);
        panelPrincipal.getPanelEliminar().getVolver().addActionListener(this);
        panelPrincipal.getPanelEliminar().getEliminar().addActionListener(this);
        panelPrincipal.getPanelOpciones().getVerActualizar().addActionListener(this);
        panelPrincipal.getPanelUpdate().getUpdateArray().addActionListener(this);
        panelPrincipal.getPanelUpdate().getUpdateFile().addActionListener(this);
        panelPrincipal.getPanelUpdate().getUpdateSQL().addActionListener(this);
        panelPrincipal.getPanelUpdate().getAceptar().addActionListener(this);
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
                if (personas != null) {
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
            case back:
                panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                break;
            case show_delete:
                panelPrincipal.changePanel(panelPrincipal.getPanelEliminar());
                break;
            case "ELIMINAR_ARRAY":
                panelPrincipal.getPanelEliminar().llenarSelect(personaDAO.getPersonas());
                delete = "ARRAY";
                break;
            case "ELIMINAR_BINARIO":
                panelPrincipal.getPanelEliminar().llenarSelect(personaDAO.getPersonasBinaryFile());
                delete = "BINARIO";
                break;
            case "ELIMINAR_SQLITE":
                panelPrincipal.getPanelEliminar().llenarSelect(personaDAO.getPersonasSQLite());
                delete = "SQLITE";
                break;
            case "ELIMINAR_CASSANDRA":
                panelPrincipal.getPanelEliminar().llenarSelect(personaDAO.getPersonasCassandra());
                delete = "CASSANDRA";
                break;
            case "ELIMINAR":
                String id = panelPrincipal.getPanelEliminar().getOptions().getSelectedItem().toString();
                switch (delete){
                    case "ARRAY":
                        boolean flag2 = personaDAO.deleteArray(id);
                        if (flag2) {
                            panelPrincipal.showMesasge("Persona eliminada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al eliminar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                    case "BINARIO":
                        boolean flag3 = false;
                        try {
                            flag3 = personaDAO.deleteBinaryFile(id);
                            if (flag3) {
                                panelPrincipal.showMesasge("Persona eliminada correctamente");
                            } else {
                                panelPrincipal.showMesasge("Error al eliminar la persona");
                            }
                            panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "SQLITE":
                        boolean flag4 = personaDAO.deleteInSQLite(id);
                        if (flag4) {
                            panelPrincipal.showMesasge("Persona eliminada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al eliminar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                    case "CASSANDRA":
                        boolean flag5 = personaDAO.deleteInCassandra(id);
                        if (flag5) {
                            panelPrincipal.showMesasge("Persona eliminada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al eliminar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                }
            case "VER_ACTUALIZAR":
                panelPrincipal.changePanel(panelPrincipal.getPanelUpdate());
                break;
            case "UPDATE_ARRAY":
                panelPrincipal.getPanelUpdate().llenarSelect(personaDAO.getPersonas());
                update = "ARRAY";
                break;
            case "UPDATE_BINARIO":
                panelPrincipal.getPanelUpdate().llenarSelect(personaDAO.getPersonasBinaryFile());
                update = "BINARIO";
                System.out.println("update binario");
                break;
            case "UPDATE_SQLITE":
                panelPrincipal.getPanelUpdate().llenarSelect(personaDAO.getPersonasSQLite());
                update = "SQLITE";
                break;
            case "ACEPTAR_UPDATE":
                Persona personaUpdate = panelPrincipal.getPanelUpdate().validarCampos();
                String name = panelPrincipal.getPanelUpdate().getComboBox().getSelectedItem().toString();
                switch (update){
                    case "ARRAY":
                        boolean flag6 = personaDAO.updateArray(personaUpdate, name);
                        if (flag6) {
                            panelPrincipal.showMesasge("Persona actualizada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al actualizar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                    case "BINARIO":
                        boolean flag7 = personaDAO.updateBinaryFile(personaUpdate, name);
                        if (flag7) {
                            panelPrincipal.showMesasge("Persona actualizada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al actualizar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;
                    case "SQLITE":
                        boolean flag8 = personaDAO.updateSQLite(personaUpdate, name);
                        if (flag8) {
                            panelPrincipal.showMesasge("Persona actualizada correctamente");
                        } else {
                            panelPrincipal.showMesasge("Error al actualizar la persona");
                        }
                        panelPrincipal.changePanel(panelPrincipal.getPanelOpciones());
                        break;

                }
                break;



        }

    }
}

package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.OperacionArchivo;
import co.edu.unbosque.model.persistence.Persona;
import co.edu.unbosque.model.persistence.Sqlite;

import java.io.*;
import java.util.ArrayList;

public class PersonaImpl implements PersonaDAO{

    private ArrayList<Persona> personas;
    private OperacionArchivo operacionArchivo;

    private Sqlite sqlite;


    public PersonaImpl() throws IOException {
        personas = new ArrayList<>();
        operacionArchivo = new OperacionArchivo();
        sqlite = new Sqlite();
    }

    public boolean saveInArray(Persona persona) {
        try {
            personas.add(persona);
            return true;
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }

    public boolean saveInBinaryFile(Persona persona){
        try {
            return operacionArchivo.savePerson(persona);
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }

    @Override
    public boolean saveInSQLite(Persona persona) {
        try {
            sqlite.savePerson(persona);
            return true;
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }

    @Override
    public boolean saveInCassandra(Persona persona) {
        return false;
    }


    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}

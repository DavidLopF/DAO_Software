package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Cassandra;
import co.edu.unbosque.model.persistence.OperacionArchivo;
import co.edu.unbosque.model.persistence.Persona;
import co.edu.unbosque.model.persistence.Sqlite;
import java.io.*;
import java.util.ArrayList;

public class PersonaImpl implements PersonaDAO{

    private ArrayList<Persona> personas;
    private OperacionArchivo operacionArchivo;

    private Sqlite sqlite;

    private Cassandra cassandra;


    public PersonaImpl() throws IOException {
        personas = new ArrayList<>();
        operacionArchivo = new OperacionArchivo();
        sqlite = new Sqlite();
        cassandra = new Cassandra();
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

    @Override
    public ArrayList<Persona> getPersonasArray() {
        return personas;
    }

    public boolean saveInBinaryFile(Persona persona){
        try {
            return operacionArchivo.save(persona);
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Persona> getPersonasBinaryFile() {
        try {
            ArrayList<Persona> personas = operacionArchivo.leer();
            return personas;
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return null;
        }
    }

    @Override
    public boolean saveInSQLite(Persona persona) {
        try {
            sqlite.save(persona);
            return true;
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }

    @Override
    public ArrayList<Persona> getPersonasSQLite() {
        try {
            ArrayList<Persona> personas = sqlite.getInfo();
            return personas;
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return null;
        }
    }

    @Override
    public boolean saveInCassandra(Persona persona) {
        boolean flag = cassandra.save(persona);
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Persona> getPersonasCassandra() {
        ArrayList<Persona> personas = cassandra.getInfo();
        return personas;
    }


    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
}

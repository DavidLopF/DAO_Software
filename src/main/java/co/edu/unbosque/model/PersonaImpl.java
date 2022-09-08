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

    @Override
    public boolean deleteArray(String name) {
        //buscar el usuario en el array
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getName().equals(name)) {
                personas.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteBinaryFile(String name) throws IOException, ClassNotFoundException {
        ArrayList<Persona> personas = operacionArchivo.leer();
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getName().equals(name)) {
                personas.remove(i);
            }
        }
        operacionArchivo.saveArrayList(personas);
        return true;
    }

    @Override
    public boolean deleteInSQLite(String name) {
        return sqlite.delete(name);
    }

    @Override
    public boolean deleteInCassandra(String name) {
        return cassandra.delete(name);
    }

    @Override
    public boolean updateArray(Persona persona, String name) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getName().equals(name)) {
                personas.set(i, persona);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateBinaryFile(Persona personaUpdate, String name) {
        try {
            ArrayList<Persona> personas = operacionArchivo.leer();
            for (int i = 0; i < personas.size(); i++) {
                if (personas.get(i).getName().equals(name)) {
                    personas.set(i, personaUpdate);
                }
            }
            operacionArchivo.saveArrayList(personas);
            return true;
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }

    @Override
    public boolean updateSQLite(Persona personaUpdate, String name) {
        return sqlite.update(personaUpdate, name);
    }


    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }


}

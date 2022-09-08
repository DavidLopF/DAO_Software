package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Persona;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public interface PersonaDAO {
    public boolean saveInArray(Persona persona);

    public ArrayList<Persona> getPersonasArray();
    public boolean saveInBinaryFile(Persona persona);
    public ArrayList<Persona> getPersonasBinaryFile();
    public boolean saveInSQLite(Persona persona);
    public ArrayList<Persona> getPersonasSQLite();


    public boolean saveInCassandra(Persona persona);
    public ArrayList<Persona> getPersonasCassandra();

    public boolean deleteArray(String name);
    public boolean deleteBinaryFile(String name) throws IOException, ClassNotFoundException;

    public boolean deleteInSQLite(String name);

    public boolean deleteInCassandra(String name);

    public boolean updateArray(Persona persona, String name);

    public boolean updateBinaryFile(Persona personaUpdate,String name);

    public boolean updateSQLite(Persona personaUpdate, String name);
}

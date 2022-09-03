package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Persona;

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
}

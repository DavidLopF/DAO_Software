package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Persona;

public interface PersonaDAO {
    public boolean saveInArray(Persona persona);
    public boolean saveInBinaryFile(Persona persona);
    public boolean saveInSQLite(Persona persona);

    public boolean saveInCassandra(Persona persona);
}

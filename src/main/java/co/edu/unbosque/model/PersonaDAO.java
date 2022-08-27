package co.edu.unbosque.model;

public interface PersonaDAO {
    public boolean saveInArray(Persona persona);
    public boolean saveInBinaryFile(Persona persona);
    public boolean saveInSQLite(Persona persona);

    public boolean saveInCassandra(Persona persona);
}

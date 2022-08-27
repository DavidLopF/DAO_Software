package co.edu.unbosque.model.persistence;

import java.io.*;

public class OperacionArchivo {

    private File archivo;
    private FileOutputStream flujoSalida ;
    private ObjectOutputStream flujoObjeto;


    public OperacionArchivo() throws IOException {
        archivo = new File("src/main/resources/archivo.dat");
        flujoSalida = new FileOutputStream(archivo);
        flujoObjeto = new ObjectOutputStream(flujoSalida);
    }

    public boolean savePerson(Persona persona) throws IOException {
        try {
            flujoObjeto.writeObject(persona);
            return true;
        } catch (Exception e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }
}

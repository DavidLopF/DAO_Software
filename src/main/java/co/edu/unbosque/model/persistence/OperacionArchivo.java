package co.edu.unbosque.model.persistence;


import java.io.*;
import java.util.ArrayList;

public class OperacionArchivo {

    private File archivo;
    private ObjectOutputStream flujoObjeto;

    private ObjectInputStream flujoObjetoEntrada;

    private ArrayList<Persona> personas;


    public OperacionArchivo() throws IOException {
        personas = new ArrayList<Persona>();
        archivo = new File("src/main/resources/personas.dat");
    }

    public boolean save(Persona persona) throws IOException, ClassNotFoundException {
        try {
            leer();
            flujoObjeto = new ObjectOutputStream(new FileOutputStream(archivo));
            personas.add(persona);
            flujoObjeto.writeObject(personas);
            flujoObjeto.close();
            return true;
        } catch (IOException e) {
            System.out.println("error in cath " + e);
            return false;
        }
    }

    public ArrayList<Persona> leer() throws IOException, ClassNotFoundException {
        try{
            flujoObjetoEntrada = new ObjectInputStream(new FileInputStream(archivo));
            personas = (ArrayList<Persona>) flujoObjetoEntrada.readObject();
            flujoObjetoEntrada.close();
            return personas;
        }catch (IOException e){
            System.out.println("error in cath " + e);
            return null;
        }catch (ClassNotFoundException e){
            System.out.println("error in cath " + e);
            return null;
        }
    }






}

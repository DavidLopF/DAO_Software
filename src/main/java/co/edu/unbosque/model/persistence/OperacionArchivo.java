package co.edu.unbosque.model.persistence;


import org.w3c.dom.CDATASection;

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

    public boolean savePerson(Persona persona) throws IOException, ClassNotFoundException {
        try {
            leerPersonas();
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

    public void leerPersonas() throws IOException, ClassNotFoundException {
        try{
            flujoObjetoEntrada = new ObjectInputStream(new FileInputStream(archivo));
            personas = (ArrayList<Persona>) flujoObjetoEntrada.readObject();
            System.out.println(personas.toString());
            flujoObjetoEntrada.close();
        }catch (IOException e){
            System.out.println("error in cath " + e);
        }catch (ClassNotFoundException e){
            System.out.println("error in cath " + e);
        }
    }






}

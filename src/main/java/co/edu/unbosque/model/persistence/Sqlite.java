package co.edu.unbosque.model.persistence;


import java.sql.*;
import java.util.ArrayList;

public class Sqlite {

    private Connection connection;

    public Sqlite() {
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/databases/ingSoftwareDAO.sqlite");
            if(connection != null){
                System.out.println("Conexión exitosa con sqlite");
                connection.createStatement().execute("CREATE TABLE IF NOT EXISTS persona (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), sex VARCHAR(50), phoneNumber VARCHAR(20) ,age INTEGER)");
            }
        } catch (Exception e) {
            System.err.println("error in cath " + e);
            System.out.println("Error de conexion " + e);
        }
    }

    public boolean save(Persona persona){
        try {

            connection.createStatement().execute(
                    "INSERT INTO persona VALUES (null, '"+persona.getName()+"', '"+persona.getSex()+"', '"+persona.getPhoneNumber()+"', "+persona.getAge()+")");
            return true;
        } catch (SQLException e) {
            System.err.println("error in cath " + e);
            System.out.println("Error de conexion " + e);
            return false;
        }
    }

    public ArrayList<Persona> getInfo() {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persona");
            ArrayList<Persona> personas = new ArrayList<>();
            while (resultSet.next()){
                personas.add(new Persona(resultSet.getString("name"),resultSet.getString("sex"), resultSet.getString("phoneNumber"), resultSet.getInt("age") ));
            }
            return personas;
        }catch (Exception e){
            System.err.println("error in cath " + e);
            System.out.println("Error de conexion " + e);
            return null;
        }
    }



}

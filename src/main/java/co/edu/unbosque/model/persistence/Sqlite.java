package co.edu.unbosque.model.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite {

    private Connection connection;

    public Sqlite() {
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/databases/ingSoftwareDAO.sqlite");
            if(connection != null){
                System.out.println("Conexión exitosa");
                connection.createStatement().execute("CREATE TABLE IF NOT EXISTS persona (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(50), sex VARCHAR(50), phoneNumber VARCHAR(20) ,age INTEGER)");
            }
        } catch (Exception e) {
            System.err.println("error in cath " + e);
            System.out.println("Error de conexion " + e);
        }
    }

    public boolean savePerson(Persona persona){
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

}

package co.edu.unbosque.model.persistence;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.insert.InsertInto;
import com.datastax.oss.driver.api.querybuilder.select.SelectFrom;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;

public class Cassandra {

    private Cluster cluster;
    private Session session;

    public Cassandra() {

        try {
            Cluster.Builder b = Cluster.builder().addContactPoint("localhost").withPort(9042);
            cluster = b.build();
            session = cluster.connect();

            session.execute("CREATE KEYSPACE IF NOT EXISTS DAO_SOFTWARE WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};");
            session.execute(
                    "CREATE TABLE IF NOT EXISTS DAO_SOFTWARE.persona" +
                            "(id uuid PRIMARY KEY," +
                            "name text," +
                            "sex text," +
                            "age int," +
                            "phone_number text" +
                            ");");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in cath " + e);
        }
    }

    public boolean save(Persona persona) {
        try {
            InsertInto insertInto = insertInto("DAO_SOFTWARE", "persona");
            String query = insertInto.value("id", literal(UUID.randomUUID()))
                    .value("name", literal(persona.getName()))
                    .value("sex", literal(persona.getSex()))
                    .value("age", literal(persona.getAge()))
                    .value("phone_number", literal(persona.getPhoneNumber())).toString();
            session.execute(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in cath " + e);
            return false;
        }
    }

    public ArrayList<Persona> getInfo() {
        try {
            ArrayList<Persona> personas = new ArrayList<>();
            ResultSet resultSet = session.execute("SELECT * FROM DAO_SOFTWARE.persona");
            resultSet.forEach(row -> {
                personas.add(
                        new Persona(row.getString("name"),
                        row.getString("sex"),
                        row.getString("phone_number"),
                        row.getInt("age")));
            });
            System.out.println(personas.toString());
            return personas;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in cath " + e);
            return null;
        }
    }

    public boolean delete(String name) {
        try {
            String query = "DELETE FROM DAO_SOFTWARE.persona WHERE name = '" + name + "';";
            session.execute(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in cath " + e);
            return false;
        }
    }
}
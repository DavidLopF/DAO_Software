package co.edu.unbosque.model.persistence;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.oss.driver.api.querybuilder.insert.InsertInto;
import com.datastax.oss.driver.api.querybuilder.term.Term;

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
        //guardar objeto persona en cassandra
        try {
            InsertInto insert = (InsertInto) insertInto("persona")
                    .value("id", bindMarker())
                    .value("name", literal(persona.getName()))
                    .value("sex", literal(persona.getSex()))
                    .value("age", literal(persona.getSex()))
                    .value("phone_number", literal(persona.getPhoneNumber()));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in cath " + e);
            return false;
        }
    }
}
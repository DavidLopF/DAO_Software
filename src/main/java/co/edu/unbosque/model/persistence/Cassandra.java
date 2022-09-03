package co.edu.unbosque.model.persistence;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Cassandra {

    private Cluster cluster;
    private Session session;

    public Cassandra() {
        try{
            Cluster.Builder b = Cluster.builder().addContactPoint("localhost").withPort(9042);
            cluster = b.build();
            session = cluster.connect();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error in cath " + e);
        }
    }

}

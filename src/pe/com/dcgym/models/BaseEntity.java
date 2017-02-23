package pe.com.dcgym.models;

import java.sql.Connection;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class BaseEntity {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}

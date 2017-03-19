package pe.com.dcgym.services;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public abstract class BaseService {
    private Connection connection;

    public BaseService() {

    }

    public Connection getConnection() {
        if(connection == null) {
            try {
                InitialContext ctx = new InitialContext();
                connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource_dcgym")).getConnection();
            } catch (NamingException e) {
                System.out.println("Error  naming exception");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Error  SQLException");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}



package pe.com.dcgym.services;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by GrupoUTP on 04/03/2017.
 */
public class HrService {
    private Connection connection;

    public HrService() {

    }

    public int getRegionsCount() {
        return 10;
    }

    public boolean validateUser(String userName, String password) {
        return (userName.equalsIgnoreCase("admin") &&
                password.equalsIgnoreCase("password"));
    }

    public Connection getConnection() {
        if(connection == null) {
            try {
                InitialContext ctx = new InitialContext();
                connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource")).getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


}

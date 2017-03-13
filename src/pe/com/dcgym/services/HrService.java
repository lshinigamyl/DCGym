package pe.com.dcgym.services;


import pe.com.dcgym.models.PeopleEntity;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 04/03/2017.
 */
public class HrService {
    private Connection connection;
    private PeopleEntity peopleEntity;

    public HrService() {

    }

    public int getRegionsCount() {
        return 10;
    }

    public boolean validateUser(String userName, String password) {
        return (peopleEntity.validateUser(userName,password));
    }

    public Connection getConnection() {
        if(connection == null) {
            try {
                InitialContext ctx = new InitialContext();
                connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource/dcgym")).getConnection();
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

    public PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }
}

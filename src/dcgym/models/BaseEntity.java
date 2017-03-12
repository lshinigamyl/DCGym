package dcgym.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    protected int getMaxId(String tableName) {
        String sql = "SELECT MAX(id) as max_id FROM "+tableName;
        if (this.getConnection() != null) {
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                return resultSet.next() ? resultSet.getInt(1) : 0;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}

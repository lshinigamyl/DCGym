package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.EmployeeType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fjorsvartnir on 25/02/2017.
 */
public class EmployeeTypesEntity  extends BaseEntity{
    private static String TABLE="employee_types";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;

    public List<EmployeeType> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public EmployeeType findById(int id) {
        List<EmployeeType> employeeTypes = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return employeeTypes != null ? employeeTypes.get(0) : null;
    }

    public EmployeeType findByName(String name) {
        List<EmployeeType> employeeTypes = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return employeeTypes.isEmpty() ? null : employeeTypes.get(0);
    }

    private List<EmployeeType> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<EmployeeType> employeesTypes = new ArrayList<EmployeeType>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    EmployeeType employeeType = new EmployeeType() ;
                    employeeType.setId(resultSet.getInt(1));
                    employeeType.setName(resultSet.getString(2));
                    employeeType.setState(resultSet.getString(3));
                    employeesTypes.add(employeeType);
                }
                return employeesTypes;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public EmployeeType create(String nane, String state) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, nane, state) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

            preparedStatement.setInt   (1, (getMaxId(TABLE)+1));
            preparedStatement.setString(2, nane);
            preparedStatement.setString(3, state);

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                EmployeeType employeeType = new EmployeeType(getMaxId(TABLE),nane, state);
                return employeeType;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //}
        return null;
    }

    private int updateByCriteria(String sql) {
        if (this.getConnection() != null) {
            try {
                return this.getConnection().createStatement().executeUpdate(sql);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return this.updateByCriteria("DELETE FROM "+TABLE+" WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(EmployeeType employeeType) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET nane ='"+ employeeType.getName()+"', state='"+ employeeType.getState()+"' WHERE id = " + String.valueOf(employeeType.getId())) > 0;
    }
}

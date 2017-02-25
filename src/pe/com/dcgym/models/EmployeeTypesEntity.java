package pe.com.dcgym.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fjorsvartnir on 25/02/2017.
 */
public class EmployeeTypesEntity  extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM employee_types";

    public List<EmployeeTypes> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public EmployeeTypes findById(int id) {
        List<EmployeeTypes> employeeTypes = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return employeeTypes != null ? employeeTypes.get(0) : null;
    }

    public EmployeeTypes findByName(String name) {
            List<EmployeeTypes> employeeTypes = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
            return employeeTypes.isEmpty() ? null : employeeTypes.get(0);
        }

    private List<EmployeeTypes> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<EmployeeTypes> employeesTypes = new ArrayList<EmployeeTypes>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    EmployeeTypes employeeTypes = new EmployeeTypes() ;
                        employeeTypes.setId(resultSet.getInt(1));
                        employeeTypes.setName(resultSet.getString(2));
                        employeeTypes.setState(resultSet.getString(3));
                    employeesTypes.add(employeeTypes);
                }
                return employeesTypes;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public EmployeeTypes create(String nane, String state) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO employee_types(id, nane, state) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

            preparedStatement.setInt   (1, (getMaxId("employee_types")+1));
            preparedStatement.setString(2, nane);
            preparedStatement.setString(3, state);

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                EmployeeTypes employeeTypes = new EmployeeTypes(getMaxId("employee_types"),nane, state);
                return employeeTypes;
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
        return this.updateByCriteria("DELETE FROM employee_types WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(EmployeeTypes employeeTypes) {
        return this.updateByCriteria("UPDATE employee_types SET nane ='"+employeeTypes.getName()+"', state='"+employeeTypes.getState()+"' WHERE id = " + String.valueOf(employeeTypes.getId())) > 0;
    }
}

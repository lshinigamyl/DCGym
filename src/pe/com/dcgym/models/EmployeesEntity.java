package pe.com.dcgym.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fjorsvartnir on 25/02/2017.
 */
public class EmployeesEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM employees";
    private TrainingCentersEntity trainingCentersEntity;
    private PeopleEntity peopleEntity;
    private EmployeesEntity employeeTypesEntity;

    public List<Employee> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Employee findById(int id) {
        List<Employee> customers = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customers != null ? customers.get(0) : null;
    }
/*
    public Employee findByName(String name) {
        List<Employee> customers = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customers.isEmpty() ? null : customers.get(0);
    }
*/
    private List<Employee> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Employee> employees = new ArrayList<Employee>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Employee employee = Employee.build(resultSet,getTrainingCentersEntity(),getPeopleEntity(),getEmployeeTypesEntity());
                    employees.add(employee);
                }
                return employees;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Employee create(String state, TrainingCenter trainingCenters, People people, EmployeeTypes employeeTypes) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO employees(id, state, training_centers_id, people_id, employee_types_id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

                preparedStatement.setInt   (1, (getMaxId("employees")+1));
                preparedStatement.setString(2, state);
                preparedStatement.setInt   (3, trainingCenters.getId());
                preparedStatement.setInt   (4, people.getId());
                preparedStatement.setInt   (3, employeeTypes.getId());

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                Employee employee = new Employee(getMaxId("employees"),state, trainingCenters,people,employeeTypes);
                return employee;
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
        return this.updateByCriteria("DELETE FROM employees WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(Employee employee) {
        return this.updateByCriteria("UPDATE employees SET state ='"+employee.getState()+"', training_centers_id="+employee.trainingCenters.getId()+" ,people_id="+employee.people.getId()+" ,employee_types_id="+employee.employeeTypes.getId()+"  WHERE id = " + String.valueOf(employee.getId())) > 0;
    }

    private PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    private TrainingCentersEntity getTrainingCentersEntity() {
        return trainingCentersEntity;
    }

    public void setTrainingCentersEntity(TrainingCentersEntity trainingCentersEntity) {
        this.trainingCentersEntity = trainingCentersEntity;
    }

    private EmployeesEntity getEmployeeTypesEntity() {
        return employeeTypesEntity;
    }

    public void setEmployeeTypesEntity(EmployeesEntity employeeTypesEntity) {
        this.employeeTypesEntity = employeeTypesEntity;
    }
}

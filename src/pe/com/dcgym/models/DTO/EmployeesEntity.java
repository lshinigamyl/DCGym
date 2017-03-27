package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeesEntity extends BaseEntity {
    private static final String TABLE="employees";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private GymEntity gymEntity;
    private PeopleEntity peopleEntity;
    private EmployeeTypesEntity employeeTypesEntity;

    public List<Employee> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Employee findById(int id) {
        List<Employee> customers = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customers != null ? customers.get(0) : null;
    }
    public List<Employee> findByTraininCenterID(String id){
        return this.findByCriteria("SELECT " +
                "e.id, " +
                "e.state, " +
                "e.gym_id, " +
                "e.people_id, " +
                "e.employee_type_id " +
                "FROM " +
                "employees AS e " +
                "WHERE " +
                "e.gym_id = '"+id+"'");
    }
/*

*/
    private List<Employee> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Employee> employees = new ArrayList<Employee>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Employee employee = Employee.build(resultSet, getGymEntity(),getPeopleEntity(),getEmployeeTypesEntity());
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



    public Employee create(Employee employee) {
        //
        employee.setPeople(getPeopleEntity().create(employee.getPeople()));
        String sql = "INSERT INTO `employees` (`gym_id`, `people_id`, `employee_type_id`) VALUES (?,?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

                preparedStatement.setInt   (1, employee.getGym().getId());
                preparedStatement.setInt   (2, employee.getPeople().getId());
                preparedStatement.setInt   (3, employee.getEmployeeType().getId());

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                employee.setId(super.getMaxId(TABLE));
                return employee;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //
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
        return this.updateByCriteria("UPDATE employees SET state ='"+employee.getState()+"', training_centers_id="+employee.getGym().getId()+" ,people_id="+employee.getPeople().getId()+" ,employee_types_id="+employee.getEmployeeType().getId()+"  WHERE id = " + String.valueOf(employee.getId())) > 0;
    }

    public PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    private GymEntity getGymEntity() {
        return gymEntity;
    }

    public void setGymEntity(GymEntity gymEntity) {
        this.gymEntity = gymEntity;
    }

    public EmployeeTypesEntity getEmployeeTypesEntity() {
        return employeeTypesEntity;
    }

    public void setEmployeeTypesEntity(EmployeeTypesEntity employeeTypesEntity) {
        this.employeeTypesEntity = employeeTypesEntity;
    }
}

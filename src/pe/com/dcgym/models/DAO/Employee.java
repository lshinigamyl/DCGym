package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.EmployeeTypesEntity;
import pe.com.dcgym.models.DTO.GymEntity;
import pe.com.dcgym.models.DTO.PeopleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**

 */
public class Employee {
    int id;
    String state;
    Gym gym;
    People people;
    EmployeeType employeeType;


    public Employee() {
    }

    public Employee(int id, String state, Gym gym, People people, EmployeeType employeeType) {
        this.id = id;
        this.state = state;
        this.gym = gym;
        this.people = people;
        this.employeeType = employeeType;
    }

    public static Employee build(ResultSet resultSet, GymEntity gymEntity, PeopleEntity peopleEntity, EmployeeTypesEntity employeeTypesEntity) {
        try {
            return new Employee(    resultSet.getInt("id"),
                                    resultSet.getString("state"),
                                    gymEntity.findById(resultSet.getInt("gym_id")),
                                    peopleEntity.findById(resultSet.getInt("people_id")),
                                    employeeTypesEntity.findById(resultSet.getInt("employee_type_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}


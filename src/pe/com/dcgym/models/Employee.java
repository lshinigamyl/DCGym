package pe.com.dcgym.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Soy un Gato xD
 */
public class Employee {
    int id;
    String state;
    TrainingCenter trainingCenters;
    People people;
    EmployeeTypes employeeTypes;


    public Employee() {
    }

    public Employee(int id, String state, TrainingCenter trainingCenters, People people, EmployeeTypes employeeTypes) {
        this.id = id;
        this.state = state;
        this.trainingCenters = trainingCenters;
        this.people = people;
        this.employeeTypes = employeeTypes;
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

    public TrainingCenter getTrainingCenters() {
        return trainingCenters;
    }

    public void setTrainingCenters(TrainingCenter trainingCenters) {
        this.trainingCenters = trainingCenters;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public EmployeeTypes getEmployeeTypes() {
        return employeeTypes;
    }

    public void setEmployeeTypes(EmployeeTypes employeeTypes) {
        this.employeeTypes = employeeTypes;
    }

    public static Employee build(ResultSet resultSet, TrainingCentersEntity trainingCentersEntity,PeopleEntity peopleEntity, EmployeeTypesEntity employeeTypesEntity) {
        try {
            Employee employee= new Employee();
            return new Employee(resultSet.getInt("id"),resultSet.getString("state"),trainingCentersEntity.findById(resultSet.getInt("training_centers_id")), peopleEntity.findById(resultSet.getInt("people_id")), employeeTypesEntity.findById(resultSet.getInt("employee_types_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


package pe.com.dcgym.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Soy un Gato xD
 */
public class Employee {
    private int id;
    private String state;
    private TrainingCenter trainingCenters;
    private People people;
    private EmployeeType employeeType;


    public Employee() {
    }

    public Employee(int id, String state, TrainingCenter trainingCenters, People people, EmployeeType employeeType) {
        this.setId(id);
        this.setState(state);
        this.setTrainingCenters(trainingCenters);
        this.setPeople(people);
        this.setEmployeeType(employeeType);
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

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
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

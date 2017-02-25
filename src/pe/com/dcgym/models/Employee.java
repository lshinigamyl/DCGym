package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class Employee {
    int id;
    String state;
    int trainingCentersId;
    People people;
    EmployeeTypes employeeTypes;


    public Employee() {
    }

    public Employee(int id, String state, int trainingCentersId, People people, EmployeeTypes employeeTypes) {
        this.id = id;
        this.state = state;
        this.trainingCentersId = trainingCentersId;
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

    public int getTrainingCentersId() {
        return trainingCentersId;
    }

    public void setTrainingCentersId(int trainingCentersId) {
        this.trainingCentersId = trainingCentersId;
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
}


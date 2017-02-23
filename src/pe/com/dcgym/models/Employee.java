package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class Employee {
    int idEmployee;
    int idTrainingCenters;
    int idPeople;
    int typeEmployee;
    String State;

    public Employee() {
    }

    public Employee(int idEmployee, int idTrainingCenters, int idPeople, int typeEmployee, String State) {
        this.idEmployee = idEmployee;
        this.idTrainingCenters = idTrainingCenters;
        this.idPeople = idPeople;
        this.typeEmployee = typeEmployee;
        this.State = State;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdTrainingCenters() {
        return idTrainingCenters;
    }

    public void setIdTrainingCenters(int idTrainingCenters) {
        this.idTrainingCenters = idTrainingCenters;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public int getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(int typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

}


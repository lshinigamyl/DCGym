package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class Client {
    int idClient;
    int idPeople;
    int idEmployee;
    String comment;
    String state;

    public Client() {
    }

    public Client(int idClient, int idPeople, int idEmployee, String comment, String state) {
        this.idClient = idClient;
        this.idPeople = idPeople;
        this.idEmployee = idEmployee;
        this.comment = comment;
        this.state = state;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}


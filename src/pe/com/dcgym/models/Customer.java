package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class Customer {
    int id;
    String comment;
    String state;
    People people;

    public Customer() {
    }

    public Customer(int id, String comment, String state, People people) {
        this.id = id;
        this.comment = comment;
        this.state = state;
        this.people = people;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}


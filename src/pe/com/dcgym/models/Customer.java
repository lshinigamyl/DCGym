package pe.com.dcgym.models;

import java.sql.ResultSet;
import java.sql.SQLException;

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


    public static Customer build(ResultSet resultSet, PeopleEntity peopleEntity) {
        try {
            return new Customer(resultSet.getInt("id"),
                                resultSet.getString("coment"),
                                resultSet.getString("state"),
                                peopleEntity.findById(resultSet.getInt("people_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.RoutinesEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class CustomerRoutine {
    private int id;
    private String state;
    private Customer customer;
    private Routine routine;

    public CustomerRoutine(int id, String state, Customer customer, Routine routine) {
        this.id = id;
        this.state = state;
        this.customer = customer;
        this.routine = routine;
    }

    public CustomerRoutine(){

    }
    public static CustomerRoutine build(ResultSet resultSet, CustomersEntity customersEntity, RoutinesEntity routinesEntity) {
        try {
            return new CustomerRoutine( resultSet.getInt("id"),
                                        resultSet.getString("state"),
                                        customersEntity.findById(resultSet.getInt("customer_id")),
                                        routinesEntity.findById(resultSet.getInt("routine_id")));
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
}

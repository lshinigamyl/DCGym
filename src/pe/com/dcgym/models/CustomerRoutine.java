package pe.com.dcgym.models;

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
    private Employee employee;

    public CustomerRoutine(int id, String state, Customer customer, Routine routine, Employee employee) {
        this.setId(id);
        this.setState(state);
        this.setCustomer(customer);
        this.setRoutine(routine);
        this.setEmployee(employee);
    }
    public CustomerRoutine(){

    }
    public static CustomerRoutine build(ResultSet resultSet, CustomersEntity customersEntity, RoutinesEntity routinesEntity, EmployeesEntity employeesEntity) {
        try {
            return new CustomerRoutine(resultSet.getInt("id"),
                    resultSet.getString("state"),
                    customersEntity.findById(resultSet.getInt("customers_id")),
                    routinesEntity.findById(resultSet.getInt("routines_id")),
                    employeesEntity.findById(resultSet.getInt("employees_id"))
                    );
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

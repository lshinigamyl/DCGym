package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.GymsMembershipTypesEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerGymMembershipType {
    private int id;
    private Date startDate;
    private Date dueDate;
    private String state;
    private Customer customer;
    private GymMembershipTypes gymMembershipTypes;

    public CustomerGymMembershipType() {
    }

    public CustomerGymMembershipType(int id, Date startDate, Date dueDate, String state, Customer customer, GymMembershipTypes gymMembershipTypes) {
        this.id = id;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.state = state;
        this.customer = customer;
        this.gymMembershipTypes = gymMembershipTypes;
    }

    public static CustomerGymMembershipType build(ResultSet resultSet, CustomersEntity customersEntity, GymsMembershipTypesEntity gymsMembershipTypesEntity) {
        try {
            return new CustomerGymMembershipType(   resultSet.getInt("id"),
                                                    resultSet.getDate("start_date"),
                                                    resultSet.getDate("due_date"),
                                                    resultSet.getString("state"),
                                                    customersEntity.findById(resultSet.getInt("customer_id")),
                                                    gymsMembershipTypesEntity.findById(resultSet.getInt("gyms_membership_types_id")));
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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

    public GymMembershipTypes getGymMembershipTypes() {
        return gymMembershipTypes;
    }

    public void setGymMembershipTypes(GymMembershipTypes gymMembershipTypes) {
        this.gymMembershipTypes = gymMembershipTypes;
    }
}

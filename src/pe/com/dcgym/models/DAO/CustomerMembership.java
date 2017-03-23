package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;
import pe.com.dcgym.models.DTO.TrainingCentersMembershipsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;



public class CustomerMembership {
    private int id;
    private String state;
    private Customer customer;
    private TrainingCenterMembership trainingCenterMembership;

    public CustomerMembership() {
    }

    public CustomerMembership(int id, String state, Customer customer, TrainingCenterMembership trainingCenterMembership) {
        this.id = id;
        this.state = state;
        this.customer = customer;
        this.trainingCenterMembership = trainingCenterMembership;
    }

    public static CustomerMembership build(ResultSet resultSet, CustomersEntity customersEntity, TrainingCentersMembershipsEntity trainingCentersMembershipsEntity) {
        try {
            return new CustomerMembership(resultSet.getInt("id"),
                                        resultSet.getString("state"),
                                            customersEntity.findById(resultSet.getInt("customers_id")),
                                            trainingCentersMembershipsEntity.findById(resultSet.getInt("training_center_memberships_id")));
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

    public TrainingCenterMembership getTrainingCenterMembership() {
        return trainingCenterMembership;
    }

    public void setTrainingCenterMembership(TrainingCenterMembership trainingCenterMembership) {
        this.trainingCenterMembership = trainingCenterMembership;
    }
}

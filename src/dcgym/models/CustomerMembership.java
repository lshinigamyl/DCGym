package dcgym.models;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerMembership {
    private int id;
    private String state;
    private Customer customer;
    private MembershipType membershipType;

    public CustomerMembership() {
    }

    public CustomerMembership(int id, String state, Customer customer, MembershipType membershipType) {
        this.setId(id);
        this.setState(state);
        this.setCustomer(customer);
        this.setMembershipType(membershipType);
    }
    public static CustomerMembership build(ResultSet resultSet, CustomersEntity customersEntity, MembershipsTypeEntity membershipsTypeEntity) {
        try {
            return new CustomerMembership(resultSet.getInt("id"),
                                        resultSet.getString("state"),
                                            customersEntity.findById(resultSet.getInt("customers_id")),
                                            membershipsTypeEntity.findById(resultSet.getInt("membership_types_id")));
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

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }
}

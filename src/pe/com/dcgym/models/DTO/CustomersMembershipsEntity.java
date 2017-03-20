package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.CustomerMembership;
import pe.com.dcgym.models.DAO.MembershipType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Correjido
 */
public class CustomersMembershipsEntity extends BaseEntity{
    private static String TABLE="customers_memberships";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private CustomersEntity customersEntity;
    private MembershipsTypeEntity membershipsTypeEntity;

    public List<CustomerMembership> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public CustomerMembership findById(int id) {
        List<CustomerMembership> customerMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customerMemberships != null ? customerMemberships.get(0) : null;
    }
/*
    public CustomerMembership findByName(String name) {
        List<CustomerMembership> customerMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customerMemberships.isEmpty() ? null : customerMemberships.get(0);
    }
*/
    private List<CustomerMembership> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<CustomerMembership> customerMemberships = new ArrayList<CustomerMembership>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    CustomerMembership customerMembership = CustomerMembership.build(resultSet,getCustomersEntity(),getMembershipsTypeEntity());
                    customerMemberships.add(customerMembership);
                }
                return customerMemberships;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public CustomerMembership create(String coment, String state, Customer customer, MembershipType membershipType) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, coment, state, people_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, coment);
            obj.setInt   (3, customer.getId());
            obj.setInt   (4, membershipType.getId());

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                CustomerMembership customerMembership = new CustomerMembership(getMaxId(TABLE), coment,customer,membershipType);
                return customerMembership;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //}
        return null;
    }

    private int updateByCriteria(String sql) {
        if (this.getConnection() != null) {
            try {
                return this.getConnection().createStatement().executeUpdate(sql);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return this.updateByCriteria("DELETE FROM "+TABLE+" WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(CustomerMembership customerMembership) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET state ='"+customerMembership.getState()+"', customers_id="+ customerMembership.getCustomer().getId()+" , membership_types_id="+customerMembership.getMembershipType().getId()+"   WHERE id = " + String.valueOf(customerMembership.getId())) > 0;
    }

    public CustomersEntity getCustomersEntity() {
        return customersEntity;
    }

    public void setCustomersEntity(CustomersEntity customersEntity) {
        this.customersEntity = customersEntity;
    }

    public MembershipsTypeEntity getMembershipsTypeEntity() {
        return membershipsTypeEntity;
    }

    public void setMembershipsTypeEntity(MembershipsTypeEntity membershipsTypeEntity) {
        this.membershipsTypeEntity = membershipsTypeEntity;
    }
}

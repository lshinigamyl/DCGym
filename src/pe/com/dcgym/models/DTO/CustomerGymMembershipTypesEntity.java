package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.CustomerGymMembershipType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerGymMembershipTypesEntity extends BaseEntity {
    private static String TABLE="customers_gym_membership_types";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private CustomersEntity customersEntity;
    private GymsMembershipTypesEntity gymsMembershipTypesEntity;

    public List<CustomerGymMembershipType> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public CustomerGymMembershipType findById(int id) {
        List<CustomerGymMembershipType> customerGymMembershipTypes = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customerGymMembershipTypes.isEmpty() ? null : customerGymMembershipTypes.get(0);
    }
    public List<CustomerGymMembershipType> findByTrainingCenterUser(int id){
        return this.findByCriteria("SELECT " +
                "c.id, " +
                "c.start_date, " +
                "c.due_date, " +
                "c.state, " +
                "c.customer_id, " +
                "c.gyms_membership_types_id " +
                "FROM " +
                "customers_gym_membership_types AS c " +
                "INNER JOIN gyms_membership_types AS g ON c.gyms_membership_types_id = g.id " +
                "WHERE " +
                "g.gym_id = '"+id+"'");
    }
/*
    public CustomerGymMembershipType findByName(String name) {
        List<CustomerGymMembershipType> customerMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customerMemberships.isEmpty() ? null : customerMemberships.get(0);
    }
*/

    private List<CustomerGymMembershipType> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<CustomerGymMembershipType> customerGymMembershipTypes = new ArrayList<CustomerGymMembershipType>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    CustomerGymMembershipType customerGymMembershipType = CustomerGymMembershipType.build(resultSet,getCustomersEntity(), getGymsMembershipTypesEntity());
                    customerGymMembershipTypes.add(customerGymMembershipType);
                }
                return customerGymMembershipTypes;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public CustomerGymMembershipType create(CustomerGymMembershipType customerGymMembershipType) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        customerGymMembershipType.setCustomer(getCustomersEntity().create(customerGymMembershipType.getCustomer()));
        String sql = "INSERT INTO `customers_gym_membership_types` (\n" +
                "\t`start_date`,\n" +
                "\t`due_date`,\n" +
                "\t`customer_id`,\n" +
                "\t`gyms_membership_types_id`\n" +
                ")\n" +
                "VALUES\n" +
                "\t(\n" +
                "\t\tCURDATE(),\n" +
                "\t\tDATE_ADD(\n" +
                "\t\t\tCURDATE(),\n" +
                "\t\t\tINTERVAL (\n" +
                "\t\t\t\tSELECT\n" +
                "\t\t\t\t\tm.days_duration\n" +
                "\t\t\t\tFROM\n" +
                "\t\t\t\t\tmembership_types AS m\n" +
                "\t\t\t\tINNER JOIN gyms_membership_types AS g ON g.membership_type_id = m.id\n" +
                "\t\t\t\tWHERE\n" +
                "\t\t\t\t\tg.id = ? \n" +
                "\t\t\t) DAY\n" +
                "\t\t),\n" +
                "\t\t ? ,\n" +
                "\t\t ? \n" +
                "\t);";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);
            obj.setInt (1, customerGymMembershipType.getGymMembershipTypes().getId());
            obj.setInt (2, customerGymMembershipType.getCustomer().getId());
            obj.setInt (3, customerGymMembershipType.getGymMembershipTypes().getId());

            int results = obj.executeUpdate();
            if (results > 0) {
                customerGymMembershipType.setId(super.getMaxId(TABLE));
                return customerGymMembershipType;
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

    public boolean update(CustomerGymMembershipType customerGymMembershipType) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET state ='"+ customerGymMembershipType.getState()+"', customers_id="+ customerGymMembershipType.getCustomer().getId()+" , membership_types_id="+ customerGymMembershipType.getGymMembershipTypes().getId()+"   WHERE id = " + String.valueOf(customerGymMembershipType.getId())) > 0;
    }

    public CustomersEntity getCustomersEntity() {
        return customersEntity;
    }

    public void setCustomersEntity(CustomersEntity customersEntity) {
        this.customersEntity = customersEntity;
    }

    public GymsMembershipTypesEntity getGymsMembershipTypesEntity() {
        return gymsMembershipTypesEntity;
    }

    public void setGymsMembershipTypesEntity(GymsMembershipTypesEntity gymsMembershipTypesEntity) {
        this.gymsMembershipTypesEntity = gymsMembershipTypesEntity;
    }
}

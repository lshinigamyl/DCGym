package dcgym.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CustomersEntity extends BaseEntity {
    private static String TABLE="customers";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private PeopleEntity peopleEntity;

    public List<Customer> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Customer findById(int id) {
        List<Customer> customers = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customers != null ? customers.get(0) : null;
    }
/*
    public Customer findByName(String name) {
        List<Customer> customers = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customers.isEmpty() ? null : customers.get(0);
    }
*/
    private List<Customer> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Customer> customers = new ArrayList<Customer>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Customer customer = Customer.build(resultSet, getPeopleEntity());
                    customers.add(customer);
                }
                return customers;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Customer create(String coment, String state, People people) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
            String sql = "INSERT INTO customers(id, coment, state, people_id) VALUES(?,?,?,?)";
            try {
                PreparedStatement obj =  this.getConnection().prepareStatement(sql);

                    obj.setInt   (1, (getMaxId(TABLE)+1));
                    obj.setString(2, coment);
                    obj.setString(3, state);
                    obj.setInt   (4, people.getId());

                int results = obj.executeUpdate(sql);
                if (results > 0) {
                    Customer customer = new Customer(getMaxId(TABLE), coment,state, people);
                    return customer;
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

    public boolean update(Customer customer) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET coment = '" + customer.getComment() + "', state ='"+customer.getState()+"', people_id="+ customer.getPeople().getId()+"  WHERE id = " + String.valueOf(customer.getId())) > 0;
    }

    public PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }
}

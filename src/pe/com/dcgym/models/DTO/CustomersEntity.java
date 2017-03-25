package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomersEntity extends BaseEntity {
    private static final String TABLE = "customers";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private PeopleEntity peopleEntity;

    public List<Customer> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Customer findById(int id) {
        List<Customer> customers = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id)+";");
        return customers.isEmpty() ?  null : customers.get(0);
    }

    public Customer findByCustomerUserName(String userName) {
        List<Customer> peoples = this.findByCriteria("SELECT " +
                "c.id, " +
                "c.`comment`, " +
                "c.state, " +
                "c.people_id " +
                "FROM " +
                "customers AS c " +
                "INNER JOIN people AS p ON c.people_id = p.id " +
                "WHERE " +
                "p.username = '"+userName+"';");
        return peoples.isEmpty() ? null : peoples.get(0);
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



    public Customer create(Customer customer) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
            customer.setPeople(getPeopleEntity().create(customer.getPeople()));

            String sql = "INSERT INTO `customers` (`comment`, `people_id`) VALUES (?,?)";
            try {
                PreparedStatement obj =  this.getConnection().prepareStatement(sql);

                    obj.setString(1, customer.getComment());
                    obj.setInt   (2, customer.getPeople().getId());

                int results = obj.executeUpdate(sql);
                if (results > 0) {
                    customer.setId(getMaxId(TABLE));
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

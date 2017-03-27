package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.CustomerRoutine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomersRoutinesEntity  extends  BaseEntity{
    private static String TABLE="customers_routines";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private CustomersEntity customersEntity;
    private RoutinesEntity routinesEntity;

    public List<CustomerRoutine> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public CustomerRoutine findById(int id) {
        List<CustomerRoutine> customerRoutines = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customerRoutines != null ? customerRoutines.get(0) : null;
    }

    public CustomerRoutine findByName(String name) {
        List<CustomerRoutine> customerRoutines = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customerRoutines.isEmpty() ? null : customerRoutines.get(0);
    }

    private List<CustomerRoutine> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<CustomerRoutine> customerRoutines = new ArrayList<CustomerRoutine>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    CustomerRoutine customerRoutine = CustomerRoutine.build(resultSet, getCustomersEntity(),getRoutinesEntity());
                    customerRoutines.add(customerRoutine);
                }
                return customerRoutines;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public CustomerRoutine create(CustomerRoutine customerRoutine) {
        //
        String sql = "INSERT INTO `customers_routines` (`customer_id`, `routine_id`) VALUES (?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, customerRoutine.getCustomer().getId());
            obj.setInt   (2, customerRoutine.getRoutine().getId());

            int results = obj.executeUpdate();
            if (results > 0) {
                customerRoutine.setId(super.getMaxId(TABLE));
                return customerRoutine;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //
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

    public boolean update(CustomerRoutine customerRoutine) {
        return this.updateByCriteria("UPDATE `customers_routines` SET `customer_id`='"+customerRoutine.getCustomer().getId()+"', `routine_id`='"+customerRoutine.getRoutine().getId()+"' WHERE (`id`='"+customerRoutine.getId()+"')") > 0;
    }

    public CustomersEntity getCustomersEntity() {
        return customersEntity;
    }

    public void setCustomersEntity(CustomersEntity customersEntity) {
        this.customersEntity = customersEntity;
    }

    public RoutinesEntity getRoutinesEntity() {
        return routinesEntity;
    }

    public void setRoutinesEntity(RoutinesEntity routinesEntity) {
        this.routinesEntity = routinesEntity;
    }

}

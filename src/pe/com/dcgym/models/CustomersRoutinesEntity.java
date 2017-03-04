package pe.com.dcgym.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fjorsvartnir on 26/02/2017.
 */
public class CustomersRoutinesEntity  extends  BaseEntity{
    private static String TABLE="customers_routines";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private CustomersEntity customersEntity;
    private RoutinesEntity routinesEntity;
    private EmployeesEntity employeesEntity;

    public List<CustomerRoutine> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public CustomerRoutine findById(int id) {
        List<CustomerRoutine> customerRoutines = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customerRoutines != null ? customerRoutines.get(0) : null;
    }
/*
    public CustomerRoutine findByName(String name) {
        List<CustomerRoutine> customerRoutines = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customerRoutines.isEmpty() ? null : customerRoutines.get(0);
    }
*/
    private List<CustomerRoutine> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<CustomerRoutine> customerRoutines = new ArrayList<CustomerRoutine>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    CustomerRoutine customerRoutine = CustomerRoutine.build(resultSet, getCustomersEntity(),getRoutinesEntity(),getEmployeesEntity());
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



    public CustomerRoutine create(String state, Customer customer,Routine routine,Employee employee) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, state, customers_id, routines_id, employees_id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, state);
            obj.setInt   (3, customer.getId());
            obj.setInt   (4, routine.getId());
            obj.setInt   (5, employee.getId());

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                CustomerRoutine customerRoutine = new CustomerRoutine(getMaxId(TABLE), state, customer, routine, employee);
                return customerRoutine;
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

    public boolean update(CustomerRoutine customerRoutine) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET state ='"+customerRoutine.getState()+"', customers_id="+ customerRoutine.getCustomer().getId()+" , routines_id="+customerRoutine.getRoutine().getId()+", employees_id="+customerRoutine.getEmployee().getId()+" WHERE id = " + String.valueOf(customerRoutine.getId())) > 0;
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

    public EmployeesEntity getEmployeesEntity() {
        return employeesEntity;
    }

    public void setEmployeesEntity(EmployeesEntity employeesEntity) {
        this.employeesEntity = employeesEntity;
    }
}

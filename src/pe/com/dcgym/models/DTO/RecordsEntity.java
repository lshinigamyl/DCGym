package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Record;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 */
public class RecordsEntity extends BaseEntity{
    private static String TABLE="records";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private CustomersRoutinesEntity customersRoutinesEntity;
    private EmployeesEntity employeesEntity;

    public List<Record> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Record findById(int id) {
        List<Record> records = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return records != null ? records.get(0) : null;
    }
    
        public Record findByName(String name) {
            List<Record> customerRoutines = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
            return customerRoutines.isEmpty() ? null : customerRoutines.get(0);
        }
    
    private List<Record> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Record> records = new ArrayList<Record>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Record record = Record.build(resultSet, getCustomersRoutinesEntity(),getEmployeesEntity());
                    records.add(record);
                }
                return records;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Record create(Record record) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO `records` (`date`, `duration`, `progress`, `comment`, `customer_routine_id`, `employee_id`) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setDate  (1,record.getDate());
            obj.setInt   (2, record.getDuration());
            obj.setInt   (3, record.getProgress());
            obj.setString(4, record.getComment());
            obj.setInt   (5, record.getCustomerRoutine().getId());
            obj.setInt   (6, record.getEmployee().getId());
            int results = obj.executeUpdate();
            if (results > 0) {
                record.setId(super.getMaxId(TABLE));
                return record;
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

    public boolean update(Record record) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET date ='"+record.getDate()+"', duration='"+ record.getDuration()+"' , advance='"+record.getProgress()+"', coment='"+record.getComment()+"', customer_routine_id="+record.getCustomerRoutine().getId()+" WHERE id = " + String.valueOf(record.getId())) > 0;
    }

    public CustomersRoutinesEntity getCustomersRoutinesEntity() {
        return customersRoutinesEntity;
    }

    public void setCustomersRoutinesEntity(CustomersRoutinesEntity customersRoutinesEntity) {
        this.customersRoutinesEntity = customersRoutinesEntity;
    }

    public EmployeesEntity getEmployeesEntity() {
        return employeesEntity;
    }

    public void setEmployeesEntity(EmployeesEntity employeesEntity) {
        this.employeesEntity = employeesEntity;
    }
}


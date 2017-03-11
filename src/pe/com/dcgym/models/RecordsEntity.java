package pe.com.dcgym.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RecordsEntity extends BaseEntity{
    private static String TABLE="records";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private CustomersRoutinesEntity customersRoutinesEntity;

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
                    Record record = Record.build(resultSet, getCustomersRoutinesEntity());
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



    public Record create(String date,String duration,String advance,String coment, CustomerRoutine customerRoutine) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, date, duration, advance, coment, customer_routine_id) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, date);
            obj.setString(3, duration);
            obj.setString(4, advance);
            obj.setString(5, coment);
            obj.setInt   (6, customerRoutine.getId());
            int results = obj.executeUpdate(sql);
            if (results > 0) {
                Record record = new Record(getMaxId(TABLE), date, duration, advance, coment,customerRoutine);
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
        return this.updateByCriteria("UPDATE "+TABLE+" SET date ='"+record.getDate()+"', duration='"+ record.getDuration()+"' , advance='"+record.getAdvance()+"', coment='"+record.getComent()+"', customer_routine_id="+record.getCustomerRoutine().getId()+" WHERE id = " + String.valueOf(record.getId())) > 0;
    }

    public CustomersRoutinesEntity getCustomersRoutinesEntity() {
        return customersRoutinesEntity;
    }

    public void setCustomersRoutinesEntity(CustomersRoutinesEntity customersRoutinesEntity) {
        this.customersRoutinesEntity = customersRoutinesEntity;
    }
}


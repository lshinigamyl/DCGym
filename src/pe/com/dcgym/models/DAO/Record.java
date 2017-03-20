package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.CustomersRoutinesEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class Record {
    private int id;
    private String date;
    private String duration;
    private String advance;
    private String coment;
    private CustomerRoutine customerRoutine;

    public Record(){

    }

    public Record(int id, String date, String duration, String advance, String coment, CustomerRoutine customerRoutine) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.advance = advance;
        this.coment = coment;
        this.customerRoutine = customerRoutine;
    }
    public static Record build(ResultSet resultSet, CustomersRoutinesEntity customersRoutinesEntity) {
        try {
            return new Record(resultSet.getInt("id"),resultSet.getString("date"),resultSet.getString("duration"),resultSet.getString("advance"),resultSet.getString("coment"),customersRoutinesEntity.findById(resultSet.getInt("customer_routine_id")));
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public CustomerRoutine getCustomerRoutine() {
        return customerRoutine;
    }

    public void setCustomerRoutine(CustomerRoutine customerRoutine) {
        this.customerRoutine = customerRoutine;
    }
}



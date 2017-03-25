package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.CustomersRoutinesEntity;
import pe.com.dcgym.models.DTO.EmployeesEntity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Record {
    private int id;
    private Date date;
    private int duration;
    private int progress;
    private String comment;
    private CustomerRoutine customerRoutine;
    private Employee employee;

    public Record(){

    }

    public Record(int id, Date date, int duration, int progress, String comment, CustomerRoutine customerRoutine, Employee employee) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.progress = progress;
        this.comment = comment;
        this.customerRoutine = customerRoutine;
        this.employee = employee;
    }

    public static Record build(ResultSet resultSet, CustomersRoutinesEntity customersRoutinesEntity, EmployeesEntity employeesEntity) {
        try {
            return new Record(  resultSet.getInt("id"),
                                resultSet.getDate("date"),
                                resultSet.getInt("duration"),
                                resultSet.getInt("progress"),
                                resultSet.getString("comment"),
                                customersRoutinesEntity.findById(resultSet.getInt("customer_routine_id")),
                                employeesEntity.findById(resultSet.getInt("employee_id")));
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CustomerRoutine getCustomerRoutine() {
        return customerRoutine;
    }

    public void setCustomerRoutine(CustomerRoutine customerRoutine) {
        this.customerRoutine = customerRoutine;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}



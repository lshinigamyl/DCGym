package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.EmployeeTypesEntity;
import pe.com.dcgym.models.DTO.PeopleEntity;
import pe.com.dcgym.models.DTO.TrainingCentersEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
public abstract class Guerrero {
    private String nombre;
    private int edad;
    
    private int fuerza;
    private boolean herido;

    private boolean muerto;

    public Guerrero(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
boolean comprobarEdad(int e){
boolean ed;
 if (e>=15 && e<=60){
 ed = true;
}
        return false;
}

boolean comprobarFuerza(int f){
boolean fu;
 if (f>=1 && f<=10){
 fu = true;
}
        return false;
}
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Guerrero(String nombre, int edad, int fuerza) {
        this.nombre = nombre;
        this.edad = edad;
        this.fuerza = fuerza;
    }
   

    public Guerrero() {
       this("Guerrero x",15,1);
    }

    public Guerrero(String nombre) {
        this.nombre = nombre;
    }

    public boolean retirarse(){
        
        return false;
    
    }

    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public boolean isHerido() {
        return herido;
    }

    public void setHerido(boolean herido) {
        this.herido = herido;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }
    
   


public class Employee {
    int id;
    String state;
    TrainingCenter trainingCenters;
    People people;
    EmployeeType employeeType;


    public Employee() {
    }

    public Employee(int id, String state, TrainingCenter trainingCenters, People people, EmployeeType employeeType) {
        this.id = id;
        this.state = state;
        this.trainingCenters = trainingCenters;
        this.people = people;
        this.employeeType = employeeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TrainingCenter getTrainingCenters() {
        return trainingCenters;
    }

    public void setTrainingCenters(TrainingCenter trainingCenters) {
        this.trainingCenters = trainingCenters;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public static Employee build(ResultSet resultSet, TrainingCentersEntity trainingCentersEntity, PeopleEntity peopleEntity, EmployeeTypesEntity employeeTypesEntity) {
        try {
            Employee employee= new Employee();
            return new Employee(resultSet.getInt("id"),resultSet.getString("state"),trainingCentersEntity.findById(resultSet.getInt("training_centers_id")), peopleEntity.findById(resultSet.getInt("people_id")), employeeTypesEntity.findById(resultSet.getInt("employee_types_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


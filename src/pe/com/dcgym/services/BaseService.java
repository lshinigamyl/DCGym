package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.CustomerRoutine;
import pe.com.dcgym.models.DAO.Employee;
import pe.com.dcgym.models.DTO.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public abstract class BaseService {
    private Connection connection;
    private CustomersEntity customersEntity;
    private CustomersMembershipsEntity customersMembershipsEntity;
    private CustomersRoutinesEntity customersRoutinesEntity;
    private EmployeesEntity employeesEntity;
    private EmployeeTypesEntity employeeTypesEntity;
    private ExercisesEntity exercisesEntity;
    private ExercisesRoutinesEntity exercisesRoutinesEntity;
    private MembershipsTypeEntity membershipsTypeEntity;
    private PeopleEntity peopleEntity;
    private RecordsEntity recordsEntity;
    private RoutinesEntity routinesEntity;
    private TrainingCentersEntity trainingCentersEntity;
    private TrainingCentersMembershipsEntity trainingCentersMembershipsEntity;


    public BaseService() {

    }

    private Connection getConnection() {
        if (connection == null) {
            try {
                InitialContext ctx = new InitialContext();
                connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource_dcgym")).getConnection();
            } catch (NamingException e) {
                System.out.println("Error  naming exception");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Error  SQLException");
                e.printStackTrace();
            }
        }
        return connection;
    }



    protected CustomersEntity getCustomersEntity() {
        if (customersEntity == null) {
            customersEntity = new CustomersEntity();
            customersEntity.setConnection(getConnection());
            customersEntity.setPeopleEntity(getPeopleEntity());
        }
        return customersEntity;
    }
    protected CustomersMembershipsEntity getCustomersMembershipsEntity() {
        if (customersMembershipsEntity == null) {
            customersMembershipsEntity = new CustomersMembershipsEntity();
            customersMembershipsEntity.setConnection(getConnection());
            customersMembershipsEntity.setCustomersEntity(getCustomersEntity());
            customersMembershipsEntity.setTrainingCentersMembershipsEntity(getTrainingCentersMembershipsEntity());
        }
        return customersMembershipsEntity;
    }
    protected CustomersRoutinesEntity getCustomersRoutinesEntity() {
        if(customersRoutinesEntity==null){
            customersRoutinesEntity= new CustomersRoutinesEntity();
            customersRoutinesEntity.setConnection(getConnection());
            customersRoutinesEntity.setCustomersEntity(getCustomersEntity());
            customersRoutinesEntity.setEmployeesEntity(getEmployeesEntity());
            customersRoutinesEntity.setRoutinesEntity(getRoutinesEntity());
        }
        return customersRoutinesEntity;
    }

    protected EmployeesEntity getEmployeesEntity() {
        if(employeesEntity==null){
            employeesEntity= new EmployeesEntity();
            employeesEntity.setConnection(getConnection());
            employeesEntity.setPeopleEntity(getPeopleEntity());
            employeesEntity.setEmployeeTypesEntity(getEmployeeTypesEntity());
            employeesEntity.setTrainingCentersEntity(getTrainingCentersEntity());
        }
        return employeesEntity;
    }

    protected EmployeeTypesEntity getEmployeeTypesEntity() {
        if (employeeTypesEntity==null){
            employeeTypesEntity = new EmployeeTypesEntity();
            employeeTypesEntity.setConnection(getConnection());
        }
        return employeeTypesEntity;
    }

    protected ExercisesEntity getExercisesEntity() {
        if (exercisesEntity== null){
            exercisesEntity = new ExercisesEntity();
            exercisesEntity.setConnection(getConnection());
        }
        return exercisesEntity;
    }

    protected ExercisesRoutinesEntity getExercisesRoutinesEntity() {
        if (exercisesRoutinesEntity==null){
            exercisesRoutinesEntity = new ExercisesRoutinesEntity();
            exercisesRoutinesEntity.setConnection(getConnection());
            exercisesRoutinesEntity.setExercisesEntity(getExercisesEntity());
            exercisesRoutinesEntity.setRoutinesEntity(getRoutinesEntity());
        }
        return exercisesRoutinesEntity;
    }

    protected RecordsEntity getRecordsEntity() {
        if (recordsEntity== null){
            recordsEntity = new RecordsEntity();
            recordsEntity.setConnection(getConnection());
            recordsEntity.setCustomersRoutinesEntity(getCustomersRoutinesEntity());
        }
        return recordsEntity;
    }

    protected RoutinesEntity getRoutinesEntity() {
        if(routinesEntity==null){
            routinesEntity = new RoutinesEntity();
            routinesEntity.setConnection(getConnection());
            routinesEntity.setPeopleEntity(getPeopleEntity());
        }
        return routinesEntity;
    }

    protected TrainingCentersMembershipsEntity getTrainingCentersMembershipsEntity() {
        if(trainingCentersMembershipsEntity==null){
            trainingCentersMembershipsEntity = new TrainingCentersMembershipsEntity();
            trainingCentersMembershipsEntity.setConnection(getConnection());
            trainingCentersMembershipsEntity.setTrainingCentersEntity(getTrainingCentersEntity());
            trainingCentersMembershipsEntity.setMembershipsTypeEntity(getMembershipsTypeEntity());
        }
        return trainingCentersMembershipsEntity;
    }
    protected PeopleEntity getPeopleEntity() {
        if (peopleEntity == null) {
            peopleEntity = new PeopleEntity();
            peopleEntity.setConnection(getConnection());
        }
        return peopleEntity;
    }

    protected MembershipsTypeEntity getMembershipsTypeEntity() {
        if (membershipsTypeEntity == null) {
            membershipsTypeEntity = new MembershipsTypeEntity();
            membershipsTypeEntity.setConnection(getConnection());
        }
        return membershipsTypeEntity;
    }

    protected TrainingCentersEntity getTrainingCentersEntity() {
        if (trainingCentersEntity == null) {
            trainingCentersEntity = new TrainingCentersEntity();
            trainingCentersEntity.setConnection(getConnection());
        }
        return trainingCentersEntity;
    }


    protected void setTrainingCentersEntity(TrainingCentersEntity trainingCentersEntity) {
        this.trainingCentersEntity = trainingCentersEntity;
    }

    protected void setCustomersRoutinesEntity(CustomersRoutinesEntity customersRoutinesEntity) {
        this.customersRoutinesEntity = customersRoutinesEntity;
    }

    protected void setEmployeesEntity(EmployeesEntity employeesEntity) {
        this.employeesEntity = employeesEntity;
    }

    protected void setEmployeeTypesEntity(EmployeeTypesEntity employeeTypesEntity) {
        this.employeeTypesEntity = employeeTypesEntity;
    }

    protected void setExercisesEntity(ExercisesEntity exercisesEntity) {
        this.exercisesEntity = exercisesEntity;
    }

    protected void setExercisesRoutinesEntity(ExercisesRoutinesEntity exercisesRoutinesEntity) {
        this.exercisesRoutinesEntity = exercisesRoutinesEntity;
    }

    protected void setRecordsEntity(RecordsEntity recordsEntity) {
        this.recordsEntity = recordsEntity;
    }

    protected void setRoutinesEntity(RoutinesEntity routinesEntity) {
        this.routinesEntity = routinesEntity;
    }

    protected void setTrainingCentersMembershipsEntity(TrainingCentersMembershipsEntity trainingCentersMembershipsEntity) {
        this.trainingCentersMembershipsEntity = trainingCentersMembershipsEntity;
    }

    protected void setMembershipsTypeEntity(MembershipsTypeEntity membershipsTypeEntity) {
        this.membershipsTypeEntity = membershipsTypeEntity;
    }

    protected void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    protected void setCustomersEntity(CustomersEntity customersEntity) {
        this.customersEntity = customersEntity;
    }

    protected void setCustomersMembershipsEntity(CustomersMembershipsEntity customersMembershipsEntity) {
        this.customersMembershipsEntity = customersMembershipsEntity;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }


}



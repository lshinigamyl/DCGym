package pe.com.dcgym.services;

import pe.com.dcgym.models.DTO.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public abstract class BaseService {
    private Connection connection;
    private CustomersEntity customersEntity;
    private CustomerGymMembershipTypesEntity customerGymMembershipTypesEntity;
    private CustomersRoutinesEntity customersRoutinesEntity;
    private EmployeesEntity employeesEntity;
    private EmployeeTypesEntity employeeTypesEntity;
    private ExercisesEntity exercisesEntity;
    private ExercisesRoutinesEntity exercisesRoutinesEntity;
    private MembershipsTypeEntity membershipsTypeEntity;
    private PeopleEntity peopleEntity;
    private RecordsEntity recordsEntity;
    private RoutinesEntity routinesEntity;
    private GymEntity gymEntity;
    private GymsMembershipTypesEntity gymsMembershipTypesEntity;


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
    protected CustomerGymMembershipTypesEntity getCustomerGymMembershipTypesEntity() {
        if (customerGymMembershipTypesEntity == null) {
            customerGymMembershipTypesEntity = new CustomerGymMembershipTypesEntity();
            customerGymMembershipTypesEntity.setConnection(getConnection());
            customerGymMembershipTypesEntity.setCustomersEntity(getCustomersEntity());
            customerGymMembershipTypesEntity.setGymsMembershipTypesEntity(getGymsMembershipTypesEntity());
        }
        return customerGymMembershipTypesEntity;
    }
    protected CustomersRoutinesEntity getCustomersRoutinesEntity() {
        if(customersRoutinesEntity==null){
            customersRoutinesEntity= new CustomersRoutinesEntity();
            customersRoutinesEntity.setConnection(getConnection());
            customersRoutinesEntity.setCustomersEntity(getCustomersEntity());
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
            employeesEntity.setGymEntity(getGymEntity());
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
            recordsEntity.setEmployeesEntity(getEmployeesEntity());
        }
        return recordsEntity;
    }

    protected RoutinesEntity getRoutinesEntity() {
        if(routinesEntity==null){
            routinesEntity = new RoutinesEntity();
            routinesEntity.setConnection(getConnection());
            routinesEntity.setGymEntity(getGymEntity());
        }
        return routinesEntity;
    }

    protected GymsMembershipTypesEntity getGymsMembershipTypesEntity() {
        if(gymsMembershipTypesEntity ==null){
            gymsMembershipTypesEntity = new GymsMembershipTypesEntity();
            gymsMembershipTypesEntity.setConnection(getConnection());
            gymsMembershipTypesEntity.setGymEntity(getGymEntity());
            gymsMembershipTypesEntity.setMembershipsTypeEntity(getMembershipsTypeEntity());
        }
        return gymsMembershipTypesEntity;
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

    protected GymEntity getGymEntity() {
        if (gymEntity == null) {
            gymEntity = new GymEntity();
            gymEntity.setConnection(getConnection());
        }
        return gymEntity;
    }


    protected void setGymEntity(GymEntity gymEntity) {
        this.gymEntity = gymEntity;
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

    protected void setGymsMembershipTypesEntity(GymsMembershipTypesEntity gymsMembershipTypesEntity) {
        this.gymsMembershipTypesEntity = gymsMembershipTypesEntity;
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

    protected void setCustomerGymMembershipTypesEntity(CustomerGymMembershipTypesEntity customerGymMembershipTypesEntity) {
        this.customerGymMembershipTypesEntity = customerGymMembershipTypesEntity;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }


}



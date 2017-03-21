package pe.com.dcgym.services;

import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.CustomersMembershipsEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;
import pe.com.dcgym.models.DTO.PeopleEntity;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public abstract class BaseService {
    private Connection connection;
    private CustomersMembershipsEntity customersMembershipsEntity;
    private CustomersEntity customersEntity;
    private PeopleEntity peopleEntity;
    private MembershipsTypeEntity membershipsTypeEntity;
    public BaseService() {

    }

    private Connection getConnection() {
        if(connection == null) {
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

    private void setConnection(Connection connection) {
        this.connection = connection;
    }
    protected CustomersEntity getCustomersEntity() {
        if (customersEntity == null){
            customersEntity = new CustomersEntity();
            customersEntity.setConnection(getConnection());
            customersEntity.setPeopleEntity(getPeopleEntity());
        }
        return customersEntity;
    }

    protected PeopleEntity getPeopleEntity() {
        if(peopleEntity==null){
            peopleEntity = new PeopleEntity();
            peopleEntity.setConnection(getConnection());
        }
        return peopleEntity;
    }

    protected MembershipsTypeEntity getMembershipsTypeEntity() {
        if(membershipsTypeEntity == null){
            membershipsTypeEntity= new MembershipsTypeEntity();
            membershipsTypeEntity.setConnection(getConnection());
        }
        return membershipsTypeEntity;
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

    protected CustomersMembershipsEntity getCustomersMembershipsEntity() {
        if(customersMembershipsEntity == null) {
            customersMembershipsEntity = new CustomersMembershipsEntity();
            customersMembershipsEntity.setConnection(getConnection());
            customersMembershipsEntity.setCustomersEntity(getCustomersEntity());
            customersMembershipsEntity.setMembershipsTypeEntity(getMembershipsTypeEntity());
        }
        return customersMembershipsEntity;
    }

    protected void setCustomersMembershipsEntity(CustomersMembershipsEntity customersMembershipsEntity) {
        this.customersMembershipsEntity = customersMembershipsEntity;
    }
}



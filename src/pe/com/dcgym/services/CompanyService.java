package pe.com.dcgym.services;


import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.CustomerMembership;
import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.CustomersMembershipsEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;
import pe.com.dcgym.models.DTO.PeopleEntity;

import java.util.List;

/**
 * Created by Fjorsvartnir on 20/03/2017.
 */
public class CompanyService extends BaseService {
    private CustomersMembershipsEntity customersMembershipsEntity;
    private CustomersEntity customersEntity;
    private PeopleEntity peopleEntity;
    private MembershipsTypeEntity membershipsTypeEntity;

    public List<CustomerMembership> findAllCustomerMembership(){
        return getCustomersMembershipsEntity().findAll();
    }
    public List<Customer> findAllCustomers(){
        return getCustomersEntity().findAll();
    }
    private CustomersEntity getCustomersEntity() {
        if (customersEntity == null){
            customersEntity = new CustomersEntity();
            customersEntity.setConnection(super.getConnection());
            customersEntity.setPeopleEntity(getPeopleEntity());
        }
        return customersEntity;
    }

    public PeopleEntity getPeopleEntity() {
        if(peopleEntity==null){
            peopleEntity = new PeopleEntity();
            peopleEntity.setConnection(super.getConnection());
        }
        return peopleEntity;
    }

    public MembershipsTypeEntity getMembershipsTypeEntity() {
        if(membershipsTypeEntity == null){
            membershipsTypeEntity= new MembershipsTypeEntity();
            membershipsTypeEntity.setConnection(super.getConnection());
        }
        return membershipsTypeEntity;
    }

    public void setMembershipsTypeEntity(MembershipsTypeEntity membershipsTypeEntity) {
        this.membershipsTypeEntity = membershipsTypeEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    private void setCustomersEntity(CustomersEntity customersEntity) {
        this.customersEntity = customersEntity;
    }

    private CustomersMembershipsEntity getCustomersMembershipsEntity() {
        if(customersMembershipsEntity == null) {
            customersMembershipsEntity = new CustomersMembershipsEntity();
            customersMembershipsEntity.setConnection(super.getConnection());
            customersMembershipsEntity.setCustomersEntity(getCustomersEntity());
            customersMembershipsEntity.setMembershipsTypeEntity(getMembershipsTypeEntity());
        }
        return customersMembershipsEntity;
    }

    private void setCustomersMembershipsEntity(CustomersMembershipsEntity customersMembershipsEntity) {
        this.customersMembershipsEntity = customersMembershipsEntity;
    }
}

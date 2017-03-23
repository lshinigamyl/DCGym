package pe.com.dcgym.services;


import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.CustomerMembership;
import pe.com.dcgym.models.DAO.Employee;
import pe.com.dcgym.models.DAO.MembershipType;
import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.CustomersMembershipsEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;
import pe.com.dcgym.models.DTO.PeopleEntity;

import java.util.List;

/**
 * Created by Fjorsvartnir on 20/03/2017.
 */
public class CompanyService extends BaseService {


    public List<CustomerMembership> findAllCustomerMembership(){
        return getCustomersMembershipsEntity().findAll();
    }

    public List<MembershipType> findAllMembershipsType(){
        return getMembershipsTypeEntity().findAll();
    }

    public List<Employee> findAllEmployee(){
        return getEmployeesEntity().findAll();
    }
    public List<CustomerMembership> findCustomerMembershipsByUserTrainingCenter(String user){
        return  getCustomersMembershipsEntity().findByTrainingCenterUser(user);
    }

}

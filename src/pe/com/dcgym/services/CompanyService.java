package pe.com.dcgym.services;


import pe.com.dcgym.models.DAO.*;
import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.CustomersMembershipsEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;
import pe.com.dcgym.models.DTO.PeopleEntity;

import java.util.List;


public class CompanyService extends BaseService {


    public List<CustomerMembership> findAllCustomerMembership(){
        return getCustomersMembershipsEntity().findAll();
    }

    public List<MembershipType> findAllMembershipsType(){
        return getMembershipsTypeEntity().findAll();
    }

    public List<Employee> findAllEmployee(String id){
        return getEmployeesEntity().findByTraininCenterID(id);
    }
    public List<CustomerMembership> findCustomerMembershipsByUserTrainingCenter(String user){
        return  getCustomersMembershipsEntity().findByTrainingCenterUser(user);
    }
    public List<TrainingCenterMembership> findTrainingCenterMembership(String id){
        return getTrainingCentersMembershipsEntity().findByTrainingCenter(id);
    }

}

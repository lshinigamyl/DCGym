package pe.com.dcgym.services;


import pe.com.dcgym.models.DAO.*;

import java.util.List;


public class Company00Service extends BaseService {


    public List<CustomerGymMembershipType> findAllCustomerMembership(){
        return getCustomerGymMembershipTypesEntity().findAll();
    }

    public List<MembershipType> findAllMembershipsType(){
        return getMembershipsTypeEntity().findAll();
    }

    public List<Employee> findAllEmployee(String id){
        return getEmployeesEntity().findByTraininCenterID(id);
    }
    public List<CustomerGymMembershipType> findCustomerMembershipsByTrainingCenterId(int id){
        return  getCustomerGymMembershipTypesEntity().findByTrainingCenterUser(id);
    }
    public List<GymMembershipTypes> findTrainingCenterMembership(String id){
        return getGymsMembershipTypesEntity().findByTrainingCenter(id);
    }
    public List<EmployeeType>findAllEmployeeTypes(){
        return getEmployeeTypesEntity().findAll();
    }
    public List<ExerciseRoutine> findAllRoutines(){ return getExercisesRoutinesEntity().findAll();

    }





}

package pe.com.dcgym.services;


import pe.com.dcgym.models.DAO.*;

import java.util.List;


public class CompanyService extends BaseService {


    public List<CustomerGymMembershipType> findAllCustomerMembership(){
        return getCustomerGymMembershipTypesEntity().findAll();
    }

    public List<MembershipType> findAllMembershipsType(){
        return getMembershipsTypeEntity().findAll();
    }

    public List<Employee> findAllEmployee(String id){
        return getEmployeesEntity().findByTraininCenterID(id);
    }
    public List<CustomerGymMembershipType> findCustomerMembershipsByUserTrainingCenter(String user){
        return  getCustomerGymMembershipTypesEntity().findByTrainingCenterUser(user);
    }
    public List<GymMembershipTypes> findTrainingCenterMembership(String id){
        return getGymsMembershipTypesEntity().findByTrainingCenter(id);
    }
    public List<EmployeeType>findAllEmployeeTypes(){
        return getEmployeeTypesEntity().findAll();
    }
    public List<ExerciseRoutine> findAllRoutines(){ return getExercisesRoutinesEntity().findAll();

    }
    public GymMembershipTypes create(GymMembershipTypes gymMembershipTypes){
        return getGymsMembershipTypesEntity().create(gymMembershipTypes);
    }
    public boolean delete(int id){
        return getGymsMembershipTypesEntity().delete(id);
    }
    public boolean edit(GymMembershipTypes gymMembershipTypes){
        return getGymsMembershipTypesEntity().getMembershipsTypeEntity().update(gymMembershipTypes.getMembershipType());
    }

}

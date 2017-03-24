package pe.com.dcgym.services;


import pe.com.dcgym.models.DAO.*;
import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.CustomersMembershipsEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;
import pe.com.dcgym.models.DTO.PeopleEntity;

import java.util.List;

/**
 import java.util.*;
 public class MetodoVoid {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 String cadena;
 System.out.print("Introduce cadena de texto: ");
 cadena = sc.nextLine();
 cajaTexto(cadena); //llamada al método
 }

 public static void cajaTexto(String str){
 int n = str.length();
 for (int i = 0; i < n + 4; i++){
 System.out.print("#");
 }
 System.out.println();
 System.out.println("# " + str + " #");
 for (int i = 0; i < n + 4; i++){
 System.out.print("#");
 }
 System.out.println();
 }
 }
 */
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

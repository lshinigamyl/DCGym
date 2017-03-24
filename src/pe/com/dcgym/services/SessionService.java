package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.People;
import pe.com.dcgym.models.DTO.PeopleEntity;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.DTO.TrainingCentersEntity;

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
public class SessionService extends BaseService {

    /*
    * Distingue el inicio de session entre gymnasio y persona  con consulta sql ., deberian haber solo dos emtodos
    * */
    public People findPeopleByUser(String userName){
        return getPeopleEntity().findByUser(userName);
    }
    public TrainingCenter findTrainingByUser(String userName){
        return getTrainingCentersEntity().findByUser(userName);
    }
    public Customer findByCustomerUser(String userName){
        return getCustomersEntity().findByCustomerUser(userName);
    }
}

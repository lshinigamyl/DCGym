package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.DTO.TrainingCentersEntity;

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
public class TrainingCenterServices extends BaseService {

    public List<TrainingCenter> findAllTrainingCenters(){
        return getTrainingCentersEntity().findAll();
    }
}

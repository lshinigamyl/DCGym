package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.services.TrainingCenterServices;



import java.util.List;
import java.util.Map;

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
public class ShowAction extends ActionSupport {
    private List<TrainingCenter> trainingCenters;
    private TrainingCenterServices service;
    private Map<String,Object> session;

    @Override
    public String execute() throws Exception {

        service= new TrainingCenterServices();
        setTrainingCenters(service.findAllTrainingCenters());
        return super.execute();
    }

    public List<TrainingCenter> getTrainingCenters() {
        return trainingCenters;
    }

    public void setTrainingCenters(List<TrainingCenter> trainingCenters) {
        this.trainingCenters = trainingCenters;
    }
}

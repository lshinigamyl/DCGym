package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

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
public class ClientAction extends ActionSupport implements SessionAware {

    private Map<String,Object> session;
    private String menuOption="";


    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public String execute() throws Exception {

        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "client":
                setMenuOption("index");

                return SUCCESS;
            case "company":
                return ERROR;
            default:
                return ERROR;
        }
    }



    public String ejercicio() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "client":
                setMenuOption("ejercicio");

                return SUCCESS;
            case "company":
                return ERROR;
            default:
                return ERROR;
        }
    }


    public String historial() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "client":

                setMenuOption("historial");
                return SUCCESS;
            case "company":
                return ERROR;
            default:
                return ERROR;
        }
    }
    public String suscripcion() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "client":
                setMenuOption("suscripcion");

                return SUCCESS;
            case "company":
                return ERROR;
            default:
                return ERROR;
        }

    }

    public String getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(String menuOption) {
        this.menuOption = menuOption;
    }
}

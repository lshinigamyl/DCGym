package pe.com.dcgym.actions;

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
public class SearchAction {
    public String execute(){
        return "success";
    }
}

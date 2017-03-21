package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Fjorsvartnir on 19/03/2017.
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

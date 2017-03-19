package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Fjorsvartnir on 19/03/2017.
 */
public class ClientAction extends ActionSupport implements SessionAware {

    private Map<String,Object> session;


    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public String execute() throws Exception {
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "enterprise":
                return ERROR;
            case "client":
                return SUCCESS;
            default:
                return ERROR;
        }
    }
}

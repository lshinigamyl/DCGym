package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.CustomerGymMembershipType;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.services.Company02ClientsService;

import java.util.Map;

/**
 * Created by Fjorsvartnir on 25/03/2017.
 */
public class Company01GraphictAction extends ActionSupport implements ModelDriven,SessionAware {


    @Override
    public Object getModel() {
        return null;
    }

    @Override
    public void setSession(Map<String, Object> map) {

    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}

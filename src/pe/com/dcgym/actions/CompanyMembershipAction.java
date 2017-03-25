package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.models.DAO.GymMembershipTypes;
import pe.com.dcgym.services.CompanyService;

import java.util.Map;

/**
 * Created by Fjorsvartnir on 25/03/2017.
 */
public class CompanyMembershipAction extends ActionSupport implements ModelDriven,SessionAware {
    private GymMembershipTypes gymMembershipTypes = new GymMembershipTypes();
    private Map<String,Object> session;
    @Override
    public Object getModel() {
        return gymMembershipTypes;
    }

    @Override
    public String execute() throws Exception {
        CompanyService service = new CompanyService();
        Gym obj = (Gym)getSession().get("objsession");
        gymMembershipTypes.setGym(obj);
        service.create(gymMembershipTypes);
        return SUCCESS;
    }
    public String delete()throws Exception{
        CompanyService service= new CompanyService();
        service.delete(getGymMembershipTypes().getId());
        return SUCCESS;
    }
    public String edit()throws Exception{
        CompanyService service= new CompanyService();
        service.edit(getGymMembershipTypes());
        return SUCCESS;
    }
    public void setGymMembershipTypes(GymMembershipTypes gymMembershipTypes) {
        this.gymMembershipTypes = gymMembershipTypes;
    }

    public GymMembershipTypes getGymMembershipTypes() {
        return gymMembershipTypes;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    public Map<String, Object> getSession() {
        return session;
    }
}

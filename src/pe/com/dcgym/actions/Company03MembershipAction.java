package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.models.DAO.GymMembershipTypes;
import pe.com.dcgym.services.Company03MembershipTypesService;

import java.util.Map;

/**
 * Created by Fjorsvartnir on 25/03/2017.
 */
public class Company03MembershipAction extends ActionSupport implements ModelDriven,SessionAware {
    private GymMembershipTypes gymMembershipTypes = new GymMembershipTypes();
    private Map<String,Object> session;

    private Company03MembershipTypesService service;

    public String create() throws Exception {

        Gym obj = (Gym)getSession().get("objsession");
        gymMembershipTypes.setGym(obj);
        getService().create(gymMembershipTypes);
        return SUCCESS;
    }
    public String delete()throws Exception{

//      Gym obj = (Gym)getSession().get("objsession");
        getService().delete(getGymMembershipTypes().getId());
        return SUCCESS;
    }
    public String edit()throws Exception{

        getService().edit(getGymMembershipTypes());
        return SUCCESS;
    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public Object getModel() {
        return gymMembershipTypes;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setGymMembershipTypes(GymMembershipTypes gymMembershipTypes) {
        this.gymMembershipTypes = gymMembershipTypes;
    }

    public GymMembershipTypes getGymMembershipTypes() {
        return gymMembershipTypes;
    }

    public Company03MembershipTypesService getService() {
        if(service==null){
            service = new Company03MembershipTypesService();
        }
        return service;
    }

    public void setService(Company03MembershipTypesService service) {
        this.service = service;
    }
}

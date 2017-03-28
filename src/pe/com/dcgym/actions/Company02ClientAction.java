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
public class Company02ClientAction extends ActionSupport implements ModelDriven<CustomerGymMembershipType>,SessionAware {

    private CustomerGymMembershipType customerGymMembershipType = new CustomerGymMembershipType();
    private Map<String,Object> session;
    private Company02ClientsService service;



    public String create() throws Exception {

        Gym obj = (Gym)getSession().get("objsession");
        customerGymMembershipType.getGymMembershipTypes().setGym(obj);

        getService().create(customerGymMembershipType);
        return SUCCESS;
    }

    public String delete()throws Exception{

//      Gym obj = (Gym)getSession().get("objsession");
        return (getService().delete(getCustomerGymMembershipType())) ? SUCCESS :ERROR ;
    }

    public String edit()throws Exception{

//      Gym obj = (Gym)getSession().get("objsession");
        return (getService().edit(getCustomerGymMembershipType())) ? SUCCESS :ERROR ;
    }



    public void setCustomerGymMembershipType(CustomerGymMembershipType customerGymMembershipType) {
        this.customerGymMembershipType = customerGymMembershipType;
    }

    @Override
    public CustomerGymMembershipType getModel() {
        return customerGymMembershipType;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    public CustomerGymMembershipType getCustomerGymMembershipType() {
        return customerGymMembershipType;
    }







    public Map<String, Object> getSession() {
        return session;
    }

    public Company02ClientsService getService() {
        if(service==null){
            service=new Company02ClientsService();
        }
        return service;
    }



}

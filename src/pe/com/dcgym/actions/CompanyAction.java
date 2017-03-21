package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.CustomerMembership;
import pe.com.dcgym.services.CompanyService;

import java.util.List;
import java.util.Map;

/**
 * Created by Fjorsvartnir on 19/03/2017.
 */
public class CompanyAction extends ActionSupport implements SessionAware {
    private Map<String,Object> session;
    private String menuOption="";
    private List<CustomerMembership> customerMemberships;
    private List<Customer> customers;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public String execute() throws Exception {
        menuOption="index";
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }

    public String usuarios() throws Exception{
        menuOption="usuario";
        CompanyService service = new CompanyService();
        setCustomerMemberships(service.findAllCustomerMembership());
        return SUCCESS;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public String membresia() throws Exception{
        menuOption="membresia";
        return SUCCESS;
    }
    public String entrenadores() throws Exception{
        menuOption="entrenador";
        return SUCCESS;
    }

    public List<CustomerMembership> getCustomerMemberships() {
        return customerMemberships;
    }

    public void setCustomerMemberships(List<CustomerMembership> customerMemberships) {
        this.customerMemberships = customerMemberships;
    }

}

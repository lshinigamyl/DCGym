package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.*;
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
    private List<MembershipType> membershipTypes;
    private List<Employee> employees;
    private List<TrainingCenterMembership> trainingCenterMemberships;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public String execute() throws Exception {
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                setMenuOption("index");
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }



    public String usuarios() throws Exception{
        String typeSession = session.get("typeSession").toString() ==null ? "" :(String) session.get("typeSession").toString();
        switch (typeSession){
            case "company":
                setMenuOption("usuario");
                CompanyService service = new CompanyService();
                setCustomerMemberships(service.findCustomerMembershipsByUserTrainingCenter((String)getSession().get("user")));
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }


    public String membresia() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                TrainingCenter obj = (TrainingCenter)getSession().get("objsession");
                CompanyService service = new CompanyService();
                setTrainingCenterMemberships(service.findTrainingCenterMembership(String.valueOf(obj.getId())));
                setMenuOption("membresia");
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }
    public String entrenadores() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                setMenuOption("entrenador");
                CompanyService service = new CompanyService();
                setEmployees(service.findAllEmployee());
                return SUCCESS;
            case "client":
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
    public List<CustomerMembership> getCustomerMemberships() {
        return customerMemberships;
    }

    public void setCustomerMemberships(List<CustomerMembership> customerMemberships) {
        this.customerMemberships = customerMemberships;
    }

    public List<MembershipType> getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(List<MembershipType> membershipTypes) {
        this.membershipTypes = membershipTypes;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public List<TrainingCenterMembership> getTrainingCenterMemberships() {
        return trainingCenterMemberships;
    }

    public void setTrainingCenterMemberships(List<TrainingCenterMembership> trainingCenterMemberships) {
        this.trainingCenterMemberships = trainingCenterMemberships;
    }
}

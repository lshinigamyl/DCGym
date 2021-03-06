package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.models.DAO.People;
import pe.com.dcgym.services.SessionService;

import java.util.List;
import java.util.Map;


public class LoginAction extends ActionSupport implements SessionAware {
    private String userName="";
    private String password="";
    private String url;
    private List<People> peoples;
    private List<Customer> customers;
    private List<Gym> Gyms;
    private Map<String,Object> session;


    @Override
    public String execute() throws Exception {

        session.put("user",null);
        SessionService service= new SessionService();
        if (service.findByCustomerUser(getUserName())!=null){
            session.put("user",getUserName());
            session.put("typeSession","client");
            setUrl("client.action");
            return "success";
        }else {
            if (service.findTrainingByUser(getUserName())!=null){
                session.put("user",getUserName());

                session.put("objsession",service.findTrainingByUser(getUserName()));
                session.put("typeSession","company");
                setUrl("company.action");
                return "success";
            }
            else {
                if (getUserName().equals("") && getPassword().equals("")){
                    return INPUT;
                }
                else {
                    return ERROR;
                }
            }
        }
    }


    @Override
    public void validate() {
        if (getUserName().equals("") | getUserName().equals(null)){

        }else {
        SessionService service= new SessionService();
        if (service.findByCustomerUser(getUserName())!=null){
        }else {
            if (service.findTrainingByUser(getUserName())!=null){
            }
            else {
                addActionError("Usuario o Contraseña incorrecta !");
            }
        }
        }
    }

    public String logout() throws Exception{
        Map session = ActionContext.getContext().getSession();
        session.remove("logeed-in");
        return SUCCESS;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    public String getUrl() {
        return url;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

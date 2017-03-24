package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.People;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.services.SessionService;

import java.util.List;
import java.util.Map;


public class LoginAction extends ActionSupport implements SessionAware {
    private String userName="";
    private String password="";
    private String url;
    private List<People> peoples;
    private List<Customer> customers;
    private List<TrainingCenter> trainingCenters;
    private Map<String,Object> session;
//    @Override
//    public String execute() throws Exception {
//        BaseService service = new BaseService();
//        if(service.validateUser(getUserName(),getPassword())){
//            Map session = ActionContext.getContext().getSession();
//            session.put("logged-in","true");
//            return SUCCESS;
//        }else {
//            return ERROR;
//        }
//    }


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
        if (service.findPeopleByUser(getUserName())!=null){
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

    public void setUrl(String url) {
        this.url = url;
    }
//    public String execute() {
//        return "error";
//    }


//    public String validate() {
//        BaseService service = new BaseService();
//        if (service.validateUser(getUserName(), getPassword())) {
//            if(getUserName()=="user3"){
//                return "clientconnect";
//            }else {
//                return "bussinessconnect";
//            }
//        } else {
//            return "error";
//
//        }
//    }
}

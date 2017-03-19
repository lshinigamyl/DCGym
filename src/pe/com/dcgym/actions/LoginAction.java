package pe.com.dcgym.actions;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import pe.com.dcgym.services.BaseService;

import java.util.Map;

/**
 * Created by GrupoUTP on 10/03/2017.
 */
public class LoginAction extends ActionSupport {
    private String userName;
    private String password;

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

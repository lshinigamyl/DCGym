package pe.com.dcgym.actions;


import pe.com.dcgym.services.HrService;

/**
 * Created by GrupoUTP on 10/03/2017.
 */
public class LoginAction {
    private String userName;
    private String password;

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

    public String execute() {
        return "error";
    }

    public String validate() {
        HrService service = new HrService();
        if (service.validateUser(getUserName(), getPassword())) {
            if(getUserName()=="user3"){
                return "clientconnect";
            }else {
                return "bussinessconnect";
            }
        } else {
            return "error";

        }
    }
}

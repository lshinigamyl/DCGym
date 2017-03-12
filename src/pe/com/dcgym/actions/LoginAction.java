package pe.com.dcgym.actions;


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
        return "success";
    }
}

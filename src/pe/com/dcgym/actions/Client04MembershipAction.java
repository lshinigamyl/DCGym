package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class Client04MembershipAction extends ActionSupport implements SessionAware {


    @Override
    public void setSession(Map<String, Object> map) {

    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}

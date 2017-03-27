package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class Client01GraphicAction extends ActionSupport implements SessionAware {

    private Map<String,Object> session;


    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

}

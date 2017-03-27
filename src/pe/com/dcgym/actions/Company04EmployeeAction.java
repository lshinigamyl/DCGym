package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.Employee;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.services.Company04EmployeesService;

import java.util.Map;

/**
 * Created by Fjorsvartnir on 25/03/2017.
 */
public class Company04EmployeeAction extends ActionSupport implements ModelDriven,SessionAware {
    private Employee employee = new Employee();
    private Map<String,Object> session;

    private Company04EmployeesService service;

    public String create() throws Exception {

        Gym obj = (Gym)getSession().get("objsession");
        getEmployee().setGym(obj);

        return (getService().create(getEmployee())!=null) ? SUCCESS : ERROR;
    }
    public String delete()throws Exception{

//      Gym obj = (Gym)getSession().get("objsession");
        return getService().delete(getEmployee()) ? SUCCESS : ERROR;
    }
    public String edit()throws Exception{

//      Gym obj = (Gym)getSession().get("objsession");
        return getService().edit(getEmployee()) ? SUCCESS : ERROR;
    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public Object getModel() {
        return employee;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company04EmployeesService getService() {
        if(service==null){
            service = new Company04EmployeesService();
        }
        return service;
    }

    public void setService(Company04EmployeesService service) {
        this.service = service;
    }
}

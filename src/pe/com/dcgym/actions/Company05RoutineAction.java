package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.Employee;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.models.DAO.Routine;
import pe.com.dcgym.services.Company04EmployeesService;
import pe.com.dcgym.services.Company05RoutinesService;

import java.util.Map;

/**
 * Created by Fjorsvartnir on 25/03/2017.
 */
public class Company05RoutineAction extends ActionSupport implements ModelDriven,SessionAware {
    private Routine routine = new Routine();
    private Map<String,Object> session;

    private Company05RoutinesService service;

    public String create() throws Exception {

        Gym obj = (Gym)getSession().get("objsession");
        getRoutine().setGym(obj);

        return (getService().create(getRoutine())!=null) ? SUCCESS : ERROR;
    }
    public String delete()throws Exception{

//      Gym obj = (Gym)getSession().get("objsession");
        return getService().delete(getRoutine()) ? SUCCESS : ERROR;
    }
    public String edit()throws Exception{

//      Gym obj = (Gym)getSession().get("objsession");
        return getService().edit(getRoutine()) ? SUCCESS : ERROR;
    }


    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public Object getModel() {
        return routine;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Company05RoutinesService getService() {

        return (service==null) ? service = new Company05RoutinesService() : service;
    }

    public void setService(Company05RoutinesService service) {
        this.service = service;
    }
}

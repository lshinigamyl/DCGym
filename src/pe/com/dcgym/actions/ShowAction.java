package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.services.TrainingCenterServices;

import java.util.List;
import java.util.Map;


public class ShowAction extends ActionSupport {
    private List<Gym> Gyms;
    private TrainingCenterServices service;
    private Map<String,Object> session;

    @Override
    public String execute() throws Exception {

        service= new TrainingCenterServices();
        setGyms(service.findAllTrainingCenters());
        return super.execute();
    }

    public List<Gym> getGyms() {
        return Gyms;
    }

    public void setGyms(List<Gym> Gyms) {
        this.Gyms = Gyms;
    }
}

package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.com.dcgym.models.DAO.Gym;
import pe.com.dcgym.services.TrainingCenterServices;

import java.util.List;
import java.util.Map;


public class ShowAction extends ActionSupport {
    private List<Gym> gyms;
    TrainingCenterServices service;

    @Override
    public String execute() throws Exception {

        TrainingCenterServices service = new TrainingCenterServices();
        setGyms(service.findAllTrainingCenters());
        return super.execute();
    }

    public List<Gym> getGyms() {
        return gyms;
    }

    public void setGyms(List<Gym> gyms) {
        this.gyms = gyms;
    }
}

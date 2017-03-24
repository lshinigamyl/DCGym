package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.services.TrainingCenterServices;



import java.util.List;
import java.util.Map;


public class ShowAction extends ActionSupport {
    private List<TrainingCenter> trainingCenters;
    private TrainingCenterServices service;
    private Map<String,Object> session;

    @Override
    public String execute() throws Exception {

        service= new TrainingCenterServices();
        setTrainingCenters(service.findAllTrainingCenters());
        return super.execute();
    }

    public List<TrainingCenter> getTrainingCenters() {
        return trainingCenters;
    }

    public void setTrainingCenters(List<TrainingCenter> trainingCenters) {
        this.trainingCenters = trainingCenters;
    }
}

package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.TrainingCentersEntity;

import java.util.List;

/**
 * Created by Fjorsvartnir on 18/03/2017.
 */
public class TrainingCenterServices extends BaseService {

    TrainingCentersEntity trainingCentersEntity;

    public TrainingCentersEntity getTrainingCentersEntity() {
        if(trainingCentersEntity == null) {
            trainingCentersEntity = new TrainingCentersEntity();
            trainingCentersEntity.setConnection(super.getConnection());
        }
        return trainingCentersEntity;
    }

    public void setTrainingCentersEntity(TrainingCentersEntity trainingCentersEntity) {
        this.trainingCentersEntity = trainingCentersEntity;
    }
    public List<TrainingCenter> findAllTrainingCenters(){
        return getTrainingCentersEntity().findAll();
    }
}

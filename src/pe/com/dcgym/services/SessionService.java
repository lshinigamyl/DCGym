package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.People;
import pe.com.dcgym.models.PeopleEntity;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.TrainingCentersEntity;

/**
 * Created by Fjorsvartnir on 18/03/2017.
 */
public class SessionService extends BaseService {
    private PeopleEntity peopleEntity;
    private TrainingCentersEntity trainingCentersEntity;

    public People findPeopleByUser(String userName){
        return getPeopleEntity().findByUser(userName);
    }
    public TrainingCenter findTrainingByUser(String userName){
        return getTrainingCentersEntity().findByUser(userName);
    }
    private TrainingCentersEntity getTrainingCentersEntity() {
        if(trainingCentersEntity == null) {
            trainingCentersEntity = new TrainingCentersEntity();
            trainingCentersEntity.setConnection(super.getConnection());
        }
        return trainingCentersEntity;
    }

    private void setTrainingCentersEntity(TrainingCentersEntity trainingCentersEntity) {
        this.trainingCentersEntity = trainingCentersEntity;
    }

    private PeopleEntity getPeopleEntity() {
        if(peopleEntity == null) {
            peopleEntity = new PeopleEntity();
            peopleEntity.setConnection(super.getConnection());
        }
        return peopleEntity;
    }

    private void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

}

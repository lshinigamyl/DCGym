package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.Gym;

import java.util.List;


public class TrainingCenterServices extends BaseService {

    public List<Gym> findAllTrainingCenters(){
        return getGymEntity().findAll();
    }
}

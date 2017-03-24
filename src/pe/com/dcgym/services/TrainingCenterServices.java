package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.DTO.TrainingCentersEntity;

import java.util.List;


public class TrainingCenterServices extends BaseService {

    public List<TrainingCenter> findAllTrainingCenters(){
        return getTrainingCentersEntity().findAll();
    }
}

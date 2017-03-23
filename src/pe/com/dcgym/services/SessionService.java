package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.People;
import pe.com.dcgym.models.DTO.PeopleEntity;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.DTO.TrainingCentersEntity;

/**
 * Created by Fjorsvartnir on 18/03/2017.
 */
public class SessionService extends BaseService {

    /*
    * Distingue el inicio de session entre gymnasio y persona  con consulta sql ., deberian haber solo dos emtodos
    * */
    public People findPeopleByUser(String userName){
        return getPeopleEntity().findByUser(userName);
    }
    public TrainingCenter findTrainingByUser(String userName){
        return getTrainingCentersEntity().findByUser(userName);
    }
    public Customer findByCustomerUser(String userName){
        return getCustomersEntity().findByCustomerUser(userName);
    }
}

package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.Gym;


public class SessionService extends BaseService {

    /*
    * Distingue el inicio de session entre gymnasio y persona  con consulta sql ., deberian haber solo dos emtodos
    * */

    public Gym findTrainingByUser(String userName){

        return getGymEntity().findByUser(userName);
    }

    public Customer findByCustomerUser(String userName){

        return getCustomersEntity().findByCustomerUserName(userName);
    }
}

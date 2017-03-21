package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.People;

import java.util.List;

/**
 * Created by Fjorsvartnir on 21/03/2017.
 */
public class ClientService extends BaseService {

    public People findPeopleById(String user){
        return getPeopleEntity().findByUser(user);
    }
}

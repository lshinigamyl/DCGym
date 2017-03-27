package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.People;

public class Client00Service extends BaseService {

    public People findPeopleById(String user){
        return getPeopleEntity().findByUser(user);
    }

}

package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.Employee;
import pe.com.dcgym.models.DAO.Routine;

/**
 * Created by Fjorsvartnir on 26/03/2017.
 */
public class Company05RoutinesService extends BaseService{

    public Routine create(Routine routine){
        return getRoutinesEntity().
                    create(routine);
    }

    public boolean edit(Routine routine){
        return  getRoutinesEntity().
                    update(routine);
    }

    public boolean delete(Routine routine) {
        return getRoutinesEntity().
                    delete(routine.getId());
    }
}

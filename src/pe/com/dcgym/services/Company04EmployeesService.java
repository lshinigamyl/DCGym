package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.Employee;

/**
 * Created by Fjorsvartnir on 26/03/2017.
 */
public class Company04EmployeesService extends BaseService{

    public Employee create(Employee employee){
        return getEmployeesEntity().
                    create(employee);
    }

    public boolean edit(Employee employee){
        return  getEmployeesEntity().getPeopleEntity().
                        update(employee.getPeople());
    }

    public boolean delete(Employee employee) {
        return getGymsMembershipTypesEntity().
                    delete(employee.getId());
    }
}

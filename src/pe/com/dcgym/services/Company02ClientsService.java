package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.CustomerGymMembershipType;
import pe.com.dcgym.models.DAO.GymMembershipTypes;

/**
 * Created by Fjorsvartnir on 26/03/2017.
 */
public class Company02ClientsService extends BaseService {

    public CustomerGymMembershipType create(CustomerGymMembershipType customerGymMembershipType){
        return getCustomerGymMembershipTypesEntity().
                        create(customerGymMembershipType);
    }
    public boolean edit(CustomerGymMembershipType customerGymMembershipType){
        return getCustomerGymMembershipTypesEntity().
                        update(customerGymMembershipType);
    }
    public boolean delete(CustomerGymMembershipType customerGymMembershipType){
        return getCustomerGymMembershipTypesEntity().
                        delete(customerGymMembershipType.getId());
    }

}

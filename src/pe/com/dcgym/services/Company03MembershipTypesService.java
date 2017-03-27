package pe.com.dcgym.services;

import pe.com.dcgym.models.DAO.GymMembershipTypes;

/**
 * Created by Fjorsvartnir on 26/03/2017.
 */
public class Company03MembershipTypesService extends BaseService{

    public GymMembershipTypes create(GymMembershipTypes gymMembershipTypes){
        return getGymsMembershipTypesEntity().
                    create(gymMembershipTypes);
    }

    public boolean edit(GymMembershipTypes gymMembershipTypes){
        return getGymsMembershipTypesEntity().getMembershipsTypeEntity().
                    update(gymMembershipTypes.getMembershipType());
    }

    public boolean delete(int id) {
        return getGymsMembershipTypesEntity().
                    delete(id);
    }
}

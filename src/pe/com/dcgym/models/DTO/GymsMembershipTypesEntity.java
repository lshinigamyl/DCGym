package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.GymMembershipTypes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class GymsMembershipTypesEntity extends BaseEntity {
    private static String TABLE="gyms_membership_types";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private GymEntity gymEntity;
    private MembershipsTypeEntity membershipsTypeEntity;

    public List<GymMembershipTypes> findAll() {
        return this.findByCriteria(DEFAULT_SQL+" WHERE state='H'" );
    }

    public GymMembershipTypes findById(int id) {
        List<GymMembershipTypes> gymMembershipTypes = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return gymMembershipTypes.isEmpty() ? null : gymMembershipTypes.get(0);
    }

    public List<GymMembershipTypes> findByTrainingCenter(String id){
        return this.findByCriteria("SELECT " +
                "g.id, " +
                "g.state," +
                "g.membership_type_id, " +
                "g.gym_id " +
                "FROM " +
                "gyms_membership_types AS g " +
                "WHERE " +
                "g.gym_id ='"+id+"' and g.state='H';");
    }

    public GymMembershipTypes findByName(String name) {
        List<GymMembershipTypes> gymMembershipTypes = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return gymMembershipTypes.isEmpty() ? null : gymMembershipTypes.get(0);
    }

    private List<GymMembershipTypes> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<GymMembershipTypes> gymMembershipTypesList = new ArrayList<GymMembershipTypes>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    GymMembershipTypes gymMembershipTypes = GymMembershipTypes.build(resultSet,getMembershipsTypeEntity(),getGymEntity());
                    gymMembershipTypesList.add(gymMembershipTypes);
                }
                return gymMembershipTypesList;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public GymMembershipTypes create(GymMembershipTypes gymMembershipTypes) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        gymMembershipTypes.setMembershipType(getMembershipsTypeEntity().create(gymMembershipTypes.getMembershipType()));
        String sql = "INSERT INTO gyms_membership_types ( membership_type_id , gym_id ) VALUES ( ? , ? );";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt(1, gymMembershipTypes.getMembershipType().getId());
            obj.setInt(2, gymMembershipTypes.getGym().getId());

            int results = obj.executeUpdate();
            if (results > 0) {
                gymMembershipTypes.setId(super.getMaxId(TABLE));
                return gymMembershipTypes;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private int updateByCriteria(String sql) {
        if (this.getConnection() != null) {
            try {
                return this.getConnection().createStatement().executeUpdate(sql);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return this.updateByCriteria("UPDATE `gyms_membership_types` SET `state`='N' WHERE (`id`='"+String.valueOf(id)+"')") > 0;
    }

    public boolean update(GymMembershipTypes gymMembershipTypes) {
        return this.updateByCriteria("UPDATE `gyms_membership_types` SET `membership_type_id`='"+gymMembershipTypes.getMembershipType().getId()+"', `gym_id`='"+gymMembershipTypes.getGym().getId()+"' WHERE (`id`='"+gymMembershipTypes.getId()+"');") > 0;
    }

    public GymEntity getGymEntity() {
        return gymEntity;
    }

    public void setGymEntity(GymEntity gymEntity) {
        this.gymEntity = gymEntity;
    }

    public MembershipsTypeEntity getMembershipsTypeEntity() {
        return membershipsTypeEntity;
    }

    public void setMembershipsTypeEntity(MembershipsTypeEntity membershipsTypeEntity) {
        this.membershipsTypeEntity = membershipsTypeEntity;
    }
}

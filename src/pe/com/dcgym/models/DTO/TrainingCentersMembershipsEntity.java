package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.MembershipType;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.DAO.TrainingCenterMembership;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class TrainingCentersMembershipsEntity extends BaseEntity{
    private static String TABLE="training_center_memberships";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private TrainingCentersEntity trainingCentersEntity;
    private MembershipsTypeEntity membershipsTypeEntity;

    public List<TrainingCenterMembership> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public TrainingCenterMembership findById(int id) {
        List<TrainingCenterMembership> trainingCenterMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return trainingCenterMemberships.isEmpty() ? null : trainingCenterMemberships.get(0);
    }

    public TrainingCenterMembership findByName(String name) {
        List<TrainingCenterMembership> trainingCenterMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return trainingCenterMemberships.isEmpty() ? null : trainingCenterMemberships.get(0);
    }

    private List<TrainingCenterMembership> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<TrainingCenterMembership> routines = new ArrayList<TrainingCenterMembership>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    TrainingCenterMembership routine = TrainingCenterMembership.build(resultSet,getTrainingCentersEntity(),getMembershipsTypeEntity());
                    routines.add(routine);
                }
                return routines;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public TrainingCenterMembership create(String state, TrainingCenter trainingCenter, MembershipType membershipType) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+" (id, state, training_centers_id, membership_types_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, state);
            obj.setInt   (3, trainingCenter.getId());
            obj.setInt   (4, membershipType.getId());

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                TrainingCenterMembership trainingCenterMembership = new TrainingCenterMembership(getMaxId(TABLE), state,trainingCenter, membershipType);
                return trainingCenterMembership;
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
        return this.updateByCriteria("DELETE FROM "+TABLE+" WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(TrainingCenterMembership trainingCenterMembership) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET state = '" + trainingCenterMembership.getState() + "', training_centers_id ="+trainingCenterMembership.getId()+", membership_types_id="+ trainingCenterMembership.getId()+"  WHERE id = " + String.valueOf(trainingCenterMembership.getId())) > 0;
    }

    public TrainingCentersEntity getTrainingCentersEntity() {
        return trainingCentersEntity;
    }

    public void setTrainingCentersEntity(TrainingCentersEntity trainingCentersEntity) {
        this.trainingCentersEntity = trainingCentersEntity;
    }

    public MembershipsTypeEntity getMembershipsTypeEntity() {
        return membershipsTypeEntity;
    }

    public void setMembershipsTypeEntity(MembershipsTypeEntity membershipsTypeEntity) {
        this.membershipsTypeEntity = membershipsTypeEntity;
    }
}

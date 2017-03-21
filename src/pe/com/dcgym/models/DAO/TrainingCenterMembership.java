package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.MembershipsTypeEntity;
import pe.com.dcgym.models.DTO.TrainingCentersEntity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TrainingCenterMembership {
    private int id;
    private String state;
    private TrainingCenter  trainingCenter ;
    private MembershipType membershipType;

    public TrainingCenterMembership(int id, String state, TrainingCenter trainingCenter, MembershipType membershipType) {
        this.setId(id);
        this.setState(state);
        this.setTrainingCenter(trainingCenter);
        this.setMembershipType(membershipType);
    }
    public static TrainingCenterMembership build(ResultSet resultSet, TrainingCentersEntity trainingCentersEntity, MembershipsTypeEntity membershipsTypeEntity) {
        try {
            return new TrainingCenterMembership(resultSet.getInt("id"),
                    resultSet.getString("state"),
                    trainingCentersEntity.findById(resultSet.getInt("training_centers_id")),
                    membershipsTypeEntity.findById(resultSet.getInt("membership_types_id")));


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public TrainingCenter getTrainingCenter() {
        return trainingCenter;
    }

    public void setTrainingCenter(TrainingCenter trainingCenter) {
        this.trainingCenter = trainingCenter;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }
}

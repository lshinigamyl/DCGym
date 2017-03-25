package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.GymEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GymMembershipTypes {
    private int id;
    private String state;
    private MembershipType membershipType;
    private Gym gym;


    public GymMembershipTypes(){

    }

    public GymMembershipTypes(int id, String state, MembershipType membershipType, Gym gym) {
        this.id = id;
        this.state = state;
        this.membershipType = membershipType;
        this.gym = gym;
    }

    public static GymMembershipTypes build(ResultSet resultSet, MembershipsTypeEntity membershipsTypeEntity, GymEntity gymEntity) {
        try {
            return new GymMembershipTypes(  resultSet.getInt("id"),
                                            resultSet.getString("state"),
                                            membershipsTypeEntity.findById(resultSet.getInt("membership_type_id")),
                                            gymEntity.findById(resultSet.getInt("gym_id")));


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

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}

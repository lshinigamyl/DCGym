package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class TrainingCentersMembership {
    private int id;
    private String state;
    private TrainingCenter  trainingCenter ;
    private MembershipsType membershipTypes;
 
 
    public TrainingCentersMembership(int id, String state, TrainingCenter trainingCenter, MembershipsType membershipTypes) {
        this.setId(id);
        this.setTrainingCenter(trainingCenter);
        this.setMembershipTypes(membershipTypes);
        this.setState(state);

    }

    public TrainingCentersMembership() {
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

    public MembershipsType getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(MembershipsType membershipTypes) {
        this.membershipTypes = membershipTypes;
    }
}

package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class TrainingCentersMemberships {
    int id;
    String state;
    TrainingCenter  trainingCenter ;
    int idmembershipTypes;
 
 
    public TrainingCenters(int id, String state, TrainingCenter trainingCenter, , int idmembershipTypes) {
        this.id = id;
        this.trainingCenter = trainingCenter;
        this.idmembershipTypes = idmembershipTypes;
        this.state = state;

    }

    public TrainingCentersMemberships() {
    }
 public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the trainingCenter
     */
    public TrainingCenter trainingCenters() {
        return trainingCenter;
    }

    /**
     * @param trainingCenter the trainingCenter to set
     */
    public void settrainingCenter(TrainingCenter trainingCenters) {
        this.trainingCenter = trainingCenter;
    }

    /**
     * @return the idmembershipTypes
     */
    public int getIdmembershipTypes() {
        return idmembershipTypes;
    }

    /**
     * @param idmembershipTypes the idmembershipTypes to set
     */
    public void setIdmembershipTypes(int idmembershipTypes) {
        this.idmembershipTypes = idmembershipTypes;
    }
 


}

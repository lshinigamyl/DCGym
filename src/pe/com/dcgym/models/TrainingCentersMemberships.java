package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class TrainingCentersMemberships {
    int id;
    String state;
    int idTrainingCenters;
    int idmembershipTypes;
 
 
    public TrainingCenters(int id, String state, int idTrainingCenters, , int idmembershipTypes) {
        this.id = id;
        this.idTrainingCenters = idTrainingCenters;
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
     * @return the idTrainingCenters
     */
    public int getIdTrainingCenters() {
        return idTrainingCenters;
    }

    /**
     * @param idTrainingCenters the idTrainingCenters to set
     */
    public void setIdTrainingCenters(int idTrainingCenters) {
        this.idTrainingCenters = idTrainingCenters;
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

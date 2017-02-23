package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class MembershipsClient {
    int idMemberships;
    int idPeople;
    int idType;
    String state;

    public MembershipsClient() {
    }

    public MembershipsClient(int idMemberships, int idPeople, int idType, String state) {
        this.idMemberships = idMemberships;
        this.idPeople = idPeople;
        this.idType = idType;
        this.state = state;
    }

    public int getIdMemberships() {
        return idMemberships;
    }

    public void setIdMemberships(int idMemberships) {
        this.idMemberships = idMemberships;
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

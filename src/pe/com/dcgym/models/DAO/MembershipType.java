package pe.com.dcgym.models.DAO;

/**
 * Created by Administrador on 03/03/2017.
 */
public class MembershipType {
    private int id;
    private String name;
    private double cost;
    private String description;
    private String type;
    private String state;

    public MembershipType(){

    }

    public MembershipType(int id, String name, double cost, String description, String type, String state) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.type = type;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

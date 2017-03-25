package pe.com.dcgym.models.DAO;

/**
 * Created by Administrador on 03/03/2017.
 */
public class MembershipType {
    private int id;
    private String name;
    private double cost;
    private int daysDuration;
    private String description;

    public MembershipType(){

    }

    public MembershipType(int id, String name, double cost, int daysDuration, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.daysDuration = daysDuration;
        this.description = description;
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

    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

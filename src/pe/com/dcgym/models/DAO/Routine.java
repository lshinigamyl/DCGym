package pe.com.dcgym.models.DAO;


import pe.com.dcgym.models.DTO.GymEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Routine {
    private int id;
    private String name;
    private String description;
    private String state;
    private Gym gym;

    public Routine(){

    }

    public Routine(int id, String name, String description, String state, Gym gym) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.gym = gym;
    }
    public static Routine build(ResultSet resultSet, GymEntity gymEntity) {
        try {
            return new Routine(     resultSet.getInt("id"),
                                    resultSet.getString("name"),
                                    resultSet.getString("description"),
                                    resultSet.getString("state"),
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }
}


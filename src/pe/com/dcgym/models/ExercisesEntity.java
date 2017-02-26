package pe.com.dcgym.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class ExercisesEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM exercises";

    public List<Exercise> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Exercise findById(int id) {
        List<Exercise> exercises = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return exercises != null ? exercises.get(0) : null;
    }

    public Exercise findByName(String name) {
        List<Exercise> exercises = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return exercises.isEmpty() ? null : exercises.get(0);
    }

    private List<Exercise> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Exercise> exercises = new ArrayList<Exercise>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Exercise exercise = new Exercise() ;
                    exercise.setId(resultSet.getInt(1));
                    exercise.setName(resultSet.getString(2));
                    exercise.setDescription(resultSet.getString(3));
                    exercise.setState(resultSet.getString(4));
                    exercises.add(exercise);
                }
                return exercises;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Exercise create(String name, String description, String state) {
        if (this.findByName(name) == null && this.getConnection() != null) {
        String sql = "INSERT INTO exercises(id, name, description,state) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

            preparedStatement.setInt   (1, (getMaxId("exercises")+1));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, state);

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                Exercise exercise = new Exercise( getMaxId("exercises"), name, description, state);
                return exercise;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
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
        return this.updateByCriteria("DELETE FROM exercises WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(Exercise exercise) {
        return this.updateByCriteria("UPDATE exercises SET name ='"+exercise.getName()+"', description='"+exercise.getDescription()+"', state='"+exercise.getState()+"' WHERE id = " + String.valueOf(exercise.getId())) > 0;
    }
}

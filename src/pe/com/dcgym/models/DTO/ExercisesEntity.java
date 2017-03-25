package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Exercise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExercisesEntity extends BaseEntity {
    private static String TABLE="exercises";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;

    public List<Exercise> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Exercise findById(int id) {
        List<Exercise> exercises = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return exercises != null ? exercises.get(0) : null;
    }
/*
    public Exercise findByName(String name) {
        List<Exercise> exercises = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return exercises.isEmpty() ? null : exercises.get(0);
    }
*/
    private List<Exercise> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Exercise> exercises = new ArrayList<Exercise>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Exercise exercise = new Exercise() ;
                        exercise.setId(resultSet.getInt("id"));
                        exercise.setName(resultSet.getString("name"));
                        exercise.setDescription(resultSet.getString("description"));
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



    public Exercise create(Exercise exercise) {
       // if (this.findByName(name) == null && this.getConnection() != null) {
        String sql = "INSERT INTO `exercises` (`name`, `description`) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

            preparedStatement.setString(1, exercise.getName());
            preparedStatement.setString(2, exercise.getDescription());

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                exercise.setId(super.getMaxId(TABLE));
                return exercise;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
      //  }
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
        return this.updateByCriteria("UPDATE exercises SET name ='"+exercise.getName()+"', description='"+exercise.getDescription()+"' WHERE id = " + String.valueOf(exercise.getId())) > 0;
    }
}

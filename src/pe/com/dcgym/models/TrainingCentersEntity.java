package pe.com.dcgym.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fjorsvartnir on 25/02/2017.
 */
public class TrainingCentersEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM training_centers";

    public List<TrainingCenter> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public TrainingCenter findById(int id) {
        List<TrainingCenter> trainingCenters = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return trainingCenters != null ? trainingCenters.get(0) : null;
    }

    public TrainingCenter findByName(String name) {
        List<TrainingCenter> trainingCenters = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return trainingCenters.isEmpty() ? null : trainingCenters.get(0);
    }

    private List<TrainingCenter> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<TrainingCenter> trainingCenters = new ArrayList<TrainingCenter>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    TrainingCenter trainingCenter = new TrainingCenter() ;
                        trainingCenter.setId(resultSet.getInt(1));
                        trainingCenter.setName(resultSet.getString(2));
                        trainingCenter.setDescription(resultSet.getString(3));
                        trainingCenter.setState(resultSet.getString(4));
                    trainingCenters.add(trainingCenter);
                }
                return trainingCenters;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public TrainingCenter create(String name, String ruc, String address,String telephone,String email,String description,String website,String credit_card,String user,String password,String state) {
        if (this.findByName(name) == null && this.getConnection() != null) {
            String sql = "INSERT INTO exercises(id, name, ruc,address, telephone, email, description, website, credit_card, user, password,state ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

                preparedStatement.setInt   (1, (getMaxId("training_centers")+1));
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, ruc);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, telephone);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, description);
                preparedStatement.setString(8, website);
                preparedStatement.setString(9, credit_card);
                preparedStatement.setString(10, user);
                preparedStatement.setString(11, password);
                preparedStatement.setString(12, state);


                int results = preparedStatement.executeUpdate(sql);
                if (results > 0) {
                    TrainingCenter TrainingCenter = new TrainingCenter(getMaxId("training_centers"), name,  ruc,  address, telephone, email, description, website, credit_card, user, password, state);
                    return TrainingCenter;
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
        return this.updateByCriteria("DELETE FROM training_centers WHERE id  = " + String.valueOf(id)) > 0;
    }
/*
    public boolean update(Exercise exercise) {
        return this.updateByCriteria("UPDATE exercises SET name ='"+exercise.getName()+"', description='"+exercise.getDescription()+"', state='"+exercise.getState()+"' WHERE id = " + String.valueOf(exercise.getId())) > 0;
    }
*/
}

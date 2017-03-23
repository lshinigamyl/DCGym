package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.TrainingCenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*

 */
public class TrainingCentersEntity extends BaseEntity {
    private static String TABLE="training_centers";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;

    public List<TrainingCenter> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public TrainingCenter findById(int id) {
        List<TrainingCenter> trainingCenters = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return trainingCenters.isEmpty() ? null : trainingCenters.get(0);
    }

    public TrainingCenter findByUser(String user) {
        List<TrainingCenter> trainingCenters = this.findByCriteria(DEFAULT_SQL + " WHERE user = '" +user+ "'");
        return trainingCenters.isEmpty() ? null : trainingCenters.get(0);
    }

    private List<TrainingCenter> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<TrainingCenter> trainingCenters = new ArrayList<TrainingCenter>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    TrainingCenter trainingCenter = new TrainingCenter();
                    trainingCenter.setId(resultSet.getInt("id"));
                    trainingCenter.setName(resultSet.getString("name"));
                    trainingCenter.setRuc(resultSet.getString("ruc"));
                    trainingCenter.setAddress(resultSet.getString("address"));
                    trainingCenter.setTelephone(resultSet.getString("telephone"));
                    trainingCenter.setEmail(resultSet.getString("email"));
                    trainingCenter.setDescription(resultSet.getString("description"));
                    trainingCenter.setWebsites(resultSet.getString("website"));
                    trainingCenter.setCreditCard(resultSet.getString("credit_card"));
                    trainingCenter.setUser(resultSet.getString("user"));
                    trainingCenter.setPass(resultSet.getString("password"));
                    trainingCenter.setState(resultSet.getString("state"));
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



    public TrainingCenter create(String name, String ruc, String address, String telephone, String email, String description, String website,String credit_card, String user, String password, String state) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, name, ruc, address, telephone, email, description, website, credit_card, user, password, state) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, name);
            obj.setString(3, ruc);
            obj.setString(4, address);
            obj.setString(5, telephone);
            obj.setString(6, email);
            obj.setString(7, description);
            obj.setString(8, website);
            obj.setString(9, credit_card);
            obj.setString(10, user);
            obj.setString(11, password);
            obj.setString(12, state);

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                TrainingCenter trainingCenter = new TrainingCenter(getMaxId(TABLE),  name,  ruc,  address,  telephone,  email,  description,  website, credit_card,  user,  password,  state);
                return trainingCenter;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //}
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
        return this.updateByCriteria("DELETE FROM "+TABLE+" WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(TrainingCenter trainingCenter) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET name = '" + trainingCenter.getName() + "', description ='"+trainingCenter.getDescription()+"', state='"+ trainingCenter.getState()+"'  WHERE id = " + String.valueOf(trainingCenter.getId())) > 0;
    }

}

package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Gym;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*

 */
public class GymEntity extends BaseEntity {
    private static String TABLE="gyms";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;

    public List<Gym> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Gym findById(int id) {
        List<Gym> Gyms = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return Gyms.isEmpty() ? null : Gyms.get(0);
    }

    public Gym findByUser(String user) {
        List<Gym> Gyms = this.findByCriteria(DEFAULT_SQL + " WHERE username = '" +user+ "'");
        return Gyms.isEmpty() ? null : Gyms.get(0);
    }

    private List<Gym> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Gym> gyms = new ArrayList<Gym>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Gym gym = new Gym();
                    gym.setId(resultSet.getInt("id"));
                    gym.setName(resultSet.getString("name"));
                    gym.setAddress(resultSet.getString("address"));
                    gym.setTelePhone(resultSet.getString("telephone"));
                    gym.setCellPhone(resultSet.getString("cellphone"));;
                    gym.setEmail(resultSet.getString("email"));
                    gym.setDescription(resultSet.getString("description"));
                    gym.setWebsite(resultSet.getString("website"));
                    gym.setUsername(resultSet.getString("username"));
                    gym.setPassword(resultSet.getString("password"));
                    gyms.add(gym);
                }
                return gyms;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Gym create(Gym gym) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO `gyms` (`name`, `address`, `telephone`, `cellphone`, `email`, `description`, `website`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setString(1, gym.getName());
            obj.setString(2, gym.getAddress());
            obj.setString(3, gym.getTelePhone());
            obj.setString(4, gym.getCellPhone());
            obj.setString(5, gym.getEmail());
            obj.setString(6, gym.getDescription());
            obj.setString(7, gym.getWebsite());
            obj.setString(8, gym.getUsername());
            obj.setString(9, gym.getPassword());

            int results = obj.executeUpdate();
            if (results > 0) {
                gym.setId(super.getMaxId(TABLE));
                return gym;
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

    public boolean update(Gym Gym) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET name = '" + Gym.getName() + "', description ='"+ Gym.getDescription()+"' WHERE id = " + String.valueOf(Gym.getId())) > 0;
    }

}

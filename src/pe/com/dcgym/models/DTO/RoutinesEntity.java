package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Routine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 */
public class RoutinesEntity extends BaseEntity {
    private static String TABLE="routines";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private GymEntity gymEntity;

    public List<Routine> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Routine findById(int id) {
        List<Routine> routines = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return routines != null ? routines.get(0) : null;
    }

    public Routine findByName(String name) {
        List<Routine> routines = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return routines.isEmpty() ? null : routines.get(0);
    }

    private List<Routine> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Routine> routines = new ArrayList<Routine>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Routine routine = Routine.build(resultSet,getGymEntity());
                }
                return routines;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Routine create(Routine routine) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO `routines` (`name`, `description`, `gym_id`) VALUES (?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setString(1, routine.getName());
            obj.setString(2, routine.getDescription());
            obj.setInt   (3, routine.getGym().getId());

            int results = obj.executeUpdate();
            if (results > 0) {
                routine.setId(getMaxId(TABLE));
                return routine;
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

    public boolean update(Routine routine) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET name = '" + routine.getName() + "', description ='"+routine.getDescription()+"', state='"+ routine.getState()+"'  WHERE id = " + String.valueOf(routine.getId())) > 0;
    }

    public GymEntity getGymEntity() {
        return gymEntity;
    }

    public void setGymEntity(GymEntity gymEntity) {
        this.gymEntity = gymEntity;
    }
}

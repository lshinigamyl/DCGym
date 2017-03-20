package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Routine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miku_ on 04/03/2017.
 */
public class RoutinesEntity extends BaseEntity {
    private static String TABLE="routines";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private PeopleEntity peopleEntity;

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
                    Routine routine = new Routine();
                    routine.setId(resultSet.getInt("id"));
                    routine.setName(resultSet.getString("name"));
                    routine.setDescription(resultSet.getString("description"));
                    routine.setState(resultSet.getString("state"));
                    routines.add(routine);
                }
                return routines;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Routine create(String name,  String description, String state) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, name, description, state) VALUES(?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, name);
            obj.setString(3, description);
            obj.setString(4, state);

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                Routine customer = new Routine(getMaxId(TABLE), name,description, state);
                return customer;
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

    public PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }
}

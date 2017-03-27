package pe.com.dcgym.models.DTO;

/**
 */
import pe.com.dcgym.models.DAO.People;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PeopleEntity extends BaseEntity{
    private static final String TABLE = "people";
    private static final String DEFAULT_SQL = "SELECT * FROM "+TABLE;


    public List<People> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public People findById(int id) {
        List<People> peoples = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return peoples.isEmpty() ? null : peoples.get(0);
    }

    public People findByUser(String user) {
        List<People> peoples = this.findByCriteria(DEFAULT_SQL + " WHERE username = '" +user+ "'");
        return peoples.isEmpty() ? null : peoples.get(0);
    }

    private List<People> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<People> peoples = new ArrayList<People>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    People people = new People( resultSet.getInt("id"),
                                                resultSet.getString("firstname"),
                                                resultSet.getString("lastname"),
                                                resultSet.getString("dni"),
                                                resultSet.getDate("date_birth"),
                                                resultSet.getString("email"),
                                                resultSet.getString("address"),
                                                resultSet.getString("cellphone"),
                                                resultSet.getString("telephone"),
                                                resultSet.getString("username"),
                                                resultSet.getString("password"));
                    peoples.add(people);
                }
                return peoples;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public People create(People people) {
        if (this.findByUser(people.getUserName()) == null && this.getConnection() != null) {
            String sql = "INSERT INTO `people` (`firstname`, `lastname`, `dni`, `date_birth`, `email`, `cellphone`, `telephone`, `address`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement obj =  this.getConnection().prepareStatement(sql);
                obj.setString(1, people.getFirstName());
                obj.setString(2, people.getLastName());
                obj.setString(3, people.getDni());
                obj.setDate  (4, people.getDateBirth());
                obj.setString(5, people.getEmail());
                obj.setString(6, people.getCellPhone());
                obj.setString(7, people.getTelePhone());
                obj.setString(8, people.getAddress());
                obj.setString(9, people.getUserName());
                obj.setString(10,people.getPassword());

                int results = obj.executeUpdate();
                if (results > 0) {
                    people.setId(getMaxId(TABLE));
                    return people;
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
        return this.updateByCriteria("DELETE FROM people WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean delete(String name) {
        return this.updateByCriteria("DELETE FROM people WHERE name = '" + name + "'") > 0;
    }

    public boolean update(People people) {
        return this.updateByCriteria("UPDATE people SET firstname = '" + people.getFirstName() + "' WHERE id = " + String.valueOf(people.getId())) > 0;
    }
    public boolean validateUser(String username , String password){
        int count=0;
        if (this.getConnection() != null) {
            try {
                ResultSet rs = getConnection().createStatement().executeQuery("SELECT * FROM people as p where p.user='"+username+"' and p.password='"+password+"';");
                while (rs.next()){
                    count+=1;
                }
                if(count==1){
                    return true;
                }

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

}

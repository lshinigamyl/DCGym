package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PeopleEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM People";

    public List<People> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public People findById(int id) {
        List<People> peoples = this.findByCriteria(DEFAULT_SQL + " WHERE idPeople = " + String.valueOf(id));
        return peoples != null ? peoples.get(0) : null;
    }

    public People findByName(String name) {
        List<People> peoples = this.findByCriteria(DEFAULT_SQL + " WHERE idPeople = '" + name + "'");
        return peoples.isEmpty() ? null : peoples.get(0);
    }

    private List<People> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<People> peoples = new ArrayList<People>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    People people = new People(resultSet.getInt("idPeople"), resultSet.getString("name_client"),resultSet.getString("surname"),resultSet.getString("name"),resultSet.getInt("num_document"),resultSet.getString("email"),resultSet.getString("date_birth"),resultSet.getString("address"),resultSet.getInt("cellphone"),resultSet.getInt("telephone"),resultSet.getString("User"),resultSet.getString("Pass"));
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

    private int getMaxId() {
        String sql = "SELECT MAX(idPeople) as max_id FROM People";
        if (this.getConnection() != null) {
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                return resultSet.next() ? resultSet.getInt(1) : 0;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public People create( String nameClient, String surName, String name, int numDocument, String email, String dateBirth, String address, int cellphone, int telephone, String user, String pass ) {
        if (this.findByName(name) == null && this.getConnection() != null) {
            String sql = "INSERT INTO People(id_People, name_client,surname,name,num_document,email,date_birth,address,cellphone,telephone,User,Pass) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement obj =  this.getConnection().prepareStatement(sql);
                obj.setInt(1, getMaxId());
                obj.setString(2, nameClient);
                obj.setString(3, surName);
                obj.setString(4, name);
                obj.setInt(5, numDocument);
                obj.setString(6, email);
                obj.setString(7, dateBirth);
                obj.setString(8, address);
                obj.setInt(9, cellphone);
                obj.setInt(10, telephone);
                obj.setString(11, user);
                obj.setString(12, pass);


                int results = obj.executeUpdate(sql);
                if (results > 0) {
                    People region = new People(getMaxId(), nameClient, surName, name, numDocument, email, dateBirth, address, cellphone, telephone, user, pass);
                    return region;
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
        return this.updateByCriteria("DELETE FROM People WHERE idPeople  = " + String.valueOf(id)) > 0;
    }

    public boolean delete(String name) {
        return this.updateByCriteria("DELETE FROM People WHERE name_client = '" + name + "'") > 0;
    }

    public boolean update(People people) {
        return this.updateByCriteria("UPDATE regions SET region_name = '" + people.getName() + "' WHERE region_id = " + String.valueOf(people.getIdPeople())) > 0;
    }

}

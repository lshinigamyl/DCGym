package pe.com.dcgym.models;

/**

 */
import pe.com.dcgym.models.DAO.People;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PeopleEntity extends BaseEntity{
    private static String DEFAULT_SQL = "SELECT * FROM people";

    public List<People> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public People findById(int id) {
        List<People> peoples = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return peoples != null ? peoples.get(0) : null;
    }

    public People findByUser(String user) {
        List<People> peoples = this.findByCriteria(DEFAULT_SQL + " WHERE user = '" +user+ "'");
        return peoples.isEmpty() ? null : peoples.get(0);
    }

    private List<People> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<People> peoples = new ArrayList<People>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    People people = new People(resultSet.getInt("id"), resultSet.getString("name"),resultSet.getString("surname"),resultSet.getString("document_number"),resultSet.getString("email"),resultSet.getString("date_birth"),resultSet.getString("address"),resultSet.getString("cellphone"),resultSet.getString("telephone"),resultSet.getString("user"),resultSet.getString("password"),resultSet.getString("state"));
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



    public People create( String name, String surName,  String numDocument, String email, String dateBirth, String address, String cellphone, String telephone, String user, String password, String state ) {
        if (this.findByUser(user) == null && this.getConnection() != null) {
            String sql = "INSERT INTO People(id, name, surname, document_number, email, date_birth, address, cellphone, telephone, user, password, state) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement obj =  this.getConnection().prepareStatement(sql);
                obj.setInt(1, getMaxId("people"));
                obj.setString(2, name);
                obj.setString(3, surName);
                obj.setString(4, numDocument);
                obj.setString(5, email);
                obj.setString(6, dateBirth);
                obj.setString(7, address);
                obj.setString(8, cellphone);
                obj.setString(9, telephone);
                obj.setString(10, user);
                obj.setString(11, password);
                obj.setString(12, state);


                int results = obj.executeUpdate(sql);
                if (results > 0) {
                    People people = new People(getMaxId("people"), surName, name, numDocument, email, dateBirth, address, cellphone, telephone, user, password, state);
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
        return this.updateByCriteria("UPDATE people SET name = '" + people.getName() + "' WHERE id = " + String.valueOf(people.getId())) > 0;
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

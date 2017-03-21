package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.MembershipType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 */
public class MembershipsTypeEntity extends BaseEntity{
    private static String TABLE="membership_types";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;

    public List<MembershipType> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public MembershipType findById(int id) {
        List<MembershipType> membershipTypes = this.findByCriteria(DEFAULT_SQL + " WHERE id = "+ String.valueOf(id)+";");
        return membershipTypes.isEmpty() ? null : membershipTypes.get(0);
    }

    public MembershipType findByName(String name) {
        List<MembershipType> membershipTypes = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return membershipTypes.isEmpty() ? null : membershipTypes.get(0);
    }

    private List<MembershipType> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<MembershipType> membershipTypes = new ArrayList<MembershipType>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    MembershipType membershipType = new MembershipType();
                    membershipType.setId(resultSet.getInt("id"));
                    membershipType.setName(resultSet.getString("name"));
                    membershipType.setCost(resultSet.getFloat("cost"));
                    membershipType.setDescription(resultSet.getString("description"));
                    membershipType.setType(resultSet.getString("type"));
                    membershipType.setState(resultSet.getString("state"));
                    membershipTypes.add(membershipType);
                }
                return membershipTypes;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public MembershipType create(String name,  float cost, String description,String type,String state) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, name, cost, description, type, state) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, name);
            obj.setFloat (3, cost);
            obj.setString(4, description);
            obj.setString(5, type);
            obj.setString(6, state);

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                MembershipType membershipType = new MembershipType(getMaxId(TABLE), name, cost, description, type,state);
                return membershipType;
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

    public boolean update(MembershipType membershipType) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET name = '" + membershipType.getName() + "', cost ='"+membershipType.getState()+"', description='"+ membershipType.getDescription()+"', type='"+membershipType.getType()+"', state='"+membershipType.getState()+"'  WHERE id = " + String.valueOf(membershipType.getId())) > 0;
    }

}

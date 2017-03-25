package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.MembershipType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 */
public class MembershipsTypeEntity extends BaseEntity {
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
                    membershipType.setCost(resultSet.getDouble("cost"));
                    membershipType.setDaysDuration(resultSet.getInt("days_duration"));
                    membershipType.setDescription(resultSet.getString("description"));
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



    public MembershipType create(MembershipType membershipType) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO membership_types (name, cost, days_duration, description) VALUES ( ? , ? , ? , ? )";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setString(1, membershipType.getName());
            obj.setDouble(2, membershipType.getCost());
            obj.setInt   (3, membershipType.getDaysDuration());
            obj.setString(4, membershipType.getDescription());

            int results = obj.executeUpdate();
            if (results > 0) {
                membershipType.setId(super.getMaxId(TABLE));
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
        return this.updateByCriteria("UPDATE `membership_types` SET `name`='"+membershipType.getName()+"', `cost`='"+membershipType.getCost()+"', `days_duration`='"+membershipType.getDaysDuration()+"', `description`='"+membershipType.getDescription()+"' WHERE (`id`='"+membershipType.getId()+"')") > 0;
    }

}

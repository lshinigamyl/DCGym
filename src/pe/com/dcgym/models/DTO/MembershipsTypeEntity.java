package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.MembershipType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**Decimos que podría considerarse demasiado restrictivo
 * porque limita el acceso a una subclase como si se tratara
 * de una clase cualquiera, cuando en realidad la relación de
 * una superclase con una subclase es más estrecha que con una
 * clase externa. Por ello en diferentes lenguajes, Java entre
 * ellos, se usa un nivel de acceso intermedio que no es ni public
 * ni private, sino algo intermedio que se denomina como
 * “acceso protegido”, expresado con la palabra clave protected,
 * que significa que las subclases sí pueden tener acceso al campo
 * o método.

 El modificador de acceso protected puede aplicarse a todos
 los miembros de una clase, es decir, tanto a campos como
 a métodos o constructores. En el caso de métodos o
 constructores protegidos, estos serán visibles/utilizables
 por las subclases y otras clases del mismo package. El acceso
 protegido suele aplicarse a métodos o constructores, pero
 preferiblemente no a campos, para evitar debilitar el
 encapsulamiento. En ocasiones puntuales sí resulta de interés
 declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga
 a la que usamos con las palabras public y private, con
 la salvedad de que protected suele usarse cuando se trabaja
 con herencia. Desde un objeto de una subclase podremos acceder
 o invocar un campo o método declarado como protected, pero no
 podemos acceder o invocar a campos o métodos privados de una
 superclase. Declara un campo de una clase como protected y en
 un test crea un objeto de la subclase y trata de acceder a ese
 campo con una invocación directa del tipo interino43.IdProfesor =
 “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso:
 la omisión del mismo (no declarar ninguno de los modificadores public,
 private o protected). En la siguiente tabla puedes comparar los efectos
 de usar uno u otro tipo de declaración en cuanto a visibilidad de los
 campos o métodos:
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

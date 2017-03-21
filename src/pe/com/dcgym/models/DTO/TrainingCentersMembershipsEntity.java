package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.MembershipType;
import pe.com.dcgym.models.DAO.TrainingCenter;
import pe.com.dcgym.models.DAO.TrainingCenterMembership;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 
 Decimos que podría considerarse demasiado
 restrictivo porque limita el acceso a una
 subclase como si se tratara de una clase
 cualquiera, cuando en realidad la relación
 de una superclase con una subclase es más
 estrecha que con una clase externa. Por ello
 en diferentes lenguajes, Java entre ellos, se
 usa un nivel de acceso intermedio que no es ni
 public ni private, sino algo intermedio que se
 denomina como “acceso protegido”, expresado con
 la palabra clave protected, que significa que
 las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse
 a todos los miembros de una clase, es decir, tanto
 a campos como a métodos o constructores. En el caso
 de métodos o constructores protegidos, estos serán
 visibles/utilizables por las subclases y otras clases
 del mismo package. El acceso protegido suele aplicarse
 a métodos o constructores, pero preferiblemente no a
 campos, para evitar debilitar el encapsulamiento. En
 ocasiones puntuales sí resulta de interés declarar
 campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga
 a la que usamos con las palabras public y private, con
 la salvedad de que protected suele usarse cuando se
 trabaja con herencia. Desde un objeto de una subclase
 podremos acceder o invocar un campo o método declarado
 como protected, pero no podemos acceder o invocar a campos
 o métodos privados de una superclase. Declara un campo de
 una clase como protected y en un test crea un objeto de la
 subclase y trata de acceder a ese campo con una invocación
 directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores
 de acceso: la omisión del mismo (no declarar ninguno
 de los modificadores public, private o protected).
 En la siguiente tabla puedes comparar los efectos
 de usar uno u otro tipo de declaración en cuanto
 a visibilidad de los campos o métodos:

 */
public class TrainingCentersMembershipsEntity extends BaseEntity{
    private static String TABLE="training_center_memberships";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private TrainingCentersEntity trainingCentersEntity;
    private MembershipsTypeEntity membershipsTypeEntity;

    public List<TrainingCenterMembership> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public TrainingCenterMembership findById(int id) {
        List<TrainingCenterMembership> trainingCenterMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return trainingCenterMemberships != null ? trainingCenterMemberships.get(0) : null;
    }

    public TrainingCenterMembership findByName(String name) {
        List<TrainingCenterMembership> trainingCenterMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return trainingCenterMemberships.isEmpty() ? null : trainingCenterMemberships.get(0);
    }

    private List<TrainingCenterMembership> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<TrainingCenterMembership> routines = new ArrayList<TrainingCenterMembership>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    TrainingCenterMembership routine = TrainingCenterMembership.build(resultSet,getTrainingCentersEntity(),getMembershipsTypeEntity());
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



    public TrainingCenterMembership create(String state, TrainingCenter trainingCenter, MembershipType membershipType) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+" (id, state, training_centers_id, membership_types_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, state);
            obj.setInt   (3, trainingCenter.getId());
            obj.setInt   (4, membershipType.getId());

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                TrainingCenterMembership trainingCenterMembership = new TrainingCenterMembership(getMaxId(TABLE), state,trainingCenter, membershipType);
                return trainingCenterMembership;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
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
        return this.updateByCriteria("DELETE FROM "+TABLE+" WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(TrainingCenterMembership trainingCenterMembership) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET state = '" + trainingCenterMembership.getState() + "', training_centers_id ="+trainingCenterMembership.getId()+", membership_types_id="+ trainingCenterMembership.getId()+"  WHERE id = " + String.valueOf(trainingCenterMembership.getId())) > 0;
    }

    public TrainingCentersEntity getTrainingCentersEntity() {
        return trainingCentersEntity;
    }

    public void setTrainingCentersEntity(TrainingCentersEntity trainingCentersEntity) {
        this.trainingCentersEntity = trainingCentersEntity;
    }

    public MembershipsTypeEntity getMembershipsTypeEntity() {
        return membershipsTypeEntity;
    }

    public void setMembershipsTypeEntity(MembershipsTypeEntity membershipsTypeEntity) {
        this.membershipsTypeEntity = membershipsTypeEntity;
    }
}

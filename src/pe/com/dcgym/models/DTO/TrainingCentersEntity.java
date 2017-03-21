package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.TrainingCenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
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
public class TrainingCentersEntity extends BaseEntity {
    private static String TABLE="training_centers";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;

    public List<TrainingCenter> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public TrainingCenter findById(int id) {
        List<TrainingCenter> trainingCenters = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return trainingCenters != null ? trainingCenters.get(0) : null;
    }

    public TrainingCenter findByUser(String user) {
        List<TrainingCenter> trainingCenters = this.findByCriteria(DEFAULT_SQL + " WHERE user = '" +user+ "'");
        return trainingCenters.isEmpty() ? null : trainingCenters.get(0);
    }

    private List<TrainingCenter> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<TrainingCenter> trainingCenters = new ArrayList<TrainingCenter>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    TrainingCenter trainingCenter = new TrainingCenter();
                    trainingCenter.setId(resultSet.getInt("id"));
                    trainingCenter.setName(resultSet.getString("name"));
                    trainingCenter.setRuc(resultSet.getString("ruc"));
                    trainingCenter.setAddress(resultSet.getString("address"));
                    trainingCenter.setTelephone(resultSet.getString("telephone"));
                    trainingCenter.setEmail(resultSet.getString("email"));
                    trainingCenter.setDescription(resultSet.getString("description"));
                    trainingCenter.setWebsites(resultSet.getString("website"));
                    trainingCenter.setCreditCard(resultSet.getString("credit_card"));
                    trainingCenter.setUser(resultSet.getString("user"));
                    trainingCenter.setPass(resultSet.getString("password"));
                    trainingCenter.setState(resultSet.getString("state"));
                    trainingCenters.add(trainingCenter);
                }
                return trainingCenters;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public TrainingCenter create(String name, String ruc, String address, String telephone, String email, String description, String website,String credit_card, String user, String password, String state) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, name, ruc, address, telephone, email, description, website, credit_card, user, password, state) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, name);
            obj.setString(3, ruc);
            obj.setString(4, address);
            obj.setString(5, telephone);
            obj.setString(6, email);
            obj.setString(7, description);
            obj.setString(8, website);
            obj.setString(9, credit_card);
            obj.setString(10, user);
            obj.setString(11, password);
            obj.setString(12, state);

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                TrainingCenter trainingCenter = new TrainingCenter(getMaxId(TABLE),  name,  ruc,  address,  telephone,  email,  description,  website, credit_card,  user,  password,  state);
                return trainingCenter;
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

    public boolean update(TrainingCenter trainingCenter) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET name = '" + trainingCenter.getName() + "', description ='"+trainingCenter.getDescription()+"', state='"+ trainingCenter.getState()+"'  WHERE id = " + String.valueOf(trainingCenter.getId())) > 0;
    }

}

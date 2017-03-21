package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Exercise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase
 * como si se tratara de una clase cualquiera, cuando en realidad la relación de una superclase
 * con una subclase es más estrecha que con una clase externa. Por ello en diferentes lenguajes,
 * Java entre ellos, se usa un nivel de acceso intermedio que no es ni public ni private, sino
 * algo intermedio que se denomina como “acceso protegido”, expresado con la palabra clave protected,
 * que significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir,
 tanto a campos como a métodos o constructores. En el caso de métodos o constructores protegidos,
 estos serán visibles/utilizables por las subclases y otras clases del mismo package. El acceso
 suele aplicarse a métodos o constructores, pero preferiblemente no a campos, para evitar debilitar
 el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar campos con acceso protegido.


 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y
 private, con la salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un
 objeto de una subclase podremos acceder o invocar un campo o método declarado como protected, pero
 no podemos acceder o invocar a campos o métodos privados de una superclase. Declara un campo de una
 clase como protected y en un test crea un objeto de la subclase y trata de acceder a ese campo con
 una invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar
 ninguno de los modificadores public, private o protected). En la siguiente tabla puedes comparar los
 efectos de usar uno u otro tipo de declaración en cuanto a visibilidad de los campos o métodos:
 */
public class ExercisesEntity extends BaseEntity {
    private static String TABLE="exercises";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;

    public List<Exercise> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Exercise findById(int id) {
        List<Exercise> exercises = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return exercises != null ? exercises.get(0) : null;
    }
/*
    public Exercise findByName(String name) {
        List<Exercise> exercises = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return exercises.isEmpty() ? null : exercises.get(0);
    }
*/
    private List<Exercise> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Exercise> exercises = new ArrayList<Exercise>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Exercise exercise = new Exercise() ;
                        exercise.setId(resultSet.getInt(1));
                        exercise.setName(resultSet.getString(2));
                        exercise.setDescription(resultSet.getString(3));
                        exercise.setState(resultSet.getString(4));
                    exercises.add(exercise);
                }
                return exercises;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Exercise create(String name, String description, String state) {
       // if (this.findByName(name) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, name, description, state) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

            preparedStatement.setInt   (1, (getMaxId(TABLE)+1));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, state);

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                Exercise exercise = new Exercise( getMaxId(TABLE), name, description, state);
                return exercise;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
      //  }
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
        return this.updateByCriteria("DELETE FROM exercises WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(Exercise exercise) {
        return this.updateByCriteria("UPDATE exercises SET name ='"+exercise.getName()+"', description='"+exercise.getDescription()+"', state='"+exercise.getState()+"' WHERE id = " + String.valueOf(exercise.getId())) > 0;
    }
}

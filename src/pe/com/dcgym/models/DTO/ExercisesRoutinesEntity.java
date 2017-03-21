package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Exercise;
import pe.com.dcgym.models.DAO.ExerciseRoutine;
import pe.com.dcgym.models.DAO.Routine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase como si se tratara de una
 * clase cualquiera, cuando en realidad la relación de una superclase con una subclase es más estrecha que con una clase
 * externa. Por ello en diferentes lenguajes, Java entre ellos, se usa un nivel de acceso intermedio que no es ni public
 * ni private, sino algo intermedio que se denomina como “acceso protegido”, expresado con la palabra clave protected, que
 * significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir, tanto
 a campos como a métodos o constructores. En el caso de métodos o constructores protegidos, estos serán visibles/utilizables
 por las subclases y otras clases del mismo package. El acceso protegido suele aplicarse a métodos o constructores, pero
 preferiblemente no a campos, para evitar debilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar
 campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y private, con la salvedad
 de que protected suele usarse cuando se trabaja con herencia. Desde un objeto de una subclase podremos acceder o invocar un
 campo o método declarado como protected, pero no podemos acceder o invocar a campos o métodos privados de una superclase.
 Declara un campo de una clase como protected y en un test crea un objeto de la subclase y trata de acceder a ese campo con
 una invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar ninguno de los
 modificadores public, private o protected). En la siguiente tabla puedes comparar los efectos de usar uno u otro tipo de
 declaración en cuanto a visibilidad de los campos o métodos:
 */
public class ExercisesRoutinesEntity extends BaseEntity {
    private static String TABLE="exercises_routines";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private RoutinesEntity routinesEntity;
    private ExercisesEntity exercisesEntity;


    public List<ExerciseRoutine> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }
/*
    public ExerciseRoutine findById(int id) {
        List<ExerciseRoutine> exerciseRoutines = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return exerciseRoutines != null ? exerciseRoutines.get(0) : null;
    }

        public ExerciseRoutine findByName(String name) {
            List<ExerciseRoutine> customerRoutines = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
            return customerRoutines.isEmpty() ? null : customerRoutines.get(0);
        }
    */
    private List<ExerciseRoutine> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<ExerciseRoutine> exerciseRoutines = new ArrayList<ExerciseRoutine>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    ExerciseRoutine exerciseRoutine = ExerciseRoutine.build(resultSet, getRoutinesEntity(),getExercisesEntity());
                    exerciseRoutines.add(exerciseRoutine);
                }
                return exerciseRoutines;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public ExerciseRoutine create(String sequence, String range, String repeat, String valuePercent, Routine routine, Exercise exercise) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(sequence, range, repeat, value_percent, routines_id, exercises_id) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setString   (1, sequence);
            obj.setString(2, range);
            obj.setString   (3, repeat);
            obj.setString   (4, valuePercent);
            obj.setInt   (5, routine.getId());
            obj.setInt   (6, exercise.getId());

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                ExerciseRoutine exerciseRoutine = new ExerciseRoutine(sequence, range, repeat, valuePercent, routine, exercise);
                return exerciseRoutine;
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

    public boolean update(ExerciseRoutine exerciseRoutine) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET sequence ='"+exerciseRoutine.getSequence()+"', range='"+ exerciseRoutine.getRange()+"' ,repeat='"+exerciseRoutine.getRepeat()+"' , value_percent='"+exerciseRoutine.getValue_percent()+"' , routines_id="+exerciseRoutine.getRoutine().getId()+", exercises_id="+exerciseRoutine.getExercise().getId()+" WHERE id = " + String.valueOf(exerciseRoutine)) > 0;
    }

    public RoutinesEntity getRoutinesEntity() {
        return routinesEntity;
    }

    public void setRoutinesEntity(RoutinesEntity routinesEntity) {
        this.routinesEntity = routinesEntity;
    }

    public ExercisesEntity getExercisesEntity() {
        return exercisesEntity;
    }

    public void setExercisesEntity(ExercisesEntity exercisesEntity) {
        this.exercisesEntity = exercisesEntity;
    }
}

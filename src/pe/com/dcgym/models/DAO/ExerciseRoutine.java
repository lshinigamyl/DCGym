package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.ExercisesEntity;
import pe.com.dcgym.models.DTO.RoutinesEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
/*
Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase como si se tratara de una clase cualquiera, cuando en realidad la relación de una superclase con una subclase es más estrecha que con una clase externa. Por ello en diferentes lenguajes, Java entre ellos, se usa un nivel de acceso intermedio que no es ni public ni private, sino algo intermedio que se denomina como “acceso protegido”, expresado con la palabra clave protected, que significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir, tanto a campos como a métodos o constructores. En el caso de métodos o constructores protegidos, estos serán visibles/utilizables por las subclases y otras clases del mismo package. El acceso protegido suele aplicarse a métodos o constructores, pero preferiblemente no a campos, para evitar debilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y private, con la salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un objeto de una subclase podremos acceder o invocar un campo o método declarado como protected, pero no podemos acceder o invocar a campos o métodos privados de una superclase. Declara un campo de una clase como protected y en un test crea un objeto de la subclase y trata de acceder a ese campo con una invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar ninguno de los modificadores public, private o protected). En la siguiente tabla puedes comparar los efectos de usar uno u otro tipo de declaración en cuanto a visibilidad de los campos o métodos:
 */

public class ExerciseRoutine {
     
    private String sequence;
    private String range;
    private String repeat;
    private String value_percent;
    private Routine routine;
    private Exercise exercise;

	 
	public ExerciseRoutine(){
	}

    public ExerciseRoutine(String sequence, String range, String repeat, String value_percent, Routine routine, Exercise exercise) {
        this.setSequence(sequence);
        this.setRange(range);
        this.setRepeat(repeat);
        this.setValue_percent(value_percent);
        this.setRoutine(routine);
        this.setExercise(exercise);
    }
    public static ExerciseRoutine build(ResultSet resultSet, RoutinesEntity routinesEntity, ExercisesEntity exercisesEntity) {
        try {
            return new ExerciseRoutine(resultSet.getString("sequence"),resultSet.getString("range"),resultSet.getString("repeat"),resultSet.getString("value_percent"),routinesEntity.findById(resultSet.getInt("routines_id")),exercisesEntity.findById(resultSet.getInt("exercises_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getValue_percent() {
        return value_percent;
    }

    public void setValue_percent(String value_percent) {
        this.value_percent = value_percent;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}

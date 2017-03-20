package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.ExercisesEntity;
import pe.com.dcgym.models.RoutinesEntity;

import java.sql.ResultSet;
import java.sql.SQLException;


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

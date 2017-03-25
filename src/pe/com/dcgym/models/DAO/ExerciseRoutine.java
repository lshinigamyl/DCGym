package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.ExercisesEntity;
import pe.com.dcgym.models.DTO.RoutinesEntity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ExerciseRoutine {
     
    private int id;
    private String comment;
    private String state;
    private int range;
    private int repeat;
    private int value_percent;
    private int sequence;
    private Exercise exercise;
    private Routine routine;


	 
	public ExerciseRoutine(){
	}

    public ExerciseRoutine(int id, String comment, String state, int range, int repeat, int value_percent, int sequence, Exercise exercise, Routine routine) {
        this.id = id;
        this.comment = comment;
        this.state = state;
        this.range = range;
        this.repeat = repeat;
        this.value_percent = value_percent;
        this.sequence = sequence;
        this.exercise = exercise;
        this.routine = routine;
    }

    public static ExerciseRoutine build(ResultSet resultSet, ExercisesEntity exercisesEntity, RoutinesEntity routinesEntity) {
        try {
            return new ExerciseRoutine( resultSet.getInt("id"),
                                        resultSet.getString("comment"),
                                        resultSet.getString("state"),
                                        resultSet.getInt("range"),
                                        resultSet.getInt("repeat"),
                                        resultSet.getInt("value_percent"),
                                        resultSet.getInt("sequence"),
                                        exercisesEntity.findById(resultSet.getInt("exercises_id")),
                                        routinesEntity.findById(resultSet.getInt("routines_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getValue_percent() {
        return value_percent;
    }

    public void setValue_percent(int value_percent) {
        this.value_percent = value_percent;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }
}

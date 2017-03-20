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
 * Created by Fjorsvartnir on 26/02/2017.
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

package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.ExerciseRoutine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ExercisesRoutinesEntity extends BaseEntity {
    private static String TABLE="exercises_routines";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private RoutinesEntity routinesEntity;
    private ExercisesEntity exercisesEntity;


    public List<ExerciseRoutine> findAll() {
        return this.findByCriteria(DEFAULT_SQL +" ORDER BY `routines_id`");
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
                    ExerciseRoutine exerciseRoutine = ExerciseRoutine.build(resultSet, getExercisesEntity(),getRoutinesEntity());
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



    public ExerciseRoutine create(ExerciseRoutine exerciseRoutine) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO `exercises_routines` (`comment`, `range`, `repeat`, `value_percent`, `sequence`, `exercise_id`, `routine_id`) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setString(1, exerciseRoutine.getComment());
            obj.setInt   (2, exerciseRoutine.getRange());
            obj.setInt   (3, exerciseRoutine.getRepeat());
            obj.setInt   (4, exerciseRoutine.getValue_percent());
            obj.setInt   (5, exerciseRoutine.getSequence());
            obj.setInt   (6, exerciseRoutine.getExercise().getId());
            obj.setInt   (7, exerciseRoutine.getExercise().getId());

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                exerciseRoutine.setId(super.getMaxId(TABLE));
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

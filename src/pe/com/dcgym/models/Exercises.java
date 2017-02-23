package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class Exercises {
    int idExercise;
    String nameExercise;
    String descriptionExercise;

    public Exercises() {
    }

    public Exercises(int idExercise, String nameExercise, String descriptionExercise) {
        this.idExercise = idExercise;
        this.nameExercise = nameExercise;
        this.descriptionExercise = descriptionExercise;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public String getNameExercise() {
        return nameExercise;
    }

    public void setNameExercise(String nameExercise) {
        this.nameExercise = nameExercise;
    }

    public String getDescriptionExercise() {
        return descriptionExercise;
    }

    public void setDescriptionExercise(String descriptionExercise) {
        this.descriptionExercise = descriptionExercise;
    }

}

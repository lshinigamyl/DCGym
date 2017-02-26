package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */

public class ExercisesRoutines {
     
    private String sequence;
    private String range;
    private String repeat;
    private String value_percent;
    private int exercises_id;
    private int routines_id;

    /**
     * @return the sequence
     */
	 
	 		public  ExercisesRoutines()	{
	}
	
		public  ExercisesRoutines( String sequence,  String range, String repeat, String value_percent,int exercises_id,int routines_id){
		
		this.sequence = sequence;
        this.range = range;
        this.repeat = repeat;
        this.value_percent = value_percent;
        this.exercises_id = exercises_id;
        this.routines_id = routines_id;
		}
	 
    public String getSequence() {
        return sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    /**
     * @return the range
     */
    public String getRange() {
        return range;
    }

    /**
     * @param range the range to set
     */
    public void setRange(String range) {
        this.range = range;
    }

    /**
     * @return the repeat
     */
    public String getRepeat() {
        return repeat;
    }

    /**
     * @param repeat the repeat to set
     */
    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    /**
     * @return the value_percent
     */
    public String getValue_percent() {
        return value_percent;
    }

    /**
     * @param value_percent the value_percent to set
     */
    public void setValue_percent(String value_percent) {
        this.value_percent = value_percent;
    }

    /**
     * @return the exercises_id
     */
    public int getExercises_id() {
        return exercises_id;
    }

    /**
     * @param exercises_id the exercises_id to set
     */
    public void setExercises_id(int exercises_id) {
        this.exercises_id = exercises_id;
    }

    /**
     * @return the routines_id
     */
    public int getRoutines_id() {
        return routines_id;
    }

    /**
     * @param routines_id the routines_id to set
     */
    public void setRoutines_id(int routines_id) {
        this.routines_id = routines_id;
    }

    /**
     * @return the id
     */
}

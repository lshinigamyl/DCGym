package pe.com.dcgym.models;

/**
 * ejercicios avance
 */
 public class Records {
     private CustomersRoutines  customersRoutines ;
    private String date;
    private String duration ;
    private String advance;
    private String commentary;

	
	public  Records()	{
	}
	
		public  Records(CustomersRoutines customersRoutines, String date,  String duration, String advance, String commentary){
		
		this.customersRoutines = customersRoutines;
        this.date = date;
        this.duration = duration;
        this.advance = advance;
        this.commentary = commentary;
		}
		
	
	
    /**
     * @return the customersRoutines
     */
    public int getCustomersRoutines() {
        return customersRoutines;
    }

    /**
     * @param customersRoutines the customers_routinesid to set
     */
    public void setCustomersRoutines(CustomersRoutines customersRoutines) {
        this.customersRoutines = customersRoutines;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the advance
     */
    public String getAdvance() {
        return advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(String advance) {
        this.advance = advance;
    }

    /**
     * @return the commentary
     */
    public String getCommentary() {
        return commentary;
    }

    /**
     * @param commentary the commentary to set
     */
    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

 }

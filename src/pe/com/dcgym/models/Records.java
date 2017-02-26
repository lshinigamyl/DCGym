package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
 public class Records {
     private int customers_routinesid;
    private String date;
    private String duration ;
    private String advance;
    private String commentary;

	
	public  Records()	{
	}
	
		public  Records(int customers_routinesid, String date,  String duration, String advance, String commentary){
		
		this.customers_routinesid = customers_routinesid;
        this.date = date;
        this.duration = duration;
        this.advance = advance;
        this.commentary = commentary;
		}
		
	
	
    /**
     * @return the customers_routinesid
     */
    public int getCustomers_routinesid() {
        return customers_routinesid;
    }

    /**
     * @param customers_routinesid the customers_routinesid to set
     */
    public void setCustomers_routinesid(int customers_routinesid) {
        this.customers_routinesid = customers_routinesid;
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
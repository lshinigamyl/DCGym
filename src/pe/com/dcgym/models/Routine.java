package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
 public class Routine {
     private int id;
    private String name;
    private String description;
    private String state;
	public  Routine()	{
	}
		public  Routine(int id, String name,  String description, String state){
		
		this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
   
		}
		
	
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }



 }

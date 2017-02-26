package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class CustomersRoutines {
    int id;
    String state;
    int customers_id;
    int routines_id;
    int employees_id;
 

    public CustomersRoutines(int id, String state,  int customers_id, int routines_id, int employees_id) {
        this.id = id;
        this.state = state;
        this.customers_id = customers_id;
        this.routines_id = routines_id;
        this.employees_id = employees_id;
   }

    public CustomersRoutines() {
    }

   
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

    /**
     * @return the customers_id
     */
    public int getCustomers_id() {
        return customers_id;
    }

    /**
     * @param customers_id the customers_id to set
     */
    public void setCustomers_id(int customers_id) {
        this.customers_id = customers_id;
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
     * @return the employees_id
     */
    public int getEmployees_id() {
        return employees_id;
    }

    /**
     * @param employees_id the employees_id to set
     */
    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }


}

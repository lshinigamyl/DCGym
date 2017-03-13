package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class CustomersMemberships {
    private int id;
    private int state;
    private Customer customer;
    private MembershipType membershipType;

    public CustomersMemberships() {
    }

    public CustomersMemberships(int id, int state, Customer customer, MembershipType membershipType) {
        this.id = id;
        this.state = state;
        this.customer = customer;
        this.membershipType = membershipType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }
}

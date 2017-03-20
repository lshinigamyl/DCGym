package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.CustomersEntity;
import pe.com.dcgym.models.DTO.MembershipsTypeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
Las clases en Java son básicamente una plantilla que
sirve para crear un objeto. Si imaginásemos las clases
en el mundo en el que vivimos, podríamos decir que la
clase “persona” es una plantilla sobre cómo debe ser un ser
humano. Todos y cada uno de nosotros, los seres humanos, somos
objetos de la clase “persona“, ya que todos somos personas. La clase
“persona” contiene la definición de un ser humano, mientras que cada
ser humano es una instancia u objeto de dicha clase.
 */

public class CustomerMembership {
    private int id;
    private String state;
    private Customer customer;
    private MembershipType membershipType;

    public CustomerMembership() {
    }

    public CustomerMembership(int id, String state, Customer customer, MembershipType membershipType) {
        this.setId(id);
        this.setState(state);
        this.setCustomer(customer);
        this.setMembershipType(membershipType);
    }
    public static CustomerMembership build(ResultSet resultSet, CustomersEntity customersEntity, MembershipsTypeEntity membershipsTypeEntity) {
        try {
            return new CustomerMembership(resultSet.getInt("id"),
                                        resultSet.getString("state"),
                                            customersEntity.findById(resultSet.getInt("customers_id")),
                                            membershipsTypeEntity.findById(resultSet.getInt("membership_types_id")));
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

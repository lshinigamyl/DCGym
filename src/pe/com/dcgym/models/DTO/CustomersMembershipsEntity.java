package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.CustomerMembership;
import pe.com.dcgym.models.DAO.MembershipType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase
 * como si se tratara de una clase cualquiera, cuando en realidad la relación de una superclase
 * con una subclase es más estrecha que con una clase externa. Por ello en diferentes lenguajes,
 * Java entre ellos, se usa un nivel de acceso intermedio que no es ni public ni private, sino
 * algo intermedio que se denomina como “acceso protegido”, expresado con la palabra clave protected, q
 * ue significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir,
 tanto a campos como a métodos o constructores. En el caso de métodos o constructores protegidos,
 estos serán visibles/utilizables por las subclases y otras clases del mismo package. El acceso
 protegido suele aplicarse a métodos o constructores, pero preferiblemente no a campos, para evitar d
 ebilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y
 private, con la salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un
 objeto de una subclase podremos acceder o invocar un campo o método declarado como protected, pero
 no podemos acceder o invocar a campos o métodos privados de una superclase. Declara un campo de una
 clase como protected y en un test crea un objeto de la subclase y trata de acceder a ese campo con una
 invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar
 ninguno de los modificadores public, private o protected). En la siguiente tabla puedes comparar los
 efectos de usar uno u otro tipo de declaración en cuanto a visibilidad de los campos o métodos:
 */
public class CustomersMembershipsEntity extends BaseEntity{
    private static String TABLE="customers_memberships";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private CustomersEntity customersEntity;
    private MembershipsTypeEntity membershipsTypeEntity;

    public List<CustomerMembership> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public CustomerMembership findById(int id) {
        List<CustomerMembership> customerMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customerMemberships != null ? customerMemberships.get(0) : null;
    }
/*
    public CustomerMembership findByName(String name) {
        List<CustomerMembership> customerMemberships = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customerMemberships.isEmpty() ? null : customerMemberships.get(0);
    }
*/
    private List<CustomerMembership> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<CustomerMembership> customerMemberships = new ArrayList<CustomerMembership>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    CustomerMembership customerMembership = CustomerMembership.build(resultSet,getCustomersEntity(),getMembershipsTypeEntity());
                    customerMemberships.add(customerMembership);
                }
                return customerMemberships;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public CustomerMembership create(String coment, String state, Customer customer, MembershipType membershipType) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
        String sql = "INSERT INTO "+TABLE+"(id, coment, state, people_id) VALUES(?,?,?,?)";
        try {
            PreparedStatement obj =  this.getConnection().prepareStatement(sql);

            obj.setInt   (1, (getMaxId(TABLE)+1));
            obj.setString(2, coment);
            obj.setInt   (3, customer.getId());
            obj.setInt   (4, membershipType.getId());

            int results = obj.executeUpdate(sql);
            if (results > 0) {
                CustomerMembership customerMembership = new CustomerMembership(getMaxId(TABLE), coment,customer,membershipType);
                return customerMembership;
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

    public boolean update(CustomerMembership customerMembership) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET state ='"+customerMembership.getState()+"', customers_id="+ customerMembership.getCustomer().getId()+" , membership_types_id="+customerMembership.getMembershipType().getId()+"   WHERE id = " + String.valueOf(customerMembership.getId())) > 0;
    }

    public CustomersEntity getCustomersEntity() {
        return customersEntity;
    }

    public void setCustomersEntity(CustomersEntity customersEntity) {
        this.customersEntity = customersEntity;
    }

    public MembershipsTypeEntity getMembershipsTypeEntity() {
        return membershipsTypeEntity;
    }

    public void setMembershipsTypeEntity(MembershipsTypeEntity membershipsTypeEntity) {
        this.membershipsTypeEntity = membershipsTypeEntity;
    }
}

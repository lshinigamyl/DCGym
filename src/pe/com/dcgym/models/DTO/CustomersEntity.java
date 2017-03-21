package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Customer;
import pe.com.dcgym.models.DAO.People;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una
 * subclase como si se tratara de una clase cualquiera, cuando en realidad la relación
 * de una superclase con una subclase es más estrecha que con una clase externa. Por
 * ello en diferentes lenguajes, Java entre ellos, se usa un nivel de acceso intermedio
 * que no es ni public ni private, sino algo intermedio que se denomina como “acceso protegido”,
 * expresado con la palabra clave protected, que significa que las subclases sí pueden tener acceso
 * al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir,
 tanto a campos como a métodos o constructores. En el caso de métodos o constructores protegidos,
 estos serán visibles/utilizables por las subclases y otras clases del mismo package. El acceso
 protegido suele aplicarse a métodos o constructores, pero preferiblemente no a campos, para evitar
 debilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y private,
 con la salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un objeto de una
 subclase podremos acceder o invocar un campo o método declarado como protected, pero no podemos acceder
 o invocar a campos o métodos privados de una superclase. Declara un campo de una clase como protected y
 en un test crea un objeto de la subclase y trata de acceder a ese campo con una invocación directa del
 tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar
 ninguno de los modificadores public, private o protected). En la siguiente tabla puedes comparar los
 efectos de usar uno u otro tipo de declaración en cuanto a visibilidad de los campos o métodos:
 */
public class CustomersEntity extends BaseEntity {
    private static final String TABLE = "customers";
    private static String DEFAULT_SQL = "SELECT * FROM "+TABLE;
    private PeopleEntity peopleEntity;

    public List<Customer> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Customer findById(int id) {
        List<Customer> customers = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id)+";");
        return customers.isEmpty() ?  null : customers.get(0);
    }
/*
    public Customer findByName(String name) {
        List<Customer> customers = this.findByCriteria(DEFAULT_SQL + " WHERE name = '" + name + "'");
        return customers.isEmpty() ? null : customers.get(0);
    }
*/
    private List<Customer> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Customer> customers = new ArrayList<Customer>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Customer customer = Customer.build(resultSet, getPeopleEntity());
                    customers.add(customer);
                }
                return customers;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Customer create(String coment, String state, People people) {
        //if (this.findByName(id) == null && this.getConnection() != null) {
            String sql = "INSERT INTO customers(id, coment, state, people_id) VALUES(?,?,?,?)";
            try {
                PreparedStatement obj =  this.getConnection().prepareStatement(sql);

                    obj.setInt   (1, (getMaxId(TABLE)+1));
                    obj.setString(2, coment);
                    obj.setString(3, state);
                    obj.setInt   (4, people.getId());

                int results = obj.executeUpdate(sql);
                if (results > 0) {
                    Customer customer = new Customer(getMaxId(TABLE), coment,state, people);
                    return customer;
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

    public boolean update(Customer customer) {
        return this.updateByCriteria("UPDATE "+TABLE+" SET coment = '" + customer.getComment() + "', state ='"+customer.getState()+"', people_id="+ customer.getPeople().getId()+"  WHERE id = " + String.valueOf(customer.getId())) > 0;
    }

    public PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }
}

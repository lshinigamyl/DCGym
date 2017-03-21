package pe.com.dcgym.models.DAO;

import pe.com.dcgym.models.DTO.CustomersRoutinesEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase como si se tratara de una clase cualquiera, cuando en realidad la relación de una superclase con una subclase es más estrecha que con una clase externa. Por ello en diferentes lenguajes, Java entre ellos, se usa un nivel de acceso intermedio que no es ni public ni private, sino algo intermedio que se denomina como “acceso protegido”, expresado con la palabra clave protected, que significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir, tanto a campos como a métodos o constructores. En el caso de métodos o constructores protegidos, estos serán visibles/utilizables por las subclases y otras clases del mismo package. El acceso protegido suele aplicarse a métodos o constructores, pero preferiblemente no a campos, para evitar debilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y private, con la salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un objeto de una subclase podremos acceder o invocar un campo o método declarado como protected, pero no podemos acceder o invocar a campos o métodos privados de una superclase. Declara un campo de una clase como protected y en un test crea un objeto de la subclase y trata de acceder a ese campo con una invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar ninguno de los modificadores public, private o protected). En la siguiente tabla puedes comparar los efectos de usar uno u otro tipo de declaración en cuanto a visibilidad de los campos o métodos:
 */
public class Record {
    private int id;
    private String date;
    private String duration;
    private String advance;
    private String coment;
    private CustomerRoutine customerRoutine;

    public Record(){

    }

    public Record(int id, String date, String duration, String advance, String coment, CustomerRoutine customerRoutine) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.advance = advance;
        this.coment = coment;
        this.customerRoutine = customerRoutine;
    }
    public static Record build(ResultSet resultSet, CustomersRoutinesEntity customersRoutinesEntity) {
        try {
            return new Record(resultSet.getInt("id"),resultSet.getString("date"),resultSet.getString("duration"),resultSet.getString("advance"),resultSet.getString("coment"),customersRoutinesEntity.findById(resultSet.getInt("customer_routine_id")));
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }

    public CustomerRoutine getCustomerRoutine() {
        return customerRoutine;
    }

    public void setCustomerRoutine(CustomerRoutine customerRoutine) {
        this.customerRoutine = customerRoutine;
    }
}



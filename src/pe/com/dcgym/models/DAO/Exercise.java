package pe.com.dcgym.models.DAO;

/**
 * Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase como si se tratara de una clase cualquiera, cuando en realidad la relación de una superclase con una subclase es más estrecha que con una clase externa. Por ello en diferentes lenguajes, Java entre ellos, se usa un nivel de acceso intermedio que no es ni public ni private, sino algo intermedio que se denomina como “acceso protegido”, expresado con la palabra clave protected, que significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir, tanto a campos como a métodos o constructores. En el caso de métodos o constructores protegidos, estos serán visibles/utilizables por las subclases y otras clases del mismo package. El acceso protegido suele aplicarse a métodos o constructores, pero preferiblemente no a campos, para evitar debilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y private, con la salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un objeto de una subclase podremos acceder o invocar un campo o método declarado como protected, pero no podemos acceder o invocar a campos o métodos privados de una superclase. Declara un campo de una clase como protected y en un test crea un objeto de la subclase y trata de acceder a ese campo con una invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar ninguno de los modificadores public, private o protected). En la siguiente tabla puedes comparar los efectos de usar uno u otro tipo de declaración en cuanto a visibilidad de los campos o métodos:
 */
public class Exercise {
    private int id;
    private String name;
    private String description;
    private String state;

    public Exercise() {
    }

    public Exercise(int id, String name, String description, String state) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setState(state);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

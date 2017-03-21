package pe.com.dcgym.models.DAO;

/**
 * Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase como si se tratara de una clase cualquiera, cuando en realidad la relación de una superclase con una subclase es más estrecha que con una clase externa. Por ello en diferentes lenguajes, Java entre ellos, se usa un nivel de acceso intermedio que no es ni public ni private, sino algo intermedio que se denomina como “acceso protegido”, expresado con la palabra clave protected, que significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir, tanto a campos como a métodos o constructores. En el caso de métodos o constructores protegidos, estos serán visibles/utilizables por las subclases y otras clases del mismo package. El acceso protegido suele aplicarse a métodos o constructores, pero preferiblemente no a campos, para evitar debilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y private, con la salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un objeto de una subclase podremos acceder o invocar un campo o método declarado como protected, pero no podemos acceder o invocar a campos o métodos privados de una superclase. Declara un campo de una clase como protected y en un test crea un objeto de la subclase y trata de acceder a ese campo con una invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar ninguno de los modificadores public, private o protected). En la siguiente tabla puedes comparar los efectos de usar uno u otro tipo de declaración en cuanto a visibilidad de los campos o métodos:
 */
public class People {
    int id;
    String name;
    String surName;
    String numDocument;
    String email;
    String dateBirth;
    String address;
    String cellphone;
    String telephone;
    String user;
    String pass;
    String state;

    public People(int id, String name, String surName, String numDocument, String email, String dateBirth, String address, String cellphone, String telephone, String user, String pass, String state) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.numDocument = numDocument;
        this.email = email;
        this.dateBirth = dateBirth;
        this.address = address;
        this.cellphone = cellphone;
        this.telephone = telephone;
        this.user = user;
        this.pass = pass;
        this.state = state;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(String numDocument) {
        this.numDocument = numDocument;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

package dcgym.models;

/**
 * admin ususario
 */
public class TrainingCenter {
    int id;
    String name;
    String ruc;
    String address;
    String telephone;
    String email;
    String description;
    String websites;
    String creditCard;
    String user;
    String pass;
    String state;

    public TrainingCenter() {
    }

    public TrainingCenter(int id, String name, String ruc, String address, String telephone, String email, String description, String websites, String creditCard, String user, String pass, String state) {
        this.id = id;
        this.name = name;
        this.ruc = ruc;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.websites = websites;
        this.creditCard = creditCard;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsites() {
        return websites;
    }

    public void setWebsites(String websites) {
        this.websites = websites;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
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

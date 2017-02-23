package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class TrainingCenters {
    int idTrainingCenters;
    String nameTrainingCenters;
    int ruc;
    String address;
    int telephone;
    String email;
    String description;
    String websites;
    String creditCard;
    String user;
    String pass;

    public TrainingCenters(int idTrainingCenters, String nameTrainingCenters, int ruc, String address, int telephone, String email, String description, String websites, String creditCard, String user, String pass) {
        this.idTrainingCenters = idTrainingCenters;
        this.nameTrainingCenters = nameTrainingCenters;
        this.ruc = ruc;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
        this.websites = websites;
        this.creditCard = creditCard;
        this.user = user;
        this.pass = pass;
    }

    public TrainingCenters() {
    }

    public int getIdTrainingCenters() {
        return idTrainingCenters;
    }

    public void setIdTrainingCenters(int idTrainingCenters) {
        this.idTrainingCenters = idTrainingCenters;
    }

    public String getNameTrainingCenters() {
        return nameTrainingCenters;
    }

    public void setNameTrainingCenters(String nameTrainingCenters) {
        this.nameTrainingCenters = nameTrainingCenters;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
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



}

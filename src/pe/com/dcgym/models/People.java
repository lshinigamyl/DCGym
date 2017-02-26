package pe.com.dcgym.models;

/**
 * tabla personas
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

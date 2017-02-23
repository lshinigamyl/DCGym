package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class People {
    int idPeople;
    String nameClient;
    String surName;
    String name;
    int numDocument;
    String email;
    String dateBirth;
    String address;
    int cellphone;
    int telephone;
    String user;
    String pass;

    public People(int idPeople, String nameClient, String surName, String name, int numDocument, String email, String dateBirth, String address, int cellphone, int telephone, String user, String pass) {
        this.idPeople = idPeople;
        this.nameClient = nameClient;
        this.surName = surName;
        this.name = name;
        this.numDocument = numDocument;
        this.email = email;
        this.dateBirth = dateBirth;
        this.address = address;
        this.cellphone = cellphone;
        this.telephone = telephone;
        this.user = user;
        this.pass = pass;
    }

    public People() {
    }

    public int getIdPeople() {
        return idPeople;
    }

    public void setIdPeople(int idPeople) {
        this.idPeople = idPeople;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumDocument() {
        return numDocument;
    }

    public void setNumDocument(int numDocument) {
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

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
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


}

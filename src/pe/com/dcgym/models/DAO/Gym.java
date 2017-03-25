package pe.com.dcgym.models.DAO;


public class Gym {
    int id;
    String name;
    String address;
    String telePhone;
    String cellPhone;
    String email;
    String description;
    String website;
    String username;
    String password;

    public Gym() {
    }

    public Gym(int id, String name, String address, String telePhone, String cellPhone, String email, String description, String website, String username, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telePhone = telePhone;
        this.cellPhone = cellPhone;
        this.email = email;
        this.description = description;
        this.website = website;
        this.username = username;
        this.password = password;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelePhone() {
        return telePhone;
    }

    public void setTelePhone(String telePhone) {
        this.telePhone = telePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

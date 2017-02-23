package pe.com.dcgym.models;

/**
 * Created by Fjorsvartnir on 23/02/2017.
 */
public class TypeEmployee {
    int idTypeEmployee;
    String nameTypeEmployee;
    String state;

    public TypeEmployee() {
    }

    public TypeEmployee(int idTypeEmployee, String nameTypeEmployee, String state) {
        this.idTypeEmployee = idTypeEmployee;
        this.nameTypeEmployee = nameTypeEmployee;
        this.state = state;
    }

    public int getIdTypeEmployee() {
        return idTypeEmployee;
    }

    public void setIdTypeEmployee(int idTypeEmployee) {
        this.idTypeEmployee = idTypeEmployee;
    }

    public String getNameTypeEmployee() {
        return nameTypeEmployee;
    }

    public void setNameTypeEmployee(String nameTypeEmployee) {
        this.nameTypeEmployee = nameTypeEmployee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

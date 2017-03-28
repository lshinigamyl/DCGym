package pe.com.dcgym.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import pe.com.dcgym.models.DAO.*;
import pe.com.dcgym.services.Company00Service;

import java.util.List;
import java.util.Map;


public class Company00Action extends ActionSupport implements SessionAware {


    private Map<String,Object> session;
    private String menuOption="";
    private List<CustomerGymMembershipType> customerGymMembershipTypes;
    private List<MembershipType> membershipTypes;
    private List<Employee> employees;
    private List<EmployeeType> employeeTypes;
    private List<GymMembershipTypes> gymMembershipTypes;
    private List<ExerciseRoutine> exerciseRoutines;
    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }

    @Override
    public String execute() throws Exception {
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                setMenuOption("index");
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }



    public String usuarios() throws Exception{
        String typeSession = session.get("typeSession").toString() ==null ? "" :(String) session.get("typeSession").toString();
        switch (typeSession){
            case "company":
                setMenuOption("usuario");
                Company00Service service = new Company00Service();
                Gym obj = (Gym)getSession().get("objsession");
                setCustomerGymMembershipTypes(service.findCustomerMembershipsByTrainingCenterId(obj.getId()));
                setGymMembershipTypes(service.findTrainingCenterMembership(String.valueOf(obj.getId())));
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }


    public String membresia() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                Gym obj = (Gym)getSession().get("objsession");
                Company00Service service = new Company00Service();
                setGymMembershipTypes(service.findTrainingCenterMembership(String.valueOf(obj.getId())));
                setMenuOption("membresia");
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }
    public String entrenadores() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                setMenuOption("entrenador");
                Gym obj = (Gym)getSession().get("objsession");
                Company00Service service = new Company00Service();
                setEmployees(service.findAllEmployee(String.valueOf(obj.getId())));
                setEmployeeTypes(service.findAllEmployeeTypes());
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }

    }
    public String rutinas() throws Exception{
        String typeSession = (String) session.get("typeSession");
        switch (typeSession){
            case "company":
                setMenuOption("rutina");
                Gym obj = (Gym)getSession().get("objsession");
                Company00Service service = new Company00Service();
                setExerciseRoutines(service.findAllRoutines(obj.getId()));
                return SUCCESS;
            case "client":
                return ERROR;
            default:
                return ERROR;
        }
    }
    public String getMenuOption() {
        return menuOption;
    }

    public void setMenuOption(String menuOption) {
        this.menuOption = menuOption;
    }
    public List<CustomerGymMembershipType> getCustomerGymMembershipTypes() {
        return customerGymMembershipTypes;
    }

    public void setCustomerGymMembershipTypes(List<CustomerGymMembershipType> customerGymMembershipTypes) {
        this.customerGymMembershipTypes = customerGymMembershipTypes;
    }

    public List<MembershipType> getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(List<MembershipType> membershipTypes) {
        this.membershipTypes = membershipTypes;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public List<GymMembershipTypes> getGymMembershipTypes() {
        return gymMembershipTypes;
    }

    public void setGymMembershipTypes(List<GymMembershipTypes> gymMembershipTypes) {
        this.gymMembershipTypes = gymMembershipTypes;
    }

    public List<EmployeeType> getEmployeeTypes() {
        return employeeTypes;
    }

    public void setEmployeeTypes(List<EmployeeType> employeeTypes) {
        this.employeeTypes = employeeTypes;
    }

    public List<ExerciseRoutine> getExerciseRoutines() {
        return exerciseRoutines;
    }

    public void setExerciseRoutines(List<ExerciseRoutine> exerciseRoutines) {
        this.exerciseRoutines = exerciseRoutines;
    }
}

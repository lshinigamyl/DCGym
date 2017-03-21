package pe.com.dcgym.models.DTO;

import pe.com.dcgym.models.DAO.Employee;
import pe.com.dcgym.models.DAO.EmployeeType;
import pe.com.dcgym.models.DAO.People;
import pe.com.dcgym.models.DAO.TrainingCenter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Decimos que podría considerarse demasiado restrictivo porque limita el acceso a una subclase como si se
 * tratara de una clase cualquiera, cuando en realidad la relación de una superclase con una subclase es más
 * estrecha que con una clase externa. Por ello en diferentes lenguajes, Java entre ellos, se usa un nivel de
 * acceso intermedio que no es ni public ni private, sino algo intermedio que se denomina como “acceso protegido”,
 * expresado con la palabra clave protected, que significa que las subclases sí pueden tener acceso al campo o método.

 El modificador de acceso protected puede aplicarse a todos los miembros de una clase, es decir, tanto a campos como
 a métodos o constructores. En el caso de métodos o constructores protegidos, estos serán visibles/utilizables por las
 subclases y otras clases del mismo package. El acceso protegido suele aplicarse a métodos o constructores, pero
 preferiblemente no a campos, para evitar debilitar el encapsulamiento. En ocasiones puntuales sí resulta de interés
 declarar campos con acceso protegido.

 La sintaxis para emplear esta palabra clave es análoga a la que usamos con las palabras public y private, con la
 salvedad de que protected suele usarse cuando se trabaja con herencia. Desde un objeto de una subclase podremos acceder
 o invocar un campo o método declarado como protected, pero no podemos acceder o invocar a campos o métodos privados de
 una superclase. Declara un campo de una clase como protected y en un test crea un objeto de la subclase y trata de acceder
 a ese campo con una invocación directa del tipo interino43.IdProfesor = “54-DY-87”.

 Java admite una variante más en cuanto a modificadores de acceso: la omisión del mismo (no declarar ninguno de los
 modificadores public, private o protected). En la siguiente tabla puedes comparar los efectos de usar uno u otro tipo
 de declaración en cuanto a visibilidad de los campos o métodos:
 */
public class EmployeesEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM employees";
    private TrainingCentersEntity trainingCentersEntity;
    private PeopleEntity peopleEntity;
    private EmployeeTypesEntity employeeTypesEntity;

    public List<Employee> findAll() {
        return this.findByCriteria(DEFAULT_SQL);
    }

    public Employee findById(int id) {
        List<Employee> customers = this.findByCriteria(DEFAULT_SQL + " WHERE id = " + String.valueOf(id));
        return customers != null ? customers.get(0) : null;
    }
/*

*/
    private List<Employee> findByCriteria(String sql) {
        if (this.getConnection() != null) {
            ArrayList<Employee> employees = new ArrayList<Employee>();
            try {
                ResultSet resultSet = this.getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Employee employee = Employee.build(resultSet,getTrainingCentersEntity(),getPeopleEntity(),getEmployeeTypesEntity());
                    employees.add(employee);
                }
                return employees;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public Employee create(String state, TrainingCenter trainingCenters, People people, EmployeeType employeeType) {
        //
        String sql = "INSERT INTO employees(id, state, training_centers_id, people_id, employee_types_id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement =  this.getConnection().prepareStatement(sql);

                preparedStatement.setInt   (1, (getMaxId("employees")+1));
                preparedStatement.setString(2, state);
                preparedStatement.setInt   (3, trainingCenters.getId());
                preparedStatement.setInt   (4, people.getId());
                preparedStatement.setInt   (3, employeeType.getId());

            int results = preparedStatement.executeUpdate(sql);
            if (results > 0) {
                Employee employee = new Employee(getMaxId("employees"),state, trainingCenters,people, employeeType);
                return employee;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //
        return null;
    }

    private int updateByCriteria(String sql) {
        if (this.getConnection() != null) {
            try {
                return this.getConnection().createStatement().executeUpdate(sql);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(int id) {
        return this.updateByCriteria("DELETE FROM employees WHERE id  = " + String.valueOf(id)) > 0;
    }

    public boolean update(Employee employee) {
        return this.updateByCriteria("UPDATE employees SET state ='"+employee.getState()+"', training_centers_id="+employee.getTrainingCenters().getId()+" ,people_id="+employee.getPeople().getId()+" ,employee_types_id="+employee.getEmployeeType().getId()+"  WHERE id = " + String.valueOf(employee.getId())) > 0;
    }

    private PeopleEntity getPeopleEntity() {
        return peopleEntity;
    }

    public void setPeopleEntity(PeopleEntity peopleEntity) {
        this.peopleEntity = peopleEntity;
    }

    private TrainingCentersEntity getTrainingCentersEntity() {
        return trainingCentersEntity;
    }

    public void setTrainingCentersEntity(TrainingCentersEntity trainingCentersEntity) {
        this.trainingCentersEntity = trainingCentersEntity;
    }

    public EmployeeTypesEntity getEmployeeTypesEntity() {
        return employeeTypesEntity;
    }

    public void setEmployeeTypesEntity(EmployeeTypesEntity employeeTypesEntity) {
        this.employeeTypesEntity = employeeTypesEntity;
    }
}

import java.util.ArrayList;
import java.util.List;

public abstract class Staff extends Person{
    private final String staffId;
    private double salary;
    private Role role;
    public Staff(int id, String firstName, String lastName, String dateOfBirth, String staffId, double salary, Role role) {
        super(id, firstName, lastName, dateOfBirth);
        this.staffId = staffId;
        this.salary = salary;
        this.role = role;
    }
    Role getRole(Role role){
        return role;
    }

    public String getStaffId() {
        return staffId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
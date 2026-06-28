import java.util.ArrayList;
import java.util.List;

public class TeachingStaff extends Staff{
    private final List<Course> listOfCourses;
    private final Department department;

    public TeachingStaff(int id, String firstName, String lastName, String dateOfBirth, String staffId, double salary, String role, List<Course> listOfCourses, Department department) {
        super(id, firstName, lastName, dateOfBirth, staffId, salary, role);
        this.listOfCourses = listOfCourses;
        this.department = department;
    }
    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public Department getDepartment() {
        return department;
    }
}

import java.util.List;

public class TeachingStaff extends Staff{
    List<Course> listOfCourses;
    Department department;

    public TeachingStaff(int id, String firstName, String lastName, String dateOfBirth, String getStaffId, String staffId, double salary, Role role, List<Course> listOfCourses, Department department) {
        super(id, firstName, lastName, dateOfBirth, getStaffId, staffId, salary, role);
        this.listOfCourses = listOfCourses;
        this.department = department;
    }
    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{
    private String teacherId;
    private final List<Course> listOfCourses;

    Teacher(int id, String firstName, String lastName, String DateOfBirth, String teacherId) {
        super(id, firstName, lastName, DateOfBirth);
        this.teacherId = teacherId;
        listOfCourses = new ArrayList<>();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }
}

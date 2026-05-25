import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student extends Person{
    private final UUID studentID;
    private final List<Course> enrolledCourses;
    private ClassLevel classlevel;

    public Student(int id, String firstName, String lastName, String dateOfBirth, UUID studentID, List<Course> enrolledCourses, ClassLevel classlevel) {
        super(id, firstName, lastName, dateOfBirth);
        this.studentID = UUID.randomUUID();
        this.enrolledCourses = new ArrayList<>();
        this.classlevel = classlevel;
    }

    public UUID getStudentID() {
        return studentID;
    }

    public ClassLevel getClasslevel() {
        return classlevel;
    }

    public void setClasslevel(ClassLevel classlevel) {
        this.classlevel = classlevel;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
}

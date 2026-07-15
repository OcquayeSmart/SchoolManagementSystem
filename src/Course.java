import java.util.ArrayList;
import java.util.List;

public class Course{
    private final String code;
    private final String title;
    private TeachingStaff teacher;
    private final List<Student> enrolledStudents;
    private final int creditUnits;

    public Course(int creditUnits, TeachingStaff teacher, String title, String code) {
        this.creditUnits = creditUnits;
        this.enrolledStudents = new ArrayList<>();
        this.teacher = teacher;
        this.title = title;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setTeacher(TeachingStaff teacher) {
        this.teacher = teacher;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getCreditUnits() {
        return creditUnits;
    }


}




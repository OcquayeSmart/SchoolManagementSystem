import java.util.ArrayList;
import java.util.List;

public class Course{
    private String code;
    private String title;
    private TeachingStaff teacher;
    private final List<Student> enrolledStudents;
    private int creditUnits;

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TeachingStaff getTeacher() {
        return teacher;
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

    public void setCreditUnits(int creditUnits) {
        this.creditUnits = creditUnits;
    }
}




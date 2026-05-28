import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student extends Person{
    private final UUID studentID;
    private final List<Course> enrolledCourses;
    private ClassLevel classLevel;
    private boolean hasGraduated = false;

    public Student(int id, String firstName, String lastName, String dateOfBirth, UUID studentID, List<Course> enrolledCourses, ClassLevel classlevel) {
        super(id, firstName, lastName, dateOfBirth);
        this.studentID = UUID.randomUUID();
        this.enrolledCourses = new ArrayList<>();
        this.classLevel = classlevel;
    }
    public boolean hasGraduated(){
        return true;
    }
    public void enrollInCourse(Course course){
        if(enrolledCourses.contains(course)){
            enrolledCourses.add(course);
        }
        else{
            System.out.println("Already enrolled in course");
        }
    }
    public void dropCourse(Course course){
        enrolledCourses.remove(course);
    }
    public UUID getStudentID() {
        return this.studentID;
    }

    public ClassLevel getClasslevel() {
        return classLevel;
    }
    public void setClassLevel(ClassLevel classlevel) {
        this.classLevel = classlevel;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public boolean isHasGraduated() {
        return hasGraduated;
    }

    public void setHasGraduated(boolean hasGraduated) {
        this.hasGraduated = hasGraduated;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Student extends Person{
    private final UUID studentID;
    private final List<Course> enrolledCourses;
    private final ClassLevel classLevel;
    private boolean hasGraduated = false;

    public Student(int id, String firstName, String lastName, String dateOfBirth, ClassLevel classlevel) {
        super(id, firstName, lastName, dateOfBirth);
        this.studentID = UUID.randomUUID();
        this.enrolledCourses = new ArrayList<>();
        this.classLevel = classlevel;
    }

    public void enrollInCourse(Course course){
        if(!enrolledCourses.contains(course)){
            enrolledCourses.add(course);
            System.out.println("Successfully enrolled in " + course.getTitle());
        }
        else{
            System.out.println("Already enrolled in " + course.getTitle());
        }
    }
    public void dropCourse(Course course){
        if(enrolledCourses.contains(course)){
            enrolledCourses.remove(course);
            System.out.println(course.getCode() + " has been removed");
        }
        else{
            System.out.println("Have not enrolled in course");
        }
    }
    public UUID getStudentID() {
        return this.studentID;
    }

    public ClassLevel getClasslevel() {
        return classLevel;
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

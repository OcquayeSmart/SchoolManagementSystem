import java.util.UUID;

public class Student extends Person{
    private final UUID studentID;
    private Course enrolledCourses;
    private String studentClass;

    Student(int id, String firstName, String lastName, String DateOfBirth, Course enrolledCourses, String studentClass){
        super(id, firstName, lastName, DateOfBirth);
        studentID = UUID.randomUUID();
        this.enrolledCourses = enrolledCourses;
        this.studentClass = studentClass;
    }
    //getters done here as well
    public UUID getStudentID(){
        return this.studentID;
    }
    public Course getEnrolledCourses(){
        return this.enrolledCourses;
    }
    public String getStudentClass(){
        return this.studentClass;
    }
    //setters here also complete// this is kinda repetitive
    public void setEnrolledCourses(Course enrolledCourses){
        this.enrolledCourses = enrolledCourses;
    }
    public void setStudentClass(String studentClass){
        this.studentClass = studentClass;
    }
}

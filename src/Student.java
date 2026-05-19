import java.util.ArrayList;
import java.util.UUID;

public class Student extends Person{
    private final UUID studentID;
    private ArrayList<Course> enrolledCourses;
    private Classes ClassLevel;

    Student(int id, String firstName, String lastName, String DateOfBirth, ArrayList<Course> enrolledCourses, Classes ClassLevel){
        super(id, firstName, lastName, DateOfBirth);
        studentID = UUID.randomUUID();
        this.enrolledCourses = enrolledCourses;
        this.ClassLevel = ClassLevel;
    }
    //getters done here as well
    public UUID getStudentID(){
        return this.studentID;
    }
    public ArrayList<Course> getEnrolledCourses(){
        return this.enrolledCourses;
    }
    public Classes getClassLevel(){
        return this.ClassLevel;
    }
    //setters here also complete// this is kinda repetitive
    public void setEnrolledCourses(ArrayList<Course> enrolledCourses){
        this.enrolledCourses = enrolledCourses;
    }
    public Classes setClassLevel(Classes studentClass){return this.ClassLevel;
    }
}

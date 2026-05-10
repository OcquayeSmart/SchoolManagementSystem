import java.util.ArrayList;

public class Course{
    private String code;
    private String title;
    private Teacher teacher;
    private Student enrolledStudents;
    private int creditUnits;

    Course(String ClassID, Classes desiredClassLevel, String code, String title, Teacher teacher,  int creditUnits, Student enrolledStudents) {
        this.code = code;
        this.title = title;
        this.teacher = teacher;
        this.enrolledStudents = enrolledStudents;
        this.creditUnits = creditUnits;
    }
//getters have been understood quite well
    public String getCode(){
        return this.code;
    }
    public String getTitle(){
        return this.title;
    }
    public int getCreditUnits(){
        return this.creditUnits;
    }
    public Teacher getTeacher(){
        return this.teacher;
    }
    public Student getEnrolledStudents(){
        return this.enrolledStudents;
    }
//now it is left with setters for me to crack
    public void setCode(String code){
        this.code = code;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public void setEnrolledStudents(Student enrolledStudents){
        this.enrolledStudents = enrolledStudents;
    }
    public void setCreditUnits(int creditUnits){
        this.creditUnits = creditUnits;
    }


}




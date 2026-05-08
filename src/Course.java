import java.util.ArrayList;

public class Course extends Person{
    private String code;
    private String title;
    private Teacher teacher;
    private ArrayList<String> enrolledStudents;
    private int creditUnits;

    Course(int id, String firstName, String lastName, String DateOfBirth, String ClassID, Classes desiredClassLevel, String code, String title, Teacher teacher,  int creditUnits) {
        super(id, firstName, lastName, DateOfBirth);
        this.code = code;
        this.title = title;
        this.teacher = teacher;
        enrolledStudents = new ArrayList<>();
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
    public ArrayList<String> getEnrolledStudents(){
        return enrolledStudents;
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
    public void setEnrolledStudents(ArrayList<String> enrolledStudents){
        this.enrolledStudents = enrolledStudents;
    }
    public void setCreditUnits(int creditUnits){
        this.creditUnits = creditUnits;
    }


}




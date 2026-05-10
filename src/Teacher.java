import java.util.ArrayList;

public class Teacher extends Person{
    private String teacherId;
    private ArrayList<String> listOfCourses;

    Teacher(int id, String firstName, String lastName, String DateOfBirth, String teacherId) {
        super(id, firstName, lastName, DateOfBirth);
        this.teacherId = teacherId;
        listOfCourses = new ArrayList<>();
    }
    //getters done
    public String getTeacherId(String teacherId){
        return teacherId;
    }
    public ArrayList<String> listOfCourses(ArrayList<String> listOfCourses){
        return listOfCourses;
    }
    //setters done here
    public void setTeacherId(String teacherId){
        this.teacherId = teacherId;
    }

}

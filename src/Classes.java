import java.util.ArrayList;

public class Classes{
    private String classID;
    //enums are automatically public static final
    private final ClassLevel classLevel;
    private final ArrayList<Student> listOfStudents;

    Classes(String ClassID, ClassLevel level, ArrayList<Student> listOfStudents){
        String classID;
        this.listOfStudents = listOfStudents;
        this.classLevel = level;
    }
    //getters
    public String getClassID(){
        return this.classID;
    }
    public ClassLevel getClassLevel(){
        return this.classLevel;
    }
    public ArrayList<Student> getList(){
        return this.listOfStudents;
    }

    //setters
    public void setClassID(String classID){
        this.classID = classID;
    }
    public void setlistOfStudents(ArrayList<Student> listOfStudents){
        listOfStudents = new ArrayList<>();
    }
}

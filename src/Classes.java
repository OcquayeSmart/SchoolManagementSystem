import java.util.ArrayList;

public class Classes extends Person{
    private String classID;
    private final ClassLevel classLevel;
    private static ArrayList<String> list;

    Classes(int id, String firstName, String lastName, String DateOfBirth, String ClassID, ClassLevel level){
        super(id, firstName, lastName, DateOfBirth);
        String classID;
        list = new ArrayList<>();
        this.classLevel = level;
    }
    //getters
    public String getClassID(){
        return this.classID;
    }
    public ClassLevel getClassLevel(){
        return this.classLevel;
    }
    public ArrayList<String> getList(){
        return list;
    }

    //setters
    public void setClassID(String classID){
        this.classID = classID;
    }
    public void setList(ArrayList<String> list){
        list = new ArrayList<>();
    }
}

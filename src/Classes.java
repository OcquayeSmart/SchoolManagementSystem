import java.util.ArrayList;

public class Classes{
    private String classID;
    //enums are automatically public static final
    private ClassLevel classLevel;
    private static ArrayList<String> list;

    Classes(String ClassID, ClassLevel level){
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

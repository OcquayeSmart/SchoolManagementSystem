import java.util.ArrayList;
import java.util.List;

public class Classes{
    private final String classID;
    private final ClassLevel classLevel;
    private final List<Student> listOfStudents;

    public Classes(String classID, ClassLevel classLevel, List<Student> listOfStudents) {
        this.classID = classID;
        this.classLevel = classLevel;
        this.listOfStudents = new ArrayList<>();
    }

    public String getClassID() {
        return classID;
    }
    public ClassLevel getClassLevel() {
        return classLevel;
    }
    public List<Student> getListOfStudents() {
        return listOfStudents;
    }
}

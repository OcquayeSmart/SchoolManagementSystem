import java.util.ArrayList;
import java.util.List;

public class Classes{
    private final String classID;
    private final ClassLevel classLevel;
    private final List<Student> listOfStudents;
    private final boolean hasStudent;

    public Classes(String classID, ClassLevel classLevel, List<Student> listOfStudents, boolean hasStudent) {
        this.classID = classID;
        this.classLevel = classLevel;
        this.listOfStudents = new ArrayList<>();
        this.hasStudent = hasStudent;
    }

    public void addStudent(Student student){
        listOfStudents.add(student);
    }
    public void removeStudent(Student student){
        listOfStudents.remove(student);
    }
    public boolean hasStudent(Student student){
        return listOfStudents.contains(student);
    }
    public int size(){
        return listOfStudents.size();
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

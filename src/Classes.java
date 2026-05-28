import java.util.ArrayList;
import java.util.List;

public class Classes{
    private final String classID;
    private final ClassLevel classLevel;
    private final List<Student> listOfStudents;
    private boolean hasStudent = false;

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
        hasStudent = listOfStudents.contains(student);
        return hasStudent;
    }
    public int size(){
        return listOfStudents.size();
    }
    public Classes findClassByLevel(ClassLevel level){

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

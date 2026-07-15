import java.util.ArrayList;
import java.util.List;

public class Classes{
    private final String classID;
    private final ClassLevel classLevel;
    private final List<Student> listOfStudents;
    private final boolean hasStudent;
    private final List<TeachingStaff> teachingStaffs;
    private final List<Course> courses = new ArrayList<>();

    public Classes(String classID, ClassLevel classLevel, List<Student> listOfStudents, boolean hasStudent, List<TeachingStaff> teachingStaffs) {
        this.classID = classID;
        this.classLevel = classLevel;
        this.teachingStaffs = teachingStaffs;
        this.listOfStudents = listOfStudents;
        this.hasStudent = hasStudent;
    }

    public void addStudent(Student student){
        if(!listOfStudents.contains(student)){
            listOfStudents.add(student);
        }
    }

    public void removeStudent(Student student){
        listOfStudents.remove(student);
    }
    public void addCourse(Course course){
        if(!courses.contains(course)){
            courses.add(course);
        }
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

    public List<Course> getCourses() {
        return courses;
    }
}

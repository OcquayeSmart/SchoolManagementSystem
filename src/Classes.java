import java.util.ArrayList;
import java.util.List;

public class Classes{
    private final String classID;
    private final ClassLevel classLevel;
    private final List<Student> listOfStudents;
    private final boolean hasStudent;
    private List<TeachingStaff> teachingStaffs;
    private List<Course> courses = new ArrayList<>();

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
    public boolean hasStudent(Student student){
        return listOfStudents.contains(student);
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
    public List<Student> getListOfStudents() {
        return listOfStudents;
    }
    public void setTeachingStaffs(List<TeachingStaff> teachingStaffs) {
        this.teachingStaffs = teachingStaffs;
    }

    public List<TeachingStaff> getTeachingStaffs() {
        return teachingStaffs;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

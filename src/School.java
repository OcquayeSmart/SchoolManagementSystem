import java.util.ArrayList;

public class School {
    private final String name;
    private final String address;
    private ArrayList<Student> listOfStudents;
    private ArrayList<Classes> listOfClasses;
    private ArrayList<Teacher> listOfTeachers;
    private ArrayList<Course> listOfCourses;


    public School(String name, String address, ArrayList<Student> listOfStudents, ArrayList<Classes> listOfClasses, ArrayList<Teacher> listOfTeachers, ArrayList<Course> listOfCourses) {
        this.name = name;
        this.address = address;
        this.listOfStudents = listOfStudents;
        this.listOfClasses = listOfClasses;
        this.listOfTeachers = listOfTeachers;
        this.listOfCourses = listOfCourses;
    }

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public ArrayList<Student> getListOfStudents(){
        return this.listOfStudents;
    }
    public ArrayList<Classes> getListOfClasses(){
        return this.listOfClasses;
    }
    public ArrayList<Teacher> getListOfTeachers(){
        return this.listOfTeachers;
    }
    public ArrayList<Course> getListOfCourses(){
        return listOfCourses;
    }
    public void setListOfStudents(ArrayList<Student> listOfStudents){
        this.listOfStudents = listOfStudents;
    }
    public void setListOfClasses(ArrayList<Classes> listOfClasses){
        this.listOfClasses = listOfClasses;
    }
    public void setListOfTeachers(ArrayList<Teacher> listOfTeachers){
        this.listOfTeachers = listOfTeachers;
    }
    public void setListOfCourses(ArrayList<Course> listOfCourses){
        this.listOfCourses = listOfCourses;
    }

}

import java.util.ArrayList;
import java.util.List;

public class School {
    private final String name;
    private final String address;
    private final List<Student> listOfStudents;
    private final List<Classes> listOfClasses;
    private final List<Teacher> listOfTeachers;
    private final List<Course> listOfCourses;

    public School(String name, String address, ArrayList<Student> listOfStudents, ArrayList<Classes> listOfClasses, ArrayList<Teacher> listOfTeachers, ArrayList<Course> listOfCourses) {
        this.name = name;
        this.address = address;
        this.listOfStudents = new ArrayList<>();
        this.listOfClasses = new ArrayList<>();
        this.listOfTeachers = new ArrayList<>();
        this.listOfCourses = new ArrayList<>();
    }

    //creating my unique methods here
    public void receiveApplication(Applicant applicant) {
        System.out.println("Application received");
    }

    public void reviewApplication(Applicant applicant) {
        if (applicant.getPreviousGPA() == null) {
            applicant.setApplicantStatus(ApplicationStatus.PENDING);
            System.out.println("Application pending");
        }
        //using the 5.0 GPA scale
        else if (applicant.getPreviousGPA() > 4.0) {
            applicant.setApplicantStatus(ApplicationStatus.ACCEPTED);
            System.out.println("Application accepted");
        } else if (applicant.getPreviousGPA() < 4.0) {
            applicant.setApplicantStatus(ApplicationStatus.REJECTED);
            System.out.println("Application rejected");
        } else {
            System.out.println(applicant.getPreviousGPA() + " is incorrect");
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public List<Classes> getListOfClasses() {
        return listOfClasses;
    }

    public List<Teacher> getListOfTeachers() {
        return listOfTeachers;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }
}
import java.time.LocalDate;
import java.util.Locale;

public class Applicant extends Person{
    private ClassLevel desiredClassLevel;
    private String previousSchool;
    private Double previousGPA;
    private LocalDate applicationDate;
    boolean submitApplication;
    private ApplicationStatus applicantStatus;


    public Applicant(int id, String firstName, String lastName, String dateOfBirth, ClassLevel desiredClassLevel, String previousSchool, Double previousGPA, LocalDate applicationDate, boolean submitApplication, ApplicationStatus applicantStatus) {
        super(id, firstName, lastName, dateOfBirth);
        this.desiredClassLevel = desiredClassLevel;
        this.previousSchool = previousSchool;
        this.previousGPA = previousGPA;
        this.applicationDate = applicationDate;
        this.submitApplication = false;
        this.applicantStatus = applicantStatus;
    }

    //methods created here
    public void submitApplication(Applicant applicant){
        System.out.println();
        submitApplication = true;
        System.out.println("Application submitted for " + getFirstName() + " " + getLastName());
    }
    public Student enroll(Student student){
        return new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getStudentID(), student.getEnrolledCourses(), student.getClasslevel());
    }

    public ClassLevel getDesiredClassLevel() {
        return desiredClassLevel;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public Double getPreviousGPA() {
        return previousGPA;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public boolean isSubmitApplication() {
        return submitApplication;
    }

    public ApplicationStatus getApplicantStatus() {
        return applicantStatus;
    }

    public void setDesiredClassLevel(ClassLevel desiredClassLevel) {
        this.desiredClassLevel = desiredClassLevel;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public void setPreviousGPA(Double previousGPA) {
        this.previousGPA = previousGPA;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setSubmitApplication(boolean submitApplication) {
        this.submitApplication = submitApplication;
    }

    public void setApplicantStatus(ApplicationStatus applicantStatus) {
        this.applicantStatus = applicantStatus;
    }
}

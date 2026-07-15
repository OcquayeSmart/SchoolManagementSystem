import java.time.LocalDate;
import java.util.Locale;

public class Applicant extends Person{
    private final ClassLevel desiredClassLevel;
    private final String previousSchool;
    private final Double previousGPA;
    private final LocalDate applicationDate;
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

    public Student enroll(){
        return new Student(this.getId(), this.getFirstName(), this.getLastName(), this.getDateOfBirth(),this.desiredClassLevel);
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public Double getPreviousGPA() {
        return previousGPA;
    }

    public ApplicationStatus getApplicantStatus() {
        return applicantStatus;
    }

    public void setApplicantStatus(ApplicationStatus applicantStatus) {
        this.applicantStatus = applicantStatus;
    }
}

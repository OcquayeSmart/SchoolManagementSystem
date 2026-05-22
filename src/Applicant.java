import java.time.LocalDate;
public class Applicant extends Person{
    private ClassLevel desiredClassLevel;
    private String previousSchool;
    private Double previousGPA;
    private LocalDate applicationDate;
    boolean submitApplication = true;
    private ApplicationStatus applicantStatus;
    boolean submitted;

    public Applicant(int id, String firstName, String lastName, String dateOfBirth, ClassLevel desiredClassLevel, String previousSchool, Double previousGPA, LocalDate applicationDate, boolean submitApplication, ApplicationStatus applicantStatus) {
        super(id, firstName, lastName, dateOfBirth);
        this.desiredClassLevel = desiredClassLevel;
        this.previousSchool = previousSchool;
        this.previousGPA = previousGPA;
        this.applicationDate = applicationDate;
        this.submitApplication = submitApplication;
        this.applicantStatus = applicantStatus;
    }

    //methods created here
    public void submitApplication(Applicant applicant){
        System.out.println();
        this.submitted = true;
        System.out.println("Application submitted for " + getFirstName() + " " + getLastName());
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

import java.time.LocalDate;

public class Applicant extends Person{
    private Classes desiredClassLevel;
    private String previousSchool;
    private double previousGPA;
    private LocalDate applicationDate;

    Applicant(int id, String firstName, String lastName, String DateOfBirth, String previousSchool, double previousGPA, LocalDate applicationDate, Classes DesiredClassLevel){
        super(id, firstName, lastName, DateOfBirth);
        this.previousSchool = previousSchool;
        this.previousGPA = previousGPA;
        applicationDate = LocalDate.now();
    }

    //getters
    public String getPreviousSchool(){
        return this.previousSchool;
    }
    public double getPreviousGPA(){
        return this.previousGPA;
    }
    public Classes getDesiredClassLevel(){
        return this.desiredClassLevel;
    }
    public LocalDate getApplicationDate(){
        return applicationDate;
    }
    //setters
    public void setPreviousSchool(String previousSchool){
        this.previousSchool = previousSchool;
    }
    public void setPreviousGPA(double previousGPA){
        this.previousGPA = previousGPA;
    }
    public void setApplicationDate(LocalDate applicationDate){
        this.applicationDate = applicationDate;
    }


}

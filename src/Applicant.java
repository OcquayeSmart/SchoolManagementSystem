import java.time.LocalDate;
import java.util.Scanner;

public class Applicant extends Person{
    static Scanner scanner = new Scanner(System.in);
    private ClassLevel desiredClassLevel;
    private String previousSchool;
    private double previousGPA;
    private LocalDate applicationDate;
    boolean submitApplication = true;

    Applicant(int id, String firstName, String lastName, String DateOfBirth, String previousSchool, double previousGPA, LocalDate applicationDate, ClassLevel DesiredClassLevel){
        super(id, firstName, lastName, DateOfBirth);
        this.previousSchool = previousSchool;
        this.previousGPA = previousGPA;
        applicationDate = LocalDate.now();
        this.desiredClassLevel = desiredClassLevel;
    }

    //methods created here
    public void submitApplication(Applicant applicant){
        while(submitApplication){
            System.out.println("Enter your desiredClassLevel: ");
            try{
                String userInput = scanner.nextLine().toLowerCase();
                desiredClassLevel = ClassLevel.valueOf(userInput);
            }
            catch(IllegalArgumentException e){
                System.out.println("*Try again*, you entered the wrong class level");
                System.out.println("Enter your desiredClassLevel: ");
            }
            System.out.println("Previous School: ");
            previousSchool = scanner.nextLine();
            System.out.println("Previous GPA: ");
            previousGPA = scanner.nextDouble();
            System.out.println("submitting application... ");
            submitApplication = false;
        }
    }
    public void applicationStatus(){

    }

    //getters
    public String getPreviousSchool(){
        return this.previousSchool;
    }
    public double getPreviousGPA(){
        return this.previousGPA;
    }
    public ClassLevel getDesiredClassLevel(){
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
    public void setDesiredClassLevel(ClassLevel desiredClassLevel){
        this.desiredClassLevel = desiredClassLevel;
    }

}

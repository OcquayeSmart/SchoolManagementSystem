import java.util.Scanner;

public class StudentMenu {
    private final School school;
    private final Scanner scanner;
    private final InputValidation inputValidation;

    public StudentMenu(School school, Scanner scanner, InputValidation inputValidation) {
        this.school = school;
        this.scanner = scanner;
        this.inputValidation = inputValidation;
    }
    public void show(User currentUser){
        boolean isRunning = true;
        String studentMenu = """

KNUST STUDENT PORTAL

1. View My Details
2. View Enrolled Courses
3. View Class Information
4. Change password
0. Logout

                """;
        while(isRunning){
            System.out.println(studentMenu);
            int userInput = inputValidation.checkInt();
            switch(userInput){
                case 1 -> viewMyDetails(currentUser);
                case 2 -> viewMyEnrolledCourses(currentUser);
                case 3 -> viewMyClass(currentUser);
                case 4 -> changePassword(currentUser);
                case 0 -> {System.out.println("Logged out");
                    isRunning = false;
                    school.run();}
                default -> System.out.println("Invalid choice. Please try again");
            }
        }
    }
    private void viewMyDetails(User user){
        Student student = (Student) user.getProfile();
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student ID: " + student.getStudentID());
        System.out.println("Date Of Birth: " + student.getDateOfBirth());
        System.out.println("Class level: " + student.getClasslevel());
        System.out.println("Graduated: " + student.isHasGraduated());
    }

    private void viewMyEnrolledCourses(User user){
        int myNumber = 1;
        Student student = (Student) user.getProfile();
        for(Course course: student.getEnrolledCourses()){
            System.out.println(myNumber + ". " + course.getCode() + " - " + course.getTitle() + " (" + course.getCreditUnits() + " credits)");
            myNumber++;
        }
    }

    private void viewMyClass(User user){
        int myNumber = 1;
        Student student = (Student) user.getProfile();
        Classes currentClass = school.findCurrentClass(student);

        if(currentClass == null){
            System.out.println("Dear Student");
            System.out.println("You have not been assigned to a class at this time.");
            return;
        }

        System.out.println("Class ID: " + currentClass.getClassID());
        System.out.println("Class Level: " + currentClass.getClassLevel());
        System.out.println("Number of students: " + currentClass.size());
        System.out.println("\nCourses in this class:");
        if(currentClass.getCourses().isEmpty()){
            System.out.println("You have not been assigned courses at this time.");
        } else {
            for(Course course : currentClass.getCourses()){
                System.out.println(myNumber + ". " +course.getCode() + " " + course.getTitle());
                myNumber++;
            }
        }
    }
    private void changePassword(User CurrentUser){
        System.out.println("CHANGE PASSWORD");
        System.out.println();
        System.out.print("Enter your current password: ");
        String currentPassword = scanner.nextLine();
        if(currentPassword.equals(CurrentUser.getPassword())){
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            System.out.print("Enter password again: ");
            String newPassword2 = scanner.nextLine();
            if(!newPassword2.equals(newPassword)){
                System.out.println("Passwords do not match");
            }
            else{
                CurrentUser.setPassword(newPassword2);
                System.out.println("Password changed successfully");
            }

        }
        else{
            System.out.println("Incorrect password");
        }
    }
}

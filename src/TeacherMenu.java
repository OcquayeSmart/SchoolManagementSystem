import java.util.Scanner;

public class TeacherMenu {
    private final School school;
    private final Scanner scanner;
    private final InputValidation inputValidation;

    public TeacherMenu(School school, Scanner scanner, InputValidation inputValidation) {
        this.school = school;
        this.scanner = scanner;
        this.inputValidation = inputValidation;
    }
    public void show(){
        boolean isRunning = true;
        String TeacherMenu = """


KNUST TEACHING STAFF PORTAL

1. View My Details
2. View My Courses
3. View Students In My Course
4. Change Password
0. Logout

                """;
        while(isRunning){
            System.out.println(TeacherMenu);
            int userInput = inputValidation.checkInt();
            switch(userInput){
                case 1 -> viewTeacherDetails(currentUser);
                case 2 -> viewMyCourses(currentUser);
                case 3 -> viewStudentsInMyCourse(currentUser);
                case 4 -> changePassword(currentUser);
                case 0 -> {System.out.println("Logged out");
                    isRunning = false;
                    run();}
                default -> System.out.println("Invalid choice. Please try again");
            }
        }
    }
    private void viewTeacherDetails(User user){
        TeachingStaff teachingStaff = (TeachingStaff) user.getProfile();
        System.out.println("Name: " + teachingStaff.getFirstName() + " " + teachingStaff.getLastName());
        System.out.println("Staff ID: " + teachingStaff.getStaffId());
        System.out.println("Department: " + teachingStaff.getDepartment());
        System.out.println("Salary: " + teachingStaff.getSalary());
    }

    private void viewMyCourses(User user){
        int myNumber = 1;
        TeachingStaff teachingStaff = (TeachingStaff) user.getProfile();
        for(Course course: teachingStaff.getListOfCourses()){
            System.out.println(myNumber + ". " + course.getCode() + " - " + course.getTitle() + " (" + course.getCreditUnits() + " credits)");
            myNumber++;
        }
    }

    private void viewStudentsInMyCourse(User user){
        int myNumber = 1;
        TeachingStaff teachingStaff = (TeachingStaff) user.getProfile();
        for(Course course: teachingStaff.getListOfCourses()){
            for(Student student: course.getEnrolledStudents()){
                System.out.println(myNumber + ". Full name: " + student.getFirstName() + " " + student.getLastName() + " ,ID: " + student.getId() + " ,Class level: "+ student.getClasslevel());
                myNumber++;
            }
        }
    }
}

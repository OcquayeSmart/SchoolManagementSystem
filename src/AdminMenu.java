import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {
    private final School school;
    private final Scanner scanner;
    private final InputValidation inputValidation;

    public AdminMenu(School school, Scanner scanner, InputValidation inputValidation) {
        this.school = school;
        this.scanner = scanner;
        this.inputValidation = inputValidation;
    }
    public void show(){
        boolean isRunning = true;
        String adminMenu = """

KNUST ADMIN CENTER

1.  Register Applicant
2.  View All Applicants
3.  Accept Applicant
4.  Reject Applicant
5.  View Rejected Applicants
6.  View all Students
7.  Add Teaching Staff
8.  Add Non-Teaching Staff
9.  View All Staff
10. Add Course
11. View All Courses
12. Add Class
13. View All Classes
0.  Logout
""";
        while(isRunning){
            System.out.println(adminMenu);
            int userChoice = inputValidation.checkInt();
            switch(userChoice){
                case 1 -> registerApplicant();
                case 2 -> viewAllApplicants();
                case 3 -> acceptApplicant();
                case 4 -> rejectApplicant();
                case 5 -> viewRejectedApplications();
                case 6 -> viewAllStudents();
                case 7 -> addTeachingStaff();
                case 8 -> addaNonTeachingStaff();
                case 9 -> viewAllStaff();
                case 10 -> addCourse();
                case 11 -> viewAllCourses();
                case 12 -> addClass();
                case 13 -> viewAllClasses();
                case 0 -> {
                    System.out.println("Logged out");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice. Please try again");
            }
        }
    }
    private void registerApplicant(){
        System.out.println("REGISTER NEW APPLICANT");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Previous School: ");
        String previousSchool = scanner.nextLine();

        Double previousGPA;
        System.out.print("Previous GPA: ");
        while(true){
            try{
                double value = Double.parseDouble(scanner.nextLine());
                if(value >= 1.00 && value <= 5.00){
                    previousGPA = value;
                    break;
                }
                else{
                    System.out.println("Invalid input, try again");
                    System.out.print("Input must be between 1.00 and 5.00: ");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Input is not a number, please enter a valid number");
                System.out.print("Try again: ");
            }
        }

        System.out.println("Select desired Class Level");
        ClassLevel[] levels = ClassLevel.values();
        for(int i = 0; i < levels.length; i++){
            System.out.println(i + 1 + ". " + levels[i]);
        }
        System.out.print("Enter number: ");
        int levelChoice = inputValidation.checkRange(1, levels.length);
        ClassLevel desiredLevel = levels[levelChoice - 1];

        int id = school.getApplicants().size() + 1;

        LocalDate applicationDate = LocalDate.now();

        Applicant applicant = new Applicant(id, firstName, lastName, dateOfBirth, desiredLevel, previousSchool, previousGPA, applicationDate, false ,ApplicationStatus.PENDING);
        System.out.println();

        school.getApplicants().add(applicant);
        school.receiveApplication(applicant);

        System.out.println("Applicant registered successfully");
    }

    private void viewAllApplicants(){
        int myNumber = 1;
        System.out.println("Applicant list");
        System.out.println();

        if (school.getApplicants().isEmpty()){
            System.out.println("No applicants found");
            return;
        }

        System.out.println("\tFirst name \tLast name \tDate of birth \t Previous school \t\t Previous GPA \t Application status");
        for(Applicant applicant:school.getApplicants()){
            System.out.println(myNumber + ". \t" + applicant.getFirstName() + " \t\t" + applicant.getLastName() + " \t" + applicant.getDateOfBirth() + " \t\t " + applicant.getPreviousSchool() + "\t " + applicant.getPreviousGPA() + "\t\t\t " + applicant.getApplicantStatus());
            myNumber++;
        }
    }

    private void acceptApplicant() {
        System.out.println("ACCEPTING APPLICANT");

        if(school.getApplicants().isEmpty()){
            System.out.println("No applicants in the system");
            return;
        }

        viewAllApplicants();

        System.out.print("Applicant first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Applicant last name: ");
        String lastName = scanner.nextLine();

        Applicant found = null;

        for(Applicant applicant:school.getApplicants()){
            if (applicant.getFirstName().equalsIgnoreCase(firstName) && applicant.getLastName().equalsIgnoreCase(lastName)){
                System.out.print("\rSearching for applicant");
                try{
                    Thread.sleep(900);
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.print("\rApplicant found");
                System.out.println();
                found = applicant;
                break;
            }
        }

        if(found == null){
            System.out.println("Application not found");
            return;
        }

        school.reviewApplication(found);

        if(found.getApplicantStatus() != ApplicationStatus.ACCEPTED){
            System.out.println(found.getFirstName() + " " +found.getLastName() +" does not meet the minimum requirements");
            school.getApplicants().remove(found);
            return;
        }

        viewAllClasses();
        System.out.println();
        System.out.print("Student ClassID: ");
        String classID = scanner.nextLine();

        Classes startingClass = null;
        for(Classes classes: school.getListOfClasses()){
            if(classes.getClassID().equalsIgnoreCase(classID)){
                startingClass = classes;
                break;
            }
        }

        if(startingClass == null){
            System.out.println("Class not found");
            return;
        }

        Student newStudent = school.admitEnrollAndPlaceInClass(found, startingClass);
        school.createUserAccount(newStudent, Role.STUDENT);
        school.getApplicants().remove(found);

        System.out.println(found.getFirstName() + found.getLastName() + " " + " accepted and enrolled successfully");
    }

    private void rejectApplicant(){
        System.out.println("REJECT APPLICATION");
        System.out.println();

        if(school.getApplicants().isEmpty()){
            System.out.println("No applicants in the system");
            return;
        }

        viewAllApplicants();

        System.out.print("Applicant first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Applicant last name: ");
        String lastName = scanner.nextLine();

        Applicant found = null;
        for(Applicant applicant:school.getApplicants()){
            if (applicant.getFirstName().equalsIgnoreCase(firstName) && applicant.getLastName().equalsIgnoreCase(lastName)){
                System.out.println();
                System.out.print("\rSearching for applicant");

                try{
                    Thread.sleep(900);
                }

                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }

                System.out.print("\rApplicant found");
                found = applicant;
                break;
            }
        }
        if(found == null){
            System.out.println("Application not found");
            return;
        }
        found.setApplicantStatus(ApplicationStatus.REJECTED);
        school.getRejectedApplicants().add(found);
        school.getApplicants().remove(found);
        System.out.println();
        System.out.println(found.getFirstName() + " " +found.getLastName() + " rejected successfully");
    }

    private void viewRejectedApplications(){
        int myNumber = 1;
        System.out.println("Rejected Applicant list");
        System.out.println();

        if(school.getRejectedApplicants().isEmpty()){
            System.out.println("No applicants rejected");
            return;
        }
        System.out.println("\tFirst name \tLast name \tDate of birth \t Previous school \t\t Previous GPA \t Application status");
        for(Applicant applicant:school.getRejectedApplicants()){
            System.out.println(myNumber + ". \t" + applicant.getFirstName() + "\t\t" + applicant.getLastName() + "\t\t" + applicant.getDateOfBirth() + "\t\t " + applicant.getPreviousSchool() + "\t " + applicant.getPreviousGPA() + "\t\t\t " + applicant.getApplicantStatus());
            myNumber++;
        }
    }

    private void viewAllStudents(){
        int myNumber = 1;
        System.out.println("Student list");
        System.out.println();

        if(school.getListOfStudents().isEmpty()){
            System.out.println("No student available");
            return;
        }

        System.out.println("\tFirst name \tLast name \tDate of birth");
        for(Student student:school.getListOfStudents()){
            System.out.println(myNumber + ". \t" + student.getFirstName() + " \t" + student.getLastName() + " \t" + student.getDateOfBirth());
            myNumber++;
        }
    }

    private void addTeachingStaff(){
        System.out.println("REGISTER NEW TEACHER");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Teacher's Salary(GHS): ");
        double salary = inputValidation.checkDouble();

        System.out.println("Select desired department");
        Department[] departments = Department.values();
        for(int i = 0; i < departments.length; i++){
            System.out.println(i + 1 + ". " + departments[i]);
        }
        System.out.print("Enter preferred number: ");
        int departmentChoice = inputValidation.checkRange(1, departments.length);
        Department department = departments[departmentChoice - 1];

        int id = school.getListOfTeachingStaff().size() + 1;

        String staffID = firstName + id;

        TeachingStaff teachingStaff = new TeachingStaff(id, firstName, lastName, dateOfBirth, staffID, salary, Role.TEACHER.name(), new ArrayList<>(), department);
        System.out.println();

        school.addStaff(teachingStaff);
        school.getListOfTeachingStaff().add(teachingStaff);
        school.createUserAccount(teachingStaff, Role.TEACHER);

        System.out.println("Teacher registered successfully");
    }

    private void addaNonTeachingStaff() {
        System.out.println("REGISTER NEW NON TEACHING STAFF");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Salary(GHS): ");
        double salary = inputValidation.checkDouble();

        System.out.print("Job title: ");
        String jobTitle = scanner.nextLine();

        System.out.print("Staff role: ");
        String role = scanner.nextLine();

        int id = school.getListOfNonTeachingStaff().size() + 1;

        String staffID = firstName + id;

        NonTeachingStaff nonteachingStaff = new NonTeachingStaff(id, firstName, lastName, dateOfBirth, staffID, salary, role, jobTitle);
        System.out.println();

        school.addStaff(nonteachingStaff);
        school.getListOfNonTeachingStaff().add(nonteachingStaff);

        System.out.println("Non teaching staff registered successfully");
    }

    private void viewAllStaff() {
        int myNumber = 1;
        System.out.println("Staff list");
        System.out.println();

        if (school.getListOfStaff().isEmpty()) {
            System.out.println("No staff members available");
            return;
        }
        System.out.println("\tFirst name \tLast name \tDate of birth");
        for (Staff staff : school.getListOfStaff()) {
            System.out.println(myNumber + ". \t" + staff.getFirstName() + " \t" + staff.getLastName() + " \t" + staff.getDateOfBirth());
            myNumber++;
        }
    }

    private void addCourse(){
        System.out.println("Add courses");

        System.out.print("Course code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Course title: ");
        String courseTitle = scanner.nextLine();

        System.out.print("Credit Units(hr): ");
        int creditUnits = inputValidation.checkInt();

        Course course = new Course(creditUnits, null, courseTitle, courseCode);
        school.getListOfCourses().add(course);

        System.out.println("Course added successfully");
    }

    private void viewAllCourses(){
        int myNumber = 1;
        System.out.println("List of courses");
        if(school.getListOfCourses().isEmpty()){
            System.out.println("No courses available");
            return;
        }
        System.out.println("\tCourse code \tTitle \tCredit hours");
        for(Course course: school.getListOfCourses()){
            System.out.println(myNumber + ". \t" + course.getCode() + " \t" + course.getTitle() + " \t" + course.getCreditUnits());
            myNumber++;
        }
    }

    private void addClass(){
        System.out.println("List of Classes");
        System.out.println();
        ClassLevel[] classLevel = ClassLevel.values();
        for(int i = 0; i < classLevel.length; i++){
            System.out.println(i + 1 + ". " + classLevel[i]);
        }

        System.out.println("Select desired class(1-" + classLevel.length + ")");
        int classLevelChoice = inputValidation.checkRange(1, classLevel.length);
        ClassLevel level = classLevel[classLevelChoice - 1];

        System.out.print("Class ID: ");
        String classID = scanner.nextLine();

        Classes classes = new Classes(classID, level, new ArrayList<>(), false, new ArrayList<>());
        addClass();
        System.out.println("Class added successfully");
    }
    private void viewAllClasses(){
        int myNumber = 1;
        System.out.println("List of Classes");
        System.out.println();

        if(school.getListOfClasses().isEmpty()){
            System.out.println("No classes available");
            return;
        }

        System.out.println("\tClass ID \tClass Level \tClass size");
        for(Classes classes:school.getListOfClasses()){
            System.out.println(myNumber + ". \t" + classes.getClassID() + " \t\t" + classes.getClassLevel() + " \t\t\t" + classes.size());
            myNumber++;
        }
    }
}

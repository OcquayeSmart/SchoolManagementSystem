import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class School {
    private final Scanner scanner = new Scanner(System.in);
    private final String name;
    private final String address;
    private final List<User> users;
    private final List<Student> listOfStudents;
    private final List<Classes> listOfClasses;
    private final List<TeachingStaff> listOfTeachingStaff;
    private final List<Course> listOfCourses;
    private final List<Staff> listOfStaff;
    private final List<Applicant> applicants;
    private final List<Applicant> rejectedApplicants;

    public School(String name, String address) {
        this.rejectedApplicants = new ArrayList<>();
        this.applicants = new ArrayList<>();
        this.users = new ArrayList<>();
        users.add(new User("admin", "admin123", Role.ADMIN, null));
        this.name = name;
        this.address = address;
        this.listOfStaff = new ArrayList<>();
        this.listOfStudents = new ArrayList<>();
        this.listOfClasses = new ArrayList<>();
        this.listOfTeachingStaff = new ArrayList<>();
        this.listOfCourses = new ArrayList<>();
    }

    private User login() {
        while(true){
            System.out.println("Welcome back! Please enter your credentials.");
            System.out.println("-----------------------------");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.println("-----------------------------");
            System.out.print("\n\rStatus: Verifying Credentials...");
            try{
                Thread.sleep(1600);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
            for(User user: users){
                if(user.getPassword().equals(password) && user.getUsername().equals(username)){
                    System.out.print("\rStatus: Access Granted!");
                    return user;
                }
            }
            System.out.println("\nInvalid Credentials. Try again\n");
        }
    }
    public void run(){
        User CurrentUser = login();
        switch(CurrentUser.getRole()){
            case ADMIN -> {
                System.out.println("\nWelcome " + CurrentUser.getUsername());
                adminMenu();
            }
            case STUDENT -> {
                System.out.println("\nWelcome " + CurrentUser.getUsername());
                studentMenu(CurrentUser);
            }
            case TEACHER -> {
                System.out.println("\nWelcome " + CurrentUser.getUsername());
                teacherMenu(CurrentUser);
            }
        }
    }

    private void teacherMenu(User currentUser) {
        boolean isRunning = true;
        String TeacherMenu = """

================================
    KNUST TEACHING STAFF PORTAL
================================
1. View My Details
2. View My Courses
3. View Students In My Course
0. Logout
================================
                """;
        while(isRunning){
            System.out.println(TeacherMenu);
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch(userInput){
                case 1 -> viewTeacherDetails(currentUser);
                case 2 -> viewMyCourses(currentUser);
                case 3 -> viewStudentsInMyCourse(currentUser);
                case 0 -> {System.out.println("Logged out");
                    isRunning = false;
                    run();}
                default -> System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private void studentMenu(User currentUser) {
        boolean isRunning = true;
        String studentMenu = """

================================
    KNUST STUDENT PORTAL
================================
1. View My Details
2. View Enrolled Courses
3. View Class Information
0. Logout
================================
                """;
        while(isRunning){
            System.out.println(studentMenu);
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch(userInput){
                case 1 -> viewMyDetails(currentUser);
                case 2 -> viewMyEnrolledCourses(currentUser);
                case 3 -> viewMyClass(currentUser);
                case 0 -> {System.out.println("Logged out");
                    isRunning = false;
                    run();}
                default -> System.out.println("Invalid choice. Please try again");
            }
        }
    }
    private void adminMenu() {
        boolean isRunning = true;
        String adminMenu = """

=============================
   KNUST - ADMIN CENTER
=============================
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
=============================
                        """;
        while(isRunning){
            System.out.println(adminMenu);
            int userChoice = scanner.nextInt();
            scanner.nextLine();
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
    //========================================================================
    //CREATING STUBS HERE, they ask the user for input and calls existing methods for logic
    //ADMIN

    private void registerApplicant(){
        System.out.println("========================================");
        System.out.println("        REGISTER NEW APPLICANT          ");
        System.out.println("========================================");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Previous School: ");
        String previousSchool = scanner.nextLine();

        System.out.print("Previous GPA: ");
        String gpaInput = scanner.nextLine();
        Double previousGPA = gpaInput.isEmpty() ? null : Double.parseDouble(gpaInput);

        System.out.println("Select desired Class Level");
        ClassLevel[] levels = ClassLevel.values();
        for(int i = 0; i < levels.length; i++){
            System.out.println(i + 1 + ". " + levels[i]);
        }
        System.out.print("Enter number: ");
        int levelChoice = Integer.parseInt(scanner.nextLine());
        ClassLevel desiredLevel = levels[levelChoice - 1];

        int id = applicants.size() + 1;

        LocalDate applicationDate = LocalDate.now();

        Applicant applicant = new Applicant(id, firstName, lastName, dateOfBirth, desiredLevel, previousSchool, previousGPA, applicationDate, false ,ApplicationStatus.PENDING);
        System.out.println();

        applicants.add(applicant);
        receiveApplication(applicant);

        System.out.println("    Applicant registered successfully   ");
        System.out.println("========================================");
    }

    private void viewAllApplicants(){
        int myNumber = 1;
        System.out.println("========================================");
        System.out.println("             Applicant list             ");
        System.out.println("========================================");
        System.out.println();

        if (applicants.isEmpty()){
            System.out.println("No applicants found");
            return;
        }

        System.out.println("\tFirst name \tLast name \tDate of birth \t Previous school \t Previous GPA \t Application status");
        for(Applicant applicant:applicants){
            System.out.println(myNumber + ". \t" + applicant.getFirstName() + " \t" + applicant.getLastName() + " \t" + applicant.getDateOfBirth() + " \t" + applicant.getPreviousSchool() + " \t" + applicant.getPreviousGPA() + " \t" + applicant.getApplicantStatus());
            myNumber++;
        }
        System.out.println("========================================");
    }

    private void acceptApplicant() {
        System.out.println("========================================");
        System.out.println("         ACCEPTING APPLICANT");
        System.out.println("========================================");
        System.out.println();

        if(applicants.isEmpty()){
            System.out.println("No applicants in the system");
            return;
        }

        viewAllApplicants();

        System.out.print("Applicant first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Applicant last name: ");
        String lastName = scanner.nextLine();

        Applicant found = null;

        for(Applicant applicant:applicants){
            if (applicant.getFirstName().equalsIgnoreCase(firstName) && applicant.getLastName().equalsIgnoreCase(lastName)){
                System.out.println("\rSearching for applicant");
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.println("\rApplicant found");
                found = applicant;
                break;
            }
        }

        if(found == null){
            System.out.println("Application not found");
            return;
        }

        reviewApplication(found);

        if(found.getApplicantStatus() != ApplicationStatus.ACCEPTED){
            System.out.println("Does not meet our requirements");
            applicants.remove(found);
            return;
        }

        viewAllClasses();
        System.out.print("Student ClassID: ");
        String classID = scanner.nextLine();

        Classes startingClass = null;
        for(Classes classes:listOfClasses){
            if(classes.getClassID().equalsIgnoreCase(classID)){
                startingClass = classes;
                break;
            }
        }

        if(startingClass == null){
            System.out.println("Class not found");
            return;
        }

        Student newStudent = admitEnrollAndPlaceInClass(found, startingClass);
        createUserAccount(newStudent, Role.STUDENT);
        applicants.remove(found);

        System.out.println("Student accepted and enrolled successfully");
        System.out.println("==========================================");
    }

    private void rejectApplicant(){
        System.out.println("========================================");
        System.out.println("           REJECT APPLICATION           ");
        System.out.println("========================================");
        System.out.println();

        if(applicants.isEmpty()){
            System.out.println("No applicants in the system");
            return;
        }

        viewAllApplicants();

        System.out.print("Applicant first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Applicant last name: ");
        String lastName = scanner.nextLine();

        Applicant found = null;
        for(Applicant applicant:applicants){
            if (applicant.getFirstName().equalsIgnoreCase(firstName) && applicant.getLastName().equalsIgnoreCase(lastName)){
                System.out.println("\rSearching for applicant");
                try{
                    Thread.sleep(1500);
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                System.out.println("\rApplicant found");
                found = applicant;
                break;
            }
        }
        if(found == null){
            System.out.println("Application not found");
            return;
        }
        found.setApplicantStatus(ApplicationStatus.REJECTED);
        rejectedApplicants.add(found);
        applicants.remove(found);

        System.out.println("     Student rejected successfully");
        System.out.println("==========================================");
    }

    private void viewRejectedApplications(){
        int myNumber = 1;
        System.out.println("========================================");
        System.out.println("         Rejected Applicant list        ");
        System.out.println("========================================");
        System.out.println();

        if(rejectedApplicants.isEmpty()){
            System.out.println("No applicants rejected");
            return;
        }
        System.out.println("\tFirst name \tLast name \tDate of birth \t Previous school \t Previous GPA \t Application status");
        for(Applicant applicant:rejectedApplicants){
            System.out.println(myNumber + ". \t" + applicant.getFirstName() + " \t" + applicant.getLastName() + " \t" + applicant.getDateOfBirth() + " \t" + applicant.getPreviousSchool() + " \t" + applicant.getPreviousGPA() + " \t" + applicant.getApplicantStatus());
            myNumber++;
        }
        System.out.println("========================================");
    }

    private void viewAllStudents(){
        int myNumber = 1;
        System.out.println("========================================");
        System.out.println("             Student list               ");
        System.out.println("========================================");
        System.out.println();
        System.out.println("\tFirst name \tLast name \tDate of birth");

        if(listOfStudents.isEmpty()){
            System.out.println("No student available");
        }
        for(Student student:listOfStudents){
            System.out.println(myNumber + ". \t" + student.getFirstName() + " \t" + student.getLastName() + " \t" + student.getDateOfBirth());
            myNumber++;
        }
        System.out.println("========================================");
    }

    private void addTeachingStaff(){
        System.out.println("========================================");
        System.out.println("          REGISTER NEW TEACHER          ");
        System.out.println("========================================");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Teacher's Salary(GHS): ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Select desired ");
        Department[] departments = Department.values();
        for(int i = 0; i < departments.length; i++){
            System.out.println(i + 1 + ". " + departments[i]);
        }
        System.out.print("Enter number: ");
        int departmentChoice = Integer.parseInt(scanner.nextLine());
        Department department = departments[departmentChoice - 1];

        int id = listOfTeachingStaff.size() + 1;

        String staffID = firstName + id;

        TeachingStaff teachingStaff = new TeachingStaff(id, firstName, lastName, dateOfBirth, staffID, salary, Role.TEACHER.name(), new ArrayList<>(), department);
        System.out.println();

        addStaff(teachingStaff);
        listOfTeachingStaff.add(teachingStaff);
        createUserAccount(teachingStaff, Role.TEACHER);

        System.out.println("     Teacher registered successfully    ");
        System.out.println("========================================");
    }

    private void addaNonTeachingStaff() {
        System.out.println("========================================");
        System.out.println("     REGISTER NEW NON TEACHING STAFF    ");
        System.out.println("========================================");

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Salary(GHS): ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Job title: ");
        String jobTitle = scanner.nextLine();

        System.out.print("Staff role: ");
        String role = scanner.nextLine();

        int id = listOfTeachingStaff.size() + 1;

        String staffID = firstName + id;

        NonTeachingStaff nonteachingStaff = new NonTeachingStaff(id, firstName, lastName, dateOfBirth, staffID, salary, role, jobTitle);
        System.out.println();

        addStaff(nonteachingStaff);

        System.out.println("    Non teaching staff registered successfully   ");
        System.out.println("=================================================");
    }

    private void viewAllStaff(){
        int myNumber = 1;
        System.out.println("========================================");
        System.out.println("             Staff list                 ");
        System.out.println("========================================");
        System.out.println();

        if(listOfStaff.isEmpty()){
            System.out.println("No staff members available");
            return;
        }
        System.out.println("\tFirst name \tLast name \tDate of birth");
        for(Staff staff:listOfStaff){
            System.out.println(myNumber + ". \t" + staff.getFirstName() + " \t" + staff.getLastName() + " \t" + staff.getDateOfBirth());
            myNumber++;
        }
        System.out.println("========================================");
        }

    private void addCourse(){
        System.out.println("========================================");
        System.out.println("               Add courses             ");
        System.out.println("========================================");
        System.out.println();

        System.out.println("Course code: ");
        String courseCode = scanner.nextLine();

        System.out.println("Course title: ");
        String courseTitle = scanner.nextLine();

        System.out.println("Credit Units(hr): ");
        int creditUnits = scanner.nextInt();
        scanner.nextLine();

        Course course = new Course(creditUnits, null, courseTitle, courseCode);
        listOfCourses.add(course);

        System.out.println("Course added successfully");
    }

    private void viewAllCourses(){
        int myNumber = 1;
        System.out.println("========================================");
        System.out.println("            List of courses             ");
        System.out.println("========================================");
        System.out.println();

        if(listOfCourses.isEmpty()){
            System.out.println("No courses available");
            return;
        }
        System.out.println("\tCourse code \tTitle \tCredit hours");
        for(Course course:listOfCourses){
            System.out.println(myNumber + ". \t" + course.getCode() + " \t" + course.getTitle() + " \t" + course.getCreditUnits());
            myNumber++;
        }
        System.out.println("========================================");
    }

    private void addClass(){
        System.out.println("List of Classes");
        System.out.println();
        ClassLevel[] classLevel = ClassLevel.values();
        for(int i = 0; i < classLevel.length; i++){
            System.out.println(i + 1 + ". " + classLevel[i]);
        }

        System.out.println("Select desired ");
        int classLevelChoice = Integer.parseInt(scanner.nextLine());
        ClassLevel level = classLevel[classLevelChoice - 1];

        System.out.println("Class ID: ");
        String classID = scanner.nextLine();

        Classes classes = new Classes(classID, level, new ArrayList<>(), false, new ArrayList<>());
        addClass(classes);
        System.out.println("========================");
        System.out.println("Class added successfully");
    }

    private void viewAllClasses(){
        int myNumber = 1;
        System.out.println("========================================");
        System.out.println("            List of Classes             ");
        System.out.println("========================================");
        System.out.println();

        if(listOfClasses.isEmpty()){
            System.out.println("No classes available");
            return;
        }

        System.out.println("\tClass ID \tClass Level \tClass size");
        for(Classes classes:listOfClasses){
            System.out.println(myNumber + ". \t" + classes.getClassID() + " \t" + classes.getClassLevel() + " \t" + classes.size());
            myNumber++;
        }
        System.out.println("========================================");
    }

    //STUDENT
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
        Classes currentClass = findCurrentClass(student);

        if(currentClass == null){
            System.out.println("You are not assigned to any class yet.");
            return;
        }

        System.out.println("Class ID: " + currentClass.getClassID());
        System.out.println("Class Level: " + currentClass.getClassLevel());
        System.out.println("Number of students: " + currentClass.size());
        System.out.println("\nCourses in this class:");
        if(currentClass.getCourses().isEmpty()){
            System.out.println("No courses assigned yet.");
        } else {
            for(Course course : currentClass.getCourses()){
                System.out.println(myNumber + ". " +course.getCode() + " " + course.getTitle());
                myNumber++;
            }
        }
    }
    //TEACHER
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
    //========================================================================
    public void createUserAccount(Person person, Role role){
        Random random = new Random();
        int uniqueNumber = random.nextInt(10, 99);
    //        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    //        String randomString = new java.util.Random().ints(10, 0, ALPHABET.length())
    //                .mapToObj(ALPHABET::charAt)
    //                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
    //                .toString() + uniqueNumber;
        String randomString = person.getFirstName().toLowerCase() + uniqueNumber;
        String defaultPassword = "pass123";
        User newUser = new User(randomString, defaultPassword, role, person);
        users.add(newUser);
        System.out.println("Username: " + randomString + "\nPassword: " + defaultPassword);
    }

    public void receiveApplication(Applicant applicant) {
        System.out.println(applicant.getFirstName()+" "+applicant.getLastName() + "'s application has been received" );
    }

    public void reviewApplication(Applicant applicant) {
        if (applicant.getPreviousGPA() == null) {
            applicant.setApplicantStatus(ApplicationStatus.PENDING);
            System.out.println("Application pending");
        }
        //using the 5.0 GPA scale
        else if (applicant.getPreviousGPA() >= 4.0) {
            applicant.setApplicantStatus(ApplicationStatus.ACCEPTED);
            System.out.println("Application accepted");
        } else {
            applicant.setApplicantStatus(ApplicationStatus.REJECTED);
            rejectedApplicants.add(applicant);
            System.out.println("Application rejected");
        }
    }

    public Classes findClassByLevel(ClassLevel level){
        for(Classes classes:listOfClasses){
            if(classes.getClassLevel() == level){
                return classes;
            }
        }
        return null;
    }

    public void removeStudent(Student student){
        listOfStudents.remove(student);
    }
    public void addStudent(Student student){
        if(!listOfStudents.contains(student)) {
            listOfStudents.add(student);
        }
    }

    public Student admitAndEnroll(Applicant applicant){
        Student newStudent = applicant.enroll();
        listOfStudents.add(newStudent);
        return newStudent;

    }
    public Student admitEnrollAndPlaceInClass(Applicant applicant, Classes startingClass){
        Student newStudent = admitAndEnroll(applicant);
        assignStudentToClass(newStudent, startingClass);
        return newStudent;
    }
    public void addStaff(Staff staff){
        if(!listOfStaff.contains(staff)){
            listOfStaff.add(staff);
        }
    }
    public void removeStaff(Staff staff){
        listOfStaff.remove(staff);
    }
    public void assignTeacher(TeachingStaff teacher, Course course){
        course.setTeacher(teacher);
    }
    public void addClass(Classes classes){
        if(!listOfClasses.contains(classes)){
            listOfClasses.add(classes);
        }
    }
    public void assignStudentToClass(Student student, Classes classes){
        classes.addStudent(student);
    }
    public Classes findCurrentClass(Student student){
        return findClassByLevel(student.getClasslevel());
    }
    public void promoteStudent(Student student){
        Classes currentClass = findCurrentClass(student);
        int nextClassOrdinal = currentClass.getClassLevel().ordinal() + 1;
        ClassLevel[] all_class_levels = ClassLevel.values();
        if(nextClassOrdinal < all_class_levels.length){
            Classes nextClass = findClassByLevel(all_class_levels[nextClassOrdinal]);
            assignStudentToClass(student, nextClass);
            currentClass.removeStudent(student);
        }
        else{
            student.setHasGraduated(true);
            currentClass.removeStudent(student);
        }
    }
    public void demoteStudent(Student student){
        Classes currentClass = findCurrentClass(student);
        int previousClassOrdinal = currentClass.getClassLevel().ordinal() - 1;

        ClassLevel[] all_class_levels = ClassLevel.values();
        if(previousClassOrdinal >= 0){
            Classes previousClass = findClassByLevel(all_class_levels[previousClassOrdinal]);
            assignStudentToClass(student, previousClass);
            currentClass.removeStudent(student);
        }
    }
    public void assignCoursesForClass(TeachingStaff teacher, Classes classes, List<Course> coursesForClass){
        for(Course course:coursesForClass){
            classes.addCourse(course);
            assignTeacher(teacher, course);
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

    public List<TeachingStaff> getListOfTeachingStaff() {
        return listOfTeachingStaff;
    }

    public List<Staff> getListOfStaff() {
        return listOfStaff;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }
}
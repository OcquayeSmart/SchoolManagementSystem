import java.time.LocalDate;
import java.util.*;

public class School {
    private final Scanner scanner;
    private final InputValidation inputValidation;
    private final List<User> users;
    private final UserLogins userLogins;
    private final String name;
    private final String address;
    private final List<Student> listOfStudents;
    private final List<Classes> listOfClasses;
    private final List<TeachingStaff> listOfTeachingStaff;
    private final List<NonTeachingStaff> listOfNonTeachingStaff;
    private final List<Course> listOfCourses;
    private final List<Staff> listOfStaff;
    private final List<Applicant> applicants;
    private final List<Applicant> rejectedApplicants;
    private final AdminMenu adminMenu;
    private final StudentMenu studentMenu;
    private final TeacherMenu teacherMenu;

    public School(String name, String address) {
        this.scanner = new Scanner(System.in);
        this.inputValidation = new InputValidation(scanner);
        this.listOfNonTeachingStaff = new ArrayList<>();
        this.rejectedApplicants = new ArrayList<>();
        this.applicants = new ArrayList<>();
        this.users = new ArrayList<>();
        users.add(new User("admin", "admin123", Role.ADMIN, null));
        this.userLogins = new UserLogins(scanner, users, inputValidation);
        this.name = name;
        this.address = address;
        this.listOfStaff = new ArrayList<>();
        this.listOfStudents = new ArrayList<>();
        this.listOfClasses = new ArrayList<>();
        this.listOfTeachingStaff = new ArrayList<>();
        this.listOfCourses = new ArrayList<>();
        this.adminMenu = new AdminMenu(this, scanner, inputValidation);
        this.studentMenu = new StudentMenu(this, scanner, inputValidation);
        this.teacherMenu = new TeacherMenu(this, scanner, inputValidation);
//        testData();
    }

    public void run(){
        User CurrentUser = userLogins.login();
        switch(CurrentUser.getRole()){
            case ADMIN -> {
                System.out.println("\nWelcome " + CurrentUser.getUsername());
                adminMenu.show();
            }
            case STUDENT -> {
                System.out.println("\nWelcome " + CurrentUser.getUsername());
                studentMenu.show(CurrentUser);
            }
            case TEACHER -> {
                System.out.println("\nWelcome " + CurrentUser.getUsername());
                teacherMenu.show(CurrentUser);
            }
        }
    }

    public void createUserAccount(Person person, Role role){
        Random random = new Random();
        int uniqueNumber = random.nextInt(10, 99);
        String randomString = person.getFirstName().toLowerCase() + uniqueNumber;
        String defaultPassword = "pass123";
        User newUser = new User(randomString, defaultPassword, role, person);
        users.add(newUser);
        System.out.println("Username: " + randomString + "\nPassword: " + defaultPassword);
    }

    public void receiveApplication(Applicant applicant) {
        System.out.println(applicant.getFirstName() + " " + applicant.getLastName() + "'s application has been received" );
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
    public List<User> getUsers() {
        return users;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    public List<NonTeachingStaff> getListOfNonTeachingStaff() {
        return listOfNonTeachingStaff;
    }

    public List<TeachingStaff> getListOfTeachingStaff() {
        return listOfTeachingStaff;
    }

    public List<Classes> getListOfClasses() {
        return listOfClasses;
    }

    public List<Applicant> getRejectedApplicants() {
        return rejectedApplicants;
    }

    public List<Staff> getListOfStaff() {
        return listOfStaff;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
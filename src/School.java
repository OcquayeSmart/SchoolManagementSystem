import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
    private final String name;
    private final String address;
    private final List<User> users = new ArrayList<>();
    private final List<Student> listOfStudents;
    private final List<Classes> listOfClasses;
    private final List<TeachingStaff> listOfTeachingStaff;
    private final List<Course> listOfCourses;
    private final List<Staff> listOfStaff;

    public School(String name, String address) {
        users.add(new User("admin", "admin123", Role.ADMIN, null));
        this.name = name;
        this.address = address;
        this.listOfStaff = new ArrayList<>();
        this.listOfStudents = new ArrayList<>();
        this.listOfClasses = new ArrayList<>();
        this.listOfTeachingStaff = new ArrayList<>();
        this.listOfCourses = new ArrayList<>();
    }

    //creating my unique methods here
    public User login(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Welcome back! Please enter your credentials.");
            System.out.println("-----------------------------");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.println("-----------------------------");
            System.out.println("\nStatus: Verifying Credentials...");
            for(User user: users){
                if(user.getPassword().equals(password) && user.getUsername().equals(username)){
                    System.out.println("Staus: Access Granted!");
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
                System.out.println("Welcome " + CurrentUser.getUsername());
                System.out.println("Loading admin role menu");
            }
            case STUDENT -> {
                System.out.println("Welcome " + CurrentUser.getUsername());
                System.out.println("Loading student role menu");
            }
            case TEACHER -> {
                System.out.println("Welcome " + CurrentUser.getUsername());
                System.out.println("loading teacher role menu");
            }
        }
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
            System.out.println("Application rejected");
        }
    }

    public Classes findClassByLevel(ClassLevel level){
        for(Classes clas:listOfClasses){
            if(clas.getClassLevel() == level){
                return clas;
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
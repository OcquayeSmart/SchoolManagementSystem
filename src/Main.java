import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        School school = new School("KNUST", "Kumasi, Ghana");
        school.run();
//        System.out.println("\t\t 1. SETUP SCHOOL ");
//        System.out.println();
//        School school = new School(
//                "Kwame Nkrumah University of Science and Technology",
//                "Private Mail Bag (PMB), University Post Office Kumasi, Ghana.",
//                new ArrayList<>(),   // students
//                new ArrayList<>(),   // classes
//                new ArrayList<>(),   // teaching staff
//                new ArrayList<>(),   // courses
//                new ArrayList<>()    // staff
//        );
//        System.out.println("School: " + school.getName() + " @ " + school.getAddress());
//
//
//        System.out.println("\n\t\t 2. ADD CLASSES ");
//        System.out.println();
//        Classes class1 = new Classes("CS1", ClassLevel.CLASS_1, new ArrayList<>(), false, new ArrayList<>());
//        Classes class2 = new Classes("CS2", ClassLevel.CLASS_2, new ArrayList<>(), false, new ArrayList<>());
//        Classes class3 = new Classes("CS3", ClassLevel.CLASS_3, new ArrayList<>(), false, new ArrayList<>());
//        Classes class4 = new Classes("CS4", ClassLevel.CLASS_4, new ArrayList<>(), false, new ArrayList<>());
//        Classes class5 = new Classes("CS5", ClassLevel.CLASS_5, new ArrayList<>(), false, new ArrayList<>());
//        Classes class6 = new Classes("CS6", ClassLevel.CLASS_6, new ArrayList<>(), false, new ArrayList<>());
//        Classes class7 = new Classes("CS7", ClassLevel.CLASS_7, new ArrayList<>(), false, new ArrayList<>());
//        Classes class8 = new Classes("CS8", ClassLevel.CLASS_8, new ArrayList<>(), false, new ArrayList<>());
//        school.addClass(class1);
//        school.addClass(class2);
//        school.addClass(class3);
//        school.addClass(class4);
//        school.addClass(class5);
//        school.addClass(class6);
//        school.addClass(class7);
//        school.addClass(class8);
//        school.addClass(class1); // duplicate -> should be ignored
//        System.out.println("Classes in school: " + school.getListOfClasses().size() + " (expected 8)");
//
//        // findClassByLevel
//        Classes found = school.findClassByLevel(ClassLevel.CLASS_2);
//        System.out.println("findClassByLevel(CLASS_2) -> " + (found != null ? found.getClassID() : "null"));
//
//        System.out.println("\n\t\t 3. ADD STAFF ");
//        System.out.println();
//        TeachingStaff teacher1 = new TeachingStaff(
//                100, "Ada", "Lovelace", "1990-12-10",
//                "T-100", 6900.00, "Lecturer",
//                new ArrayList<>(), Department.SCIENCES); //first staff teacher created
//        TeachingStaff teacher2 = new TeachingStaff(
//                200, "Vincent", "Essel", "1992-05-07",
//                "T-200", 8000.00, "Senior Lecturer",
//                new ArrayList<>(), Department.SCIENCES); //second staff teacher created
//        NonTeachingStaff janitor = new NonTeachingStaff(
//                300, "Rita", "Dankwah", "1985-03-02",
//                "NT-300", 2500.00, "Janitor", "Facilities");
//        school.addStaff(teacher1);
//        school.addStaff(teacher2);
//        school.addStaff(janitor);
//        school.addStaff(teacher1); // duplicate -> ignored
//        System.out.println("Staff in school: " + school.getListOfStaff().size() + " (expected 3)");
//        System.out.println("Teaching dept: " + teacher1.getDepartment() + ", salary: GHS" + teacher1.getSalary());
//        System.out.println("Teaching dept: " + teacher2.getDepartment() + ", salary: GHS" + teacher2.getSalary());
//        System.out.println("Janitor : " + janitor.getFirstName() +", salary: " + janitor.getSalary());
//
//        // 4. CREATE COURSES
//        //Used my actual course registration slip
//        System.out.println("\n\t\t 4. CREATE COURSES ");
//        System.out.println();
//        Course Calculus_II = new Course(3, null, "Calculus II", "MATH172");
//        Course Communication_Skills = new Course(2, null, "Communication Skills", "ENGL158");
//        Course Probability_and_Statistics_I = new Course(3, null, "Probability And Statistics I", "STAT166");
//        Course Elements_Of_Economics = new Course(3, null, "Elements Of Economics", "ECON152");
//        Course Discrete_Mathematics_For_Computer_Science_II = new Course(3, null, "Discrete Mathematics For Computer Science II", "CSM166");
//        Course Programming_With_C = new Course(3, null, "Programming With C", "CSM158");
//        Course Information_Technology_II = new Course(3, null, "Information Technology II", "CSM152");
//        System.out.println("Created course: " + Calculus_II.getCode() + ", " + Calculus_II.getCode());
//        System.out.println("Created course: " + Communication_Skills.getCode() + ", " + Communication_Skills.getCode());
//        System.out.println("Created course: " + Probability_and_Statistics_I.getCode() + ", " + Probability_and_Statistics_I.getCode());
//        System.out.println("Created course: " + Elements_Of_Economics.getCode() + ", " + Elements_Of_Economics.getCode());
//        System.out.println("Created course: " + Discrete_Mathematics_For_Computer_Science_II.getCode() + ", " + Discrete_Mathematics_For_Computer_Science_II.getCode());
//        System.out.println("Created course: " + Programming_With_C.getCode() + ", " + Programming_With_C.getCode());
//        System.out.println("Created course: " + Information_Technology_II.getCode() + ", " + Information_Technology_II.getCode());
//
//        // 5. APPLICATIONS + REVIEW (tests Applicant + reviewApplication)
//        System.out.println("\n\t\t 5. APPLICATIONS ");
//        System.out.println();
//        Applicant Smart = new Applicant(1, "Smart", "Ocquaye", "2007-05-02",
//                ClassLevel.CLASS_1, "Aggrey Memorial SHS", 4.5, LocalDate.now(), false, null);
//        Applicant Bruce = new Applicant(2, "Bruce", "Lamptey", "2008-06-15",
//                ClassLevel.CLASS_1, "Presec Legon SHS", 3.0, LocalDate.now(), false, null);
//        Applicant Caroline = new Applicant(3, "Caroline", "Levite", "2010-07-20",
//                ClassLevel.CLASS_1, "Aburi Girls SHS", null, LocalDate.now(), false, null);
//
//        school.receiveApplication(Smart);
//        Smart.submitApplication(Smart);
//
//        school.reviewApplication(Smart); // 4.5 -> ACCEPTED
//        school.reviewApplication(Bruce);   // 3.0 -> REJECTED
//        school.reviewApplication(Caroline); // null -> PENDING
//        System.out.println("Smart's status: " + Smart.getApplicantStatus());
//        System.out.println("Bruce's status:   " + Bruce.getApplicantStatus());
//        System.out.println("Caroline's status: " + Caroline.getApplicantStatus());
//
//        //6. ADMIT + ENROLL + PLACE IN CLASS
//        System.out.println("\n\t\t 6. ADMIT & ENROLL ");
//        System.out.println();
//        Student StudentSmart = school.admitEnrollAndPlaceInClass(Smart, class1);
//        System.out.println("Admitted student: " + StudentSmart.getFirstName()
//                + " (id " + StudentSmart.getStudentID() + ")");
//        System.out.println("Students in school: " + school.getListOfStudents().size());
//        System.out.println("Class1 size: " + class1.size() + " (expected 1)");
//        System.out.println("Class1 has Smart? " + class1.hasStudent(StudentSmart)); //finally using that hasStudent boolean
//
//        // 7. ASSIGN COURSES + TEACHER TO A CLASS
//        System.out.println("\n\t\t 7. ASSIGN COURSES/TEACHER ");
//        List<Course> classCourses = new ArrayList<>();
//        System.out.println();
//        classCourses.add(Calculus_II);
//        classCourses.add(Communication_Skills);
//        classCourses.add(Discrete_Mathematics_For_Computer_Science_II);
//        classCourses.add(Information_Technology_II);
//        classCourses.add(Probability_and_Statistics_I);
//        classCourses.add(Programming_With_C);
//        classCourses.add(Elements_Of_Economics);
//        school.assignCoursesForClass(teacher1, class1, classCourses);
//        System.out.println("Class1 courses: " + class1.getCourses().size() + " (expected 7)");
//        System.out.println("Calculus teacher now: " + (Calculus_II.getTeacher() != null
//                ? Calculus_II.getTeacher().getFirstName() : "null"));
//
//      // 8. STUDENT ENROLL/DROP COURSES
//        System.out.println("\n\t\t 8. STUDENT COURSE ENROLLMENT ");
//        System.out.println();
//        StudentSmart.enrollInCourse(Calculus_II);     // success
//        StudentSmart.enrollInCourse(Programming_With_C);
//        StudentSmart.enrollInCourse(Probability_and_Statistics_I);
//        StudentSmart.enrollInCourse(Discrete_Mathematics_For_Computer_Science_II);
//        StudentSmart.enrollInCourse(Elements_Of_Economics);     // already enrolled
//        StudentSmart.dropCourse(Communication_Skills);      // not enrolled yet
//        StudentSmart.enrollInCourse(Communication_Skills);  // success
//        StudentSmart.dropCourse(Communication_Skills);      // removed
//        System.out.println("Alice enrolled courses: " + StudentSmart.getEnrolledCourses().size() + " (expected 1)");
//
//        // 9. FIND CURRENT CLASS + PROMOTE
//        System.out.println("\n\t\t 9. PROMOTE ");
//        System.out.println();
//        Classes current = school.findCurrentClass(StudentSmart);
//        System.out.println("Smart's current class: " + (current != null ? current.getClassID() : "null"));
//        school.promoteStudent(StudentSmart); // CLASS_1 -> CLASS_2
//        System.out.println("After promote -> Class1 size: " + class1.size()
//                + ", Class2 size: " + class2.size());
//        // NOTE: promoteStudent moves the student between class lists but does not
//        // update the student's own classLevel field, so we sync it for further demos.
//        StudentSmart.setClassLevel(ClassLevel.CLASS_2);
//
//
//        // 10. DEMOTE
//        System.out.println("\n\t\t 10. DEMOTE ");
//        System.out.println();
//        school.demoteStudent(StudentSmart); // CLASS_2 -> CLASS_1
//        System.out.println("After demote -> Class2 size: " + class2.size()
//                + ", Class1 size: " + class1.size());
//        StudentSmart.setClassLevel(ClassLevel.CLASS_1);
//
//
//        // 11. GRADUATION (promoted from the highest class level)
//        System.out.println("\n\t\t 11. GRADUATION ");
//        System.out.println();
//        Applicant grad = new Applicant(4, "Smart", "Ocquaye", "2007-05-02",
//                ClassLevel.CLASS_8, "Aggrey Memorial Zion SHS", 4.3, LocalDate.now(), false, null);
//        Student gradStudent = school.admitEnrollAndPlaceInClass(grad, class8); //it would be nice to use the DateTimeFormatter instead
//        System.out.println("Smart in CLASS_8, graduated? " + gradStudent.isHasGraduated());
//        school.promoteStudent(gradStudent); // top level -> graduates
//        System.out.println("After promote -> graduated? " + gradStudent.isHasGraduated()
//                + ", Class8 size: " + class8.size());
//
//
//        // 12. PERSON FIELDS (inherited getters/setters) + REMOVE
//        System.out.println("\n\t\t 12. PERSON FIELDS + REMOVE ");
//        System.out.println();
//        StudentSmart.setLastName("Ocquaye(Updated)");
//        System.out.println("Smart full name: " + StudentSmart.getFirstName() + " " + StudentSmart.getLastName());
//        System.out.println("Smart DOB: " + StudentSmart.getDateOfBirth());
//
//        school.removeStudent(StudentSmart);
//        school.removeStaff(janitor);
//        System.out.println("Students remaining after removal: " + school.getListOfStudents().size());
//        System.out.println("Staff remaining after removal: " + school.getListOfStaff().size());
//        System.out.println();
//        System.out.println("\n\t\tTHANK YOU");
    }
}

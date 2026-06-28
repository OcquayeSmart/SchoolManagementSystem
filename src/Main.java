import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ============================================================
        // 1. CREATE THE SCHOOL
        // ============================================================
        System.out.println("===== 1. SETUP SCHOOL =====");
        School school = new School(
                "Greenfield Academy",
                "12 School Road",
                new ArrayList<>(),   // students
                new ArrayList<>(),   // classes
                new ArrayList<>(),   // teaching staff
                new ArrayList<>(),   // courses
                new ArrayList<>()    // staff
        );
        System.out.println("School: " + school.getName() + " @ " + school.getAddress());

        // ============================================================
        // 2. CREATE CLASSES (one per level we care about)
        // ============================================================
        System.out.println("\n===== 2. ADD CLASSES =====");
        Classes class1 = new Classes("C1", ClassLevel.CLASS_1, new ArrayList<>(), false, new ArrayList<>());
        Classes class2 = new Classes("C2", ClassLevel.CLASS_2, new ArrayList<>(), false, new ArrayList<>());
        Classes class3 = new Classes("C3", ClassLevel.CLASS_3, new ArrayList<>(), false, new ArrayList<>());
        Classes class8 = new Classes("C8", ClassLevel.CLASS_8, new ArrayList<>(), false, new ArrayList<>());
        school.addClass(class1);
        school.addClass(class2);
        school.addClass(class3);
        school.addClass(class8);
        school.addClass(class1); // duplicate -> should be ignored
        System.out.println("Classes in school: " + school.getListOfClasses().size() + " (expected 4)");

        // findClassByLevel
        Classes found = school.findClassByLevel(ClassLevel.CLASS_2);
        System.out.println("findClassByLevel(CLASS_2) -> " + (found != null ? found.getClassID() : "null"));

//         ============================================================
//         3. CREATE STAFF (teaching + non-teaching)
//         ============================================================
        System.out.println("\n===== 3. ADD STAFF =====");
        TeachingStaff teacher = new TeachingStaff(
                100, "Ada", "Lovelace", "1990-12-10",
                "T-100", 5000.0, "Lecturer",
                new ArrayList<>(), Department.SCIENCES);
        NonTeachingStaff janitor = new NonTeachingStaff(
                200, "Sam", "Cleaner", "1985-03-02",
                "N-200", 2000.0, "Janitor", "Facilities");
        school.addStaff(teacher);
        school.addStaff(janitor);
        school.addStaff(teacher); // duplicate -> ignored
        System.out.println("Staff in school: " + school.getListOfStaff().size() + " (expected 2)");
        System.out.println("Teacher dept: " + teacher.getDepartment() + ", salary: " + teacher.getSalary());

        // ============================================================
        // 4. CREATE COURSES
        // ============================================================
        System.out.println("\n===== 4. CREATE COURSES =====");
        Course math = new Course(3, null, "Mathematics", "MTH101");
        Course english = new Course(2, null, "English", "ENG101");
        System.out.println("Created courses: " + math.getCode() + ", " + english.getCode());

//        // ============================================================
//        // 5. APPLICATIONS + REVIEW (tests Applicant + reviewApplication)
//        // ============================================================
        System.out.println("\n===== 5. APPLICATIONS =====");
        Applicant alice = new Applicant(1, "Alice", "Stone", "2010-05-01",
                ClassLevel.CLASS_1, "Sunny Primary", 4.5, LocalDate.now(), false, null);
        Applicant bob = new Applicant(2, "Bob", "Reed", "2010-06-15",
                ClassLevel.CLASS_1, "Sunny Primary", 3.0, LocalDate.now(), false, null);
        Applicant carol = new Applicant(3, "Carol", "Nash", "2010-07-20",
                ClassLevel.CLASS_1, "Sunny Primary", null, LocalDate.now(), false, null);

        school.receiveApplication(alice);
        alice.submitApplication(alice);

        school.reviewApplication(alice); // 4.5 -> ACCEPTED
        school.reviewApplication(bob);   // 3.0 -> REJECTED
        school.reviewApplication(carol); // null -> PENDING
        System.out.println("Alice status: " + alice.getApplicantStatus());
        System.out.println("Bob status:   " + bob.getApplicantStatus());
        System.out.println("Carol status: " + carol.getApplicantStatus());

//        // ============================================================
        // 6. ADMIT + ENROLL + PLACE IN CLASS
        // ============================================================
        System.out.println("\n===== 6. ADMIT & ENROLL =====");
        Student aliceStudent = school.admitEnrollAndPlaceInClass(alice, class1);
        System.out.println("Admitted student: " + aliceStudent.getFirstName()
                + " (id " + aliceStudent.getStudentID() + ")");
        System.out.println("Students in school: " + school.getListOfStudents().size());
        System.out.println("Class1 size: " + class1.size() + " (expected 1)");
        System.out.println("Class1 has Alice? " + class1.hasStudent(aliceStudent));

//        // ============================================================
//        // 7. ASSIGN COURSES + TEACHER TO A CLASS
//        // ============================================================
        System.out.println("\n===== 7. ASSIGN COURSES/TEACHER =====");
        List<Course> classCourses = new ArrayList<>();
        classCourses.add(math);
        classCourses.add(english);
        school.assignCoursesForClass(teacher, class1, classCourses);
        System.out.println("Class1 courses: " + class1.getCourses().size() + " (expected 2)");
        System.out.println("Math teacher now: " + (math.getTeacher() != null
                ? math.getTeacher().getFirstName() : "null"));

//        // ============================================================
//        // 8. STUDENT ENROLL/DROP COURSES
//        // ============================================================
        System.out.println("\n===== 8. STUDENT COURSE ENROLLMENT =====");
        aliceStudent.enrollInCourse(math);     // success
        aliceStudent.enrollInCourse(math);     // already enrolled
        aliceStudent.dropCourse(english);      // not enrolled yet
        aliceStudent.enrollInCourse(english);  // success
        aliceStudent.dropCourse(english);      // removed
        System.out.println("Alice enrolled courses: " + aliceStudent.getEnrolledCourses().size() + " (expected 1)");

//        // ============================================================
//        // 9. FIND CURRENT CLASS + PROMOTE
//        // ============================================================
        System.out.println("\n===== 9. PROMOTE =====");
        Classes current = school.findCurrentClass(aliceStudent);
        System.out.println("Alice current class: " + (current != null ? current.getClassID() : "null"));
        school.promoteStudent(aliceStudent); // CLASS_1 -> CLASS_2
        System.out.println("After promote -> Class1 size: " + class1.size()
                + ", Class2 size: " + class2.size());
        // NOTE: promoteStudent moves the student between class lists but does not
        // update the student's own classLevel field, so we sync it for further demos.
        aliceStudent.setClassLevel(ClassLevel.CLASS_2);

//        // ============================================================
//        // 10. DEMOTE
//        // ============================================================
        System.out.println("\n===== 10. DEMOTE =====");
        school.demoteStudent(aliceStudent); // CLASS_2 -> CLASS_1
        System.out.println("After demote -> Class2 size: " + class2.size()
                + ", Class1 size: " + class1.size());
        aliceStudent.setClassLevel(ClassLevel.CLASS_1);

//        // ============================================================
//        // 11. GRADUATION (promote from the highest class level)
//        // ============================================================
        System.out.println("\n===== 11. GRADUATION =====");
        Applicant grad = new Applicant(4, "Grace", "Hill", "2004-01-01",
                ClassLevel.CLASS_8, "Old School", 4.2, LocalDate.now(), false, null);
        Student gradStudent = school.admitEnrollAndPlaceInClass(grad, class8);
        System.out.println("Grace in CLASS_8, graduated? " + gradStudent.isHasGraduated());
        school.promoteStudent(gradStudent); // top level -> graduates
        System.out.println("After promote -> graduated? " + gradStudent.isHasGraduated()
                + ", Class8 size: " + class8.size());

//        // ============================================================
//        // 12. PERSON FIELDS (inherited getters/setters) + REMOVE
//        // ============================================================
        System.out.println("\n===== 12. PERSON FIELDS + REMOVE =====");
        aliceStudent.setLastName("Stone-Updated");
        System.out.println("Alice full name: " + aliceStudent.getFirstName() + " " + aliceStudent.getLastName());
        System.out.println("Alice DOB: " + aliceStudent.getDateOfBirth());

        school.removeStudent(aliceStudent);
        school.removeStaff(janitor);
        System.out.println("Students after remove: " + school.getListOfStudents().size());
        System.out.println("Staff after remove: " + school.getListOfStaff().size());

        System.out.println("\n===== DONE =====");
    }
}

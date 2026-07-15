public class NonTeachingStaff extends Staff{
    String jobTitle;
    public NonTeachingStaff(int id, String firstName, String lastName, String dateOfBirth, String staffId, double salary, String role, String jobTitle) {
        super(id, firstName, lastName, dateOfBirth, staffId, salary, role);
        this.jobTitle = jobTitle;
    }
}

public class NonTeachingStaff extends Staff{
    private final String jobTitle;

    public NonTeachingStaff(int id, String firstName, String lastName, String dateOfBirth, String staffId, double salary, Role role, String jobTitle) {
        super(id, firstName, lastName, dateOfBirth, staffId, salary, role);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}

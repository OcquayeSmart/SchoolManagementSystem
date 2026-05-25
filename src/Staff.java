public abstract class Staff extends Person{
    private String getStaffId;
    private String staffId;
    private double salary;

    public Staff(int id, String firstName, String lastName, String dateOfBirth, String getStaffId, String staffId, double salary, Role role) {
        super(id, firstName, lastName, dateOfBirth);
        this.getStaffId = getStaffId;
        this.staffId = staffId;
        this.salary = salary;
    }
    public String getGetStaffId() {
        return getStaffId;
    }

    public void setGetStaffId(String getStaffId) {
        this.getStaffId = getStaffId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

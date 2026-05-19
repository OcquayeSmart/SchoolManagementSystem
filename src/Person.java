public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    Person(int id, String firstName, String lastName, String DateOfBirth){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = DateOfBirth;
    }
    public int getID(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getDateOfBirth(){
        return dateOfBirth;
    }
    public void setID(int id){
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setDateOfBirth(String DateOfBirth){
        this.dateOfBirth = DateOfBirth;
    }
}

public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String DateOfBirth;

    Person(int id, String firstName, String lastName, String DateOfBirth){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DateOfBirth = DateOfBirth;
    }
    //getters done
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
        return DateOfBirth;
    }
    //setters done
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
        this.DateOfBirth = DateOfBirth;
    }
}

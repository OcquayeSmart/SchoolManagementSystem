public class User {
    private final String username;
    private final String password;
    private final Role role;
    //the object taken here depends on the type of user
    private final Object profile;

    public User(String username, String password, Role role, Object profile) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() {
        return role;
    }
    public Object getProfile() {
        return profile;
    }
}

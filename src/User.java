import java.util.Objects;

public final class User {
    private String username;
    private String password;
    private final Role role;
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
    public String setUsername(String username){
        return this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password){
        return this.password = password;
    }
    public Object getProfile(){
        return profile;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (User) obj;
        return Objects.equals(this.username, that.username) &&
                Objects.equals(this.password, that.password) &&
                Objects.equals(this.role, that.role) &&
                Objects.equals(this.profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role, profile);
    }

    @Override
    public String toString() {
        return "User[" +
                "username=" + username + ", " +
                "password=" + password + ", " +
                "role=" + role + ", " +
                "profile=" + profile + ']';
    }

}

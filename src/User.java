/**
 * @param profile the object taken here depends on the type of user
 */
public record User(String username, String password, Role role, Object profile) {
}

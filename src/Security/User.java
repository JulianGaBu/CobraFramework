package Security;

/**
 * Created by Julian on 06/12/2016.
 */
public class User {
    String username;
    String password;
    Permissions permissions;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissions = new Permissions();
    }

    public User(String username, String password, Permissions permissions) {
        this.username = username;
        this.password = password;
        this.permissions = permissions;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

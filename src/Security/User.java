package Security;

/**
 * Created by Julian on 06/12/2016.
 */
public class User {
    private String username;
    private String password;
    private int permissions;

    User(){
    }

    User(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissions = Permissions.getPermissionlevel(this);
    }

    User(String username, String password, Permissions permissions) {
        this.username = username;
        this.password = password;
        this.permissions = Permissions.getPermissionlevel(this);
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    int getPermissions() {
        this.permissions = Permissions.getPermissionlevel(this);
        return permissions;
    }
}

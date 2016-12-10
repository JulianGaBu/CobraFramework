package Security;

/**
 * Created by Julian on 06/12/2016.
 */
public abstract class Permissions implements PermissionValues{
    static int getPermissionlevel(User user){
        switch(user.getClass().getName()){
            case "User": return DEFAULT_ACCESS;
            case "SuperUser": return SUPER_USER_ACCESS;
            case "Admin": return FULL_ACCESS;
            default: return DEFAULT_ACCESS;
        }
    }
}

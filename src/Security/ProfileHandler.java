package Security;

import Exceptions.NoSuchUserException;
import Exceptions.UserException;

/**
 * Created by Julian on 07/12/2016.
 */
public class ProfileHandler {
    private static User user;
    private static boolean authorized = false;
//    private static DB db;
//    static void initialize(){
//        db = new DB();
//    }

//    public ProfileHandler() {
//        this.db = new DB();
//    }

    /**
     * Returns <code>true</code> if a username is already registered
     * @param username the username to look up
     * @return <code>true</code> if registered ; throws exception otherwise
     * @throws NoSuchUserException if username doesnt exist
     */
    static boolean isRegistered(String username) throws NoSuchUserException {
        user = new User();
        user = DB.getUser(username);
        return true;
    }

    static boolean isUserPassword(String password) throws UserException {
        if(user==null){
            throw new UserException("No username specified!");
        }

        if(user.getPassword().equals(password)){
            logIn();
            return true;
        } else {
            //user = null;
            return false;
        }
    }

    private static void logIn(){
        if(user!=null)
        authorized = true;
    }

    static void logOut(){
        user = null;
        authorized = false;
    }

    public static boolean isAuthorized() {
        return authorized;
    }

    public static int getPermissions() {
        return user.getPermissions();
    }
}

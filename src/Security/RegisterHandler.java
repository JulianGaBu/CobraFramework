package Security;

import Exceptions.NoSuchUserException;
import Exceptions.PasswordSecurityException;
import Exceptions.UserException;

/**
 * Created by Julian on 07/12/2016.
 */
public class RegisterHandler {
    PasswordSecurityManager passManager;
//    DB db;

    public RegisterHandler() {
        this.passManager = new PasswordSecurityManager();
    }

    public RegisterHandler(int passwordLevel) {
        this.passManager = new PasswordSecurityManager(passwordLevel);
//        db = new DB();
    }

    /**
     * Creates a basic <code>User</code> object from username and password
     * @param username the username to bind
     * @param password the password to bind
     * @return <code>User</code> object generated
     * @throws UserException when the username already exists in the database
     */
    User createUser(String username, String password) throws UserException {
        User newUser = new User();
        try {
            newUser = DB.getUser(username);
            newUser = null;
            throw new UserException("Username already taken!");
        } catch (NoSuchUserException e) { //if there is no such user, it's available
            newUser = new User(username, password);
            return newUser;
        }
    }

    /**
     * Registers a user in the database (encripts the password sent)
     * @param username the username of the new user
     * @param password the password of the new user (UNencrypted)
     * @throws UserException of the username is taken
     */
    public void registerUser(String username, String password) throws UserException, PasswordSecurityException {
        User newUser;
        if(username==null) throw new UserException("No username specified!");
        if(passManager.isSecure(password)){
            String encryptedPassword = MD5.encrypt(password);
            newUser = createUser(username,encryptedPassword);
            DB.addUser(newUser);
        }
    }
}

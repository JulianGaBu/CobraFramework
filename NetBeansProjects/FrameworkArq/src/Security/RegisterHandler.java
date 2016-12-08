package Security;

import Exceptions.NoSuchUserException;
import Exceptions.UserException;

/**
 * Created by Julian on 07/12/2016.
 */
public class RegisterHandler {
    User user;
    PasswordSecurityManager PSM;
    DB db;



    /**
     * Creates a basic <code>User</code> object from username and password
     * @param username the username to bind
     * @param password the password to bind
     * @return <code>User</code> object generated
     * @throws UserException when the username already exists in the database
     */
    public User createUser(String username, String password) throws UserException {
        try {
            user = db.getUser(username);
            user = null;
            throw new UserException("Username already taken!");
        } catch (NoSuchUserException e) { //if there is no such user, it's available
            user = new User(username, password);
            return user;
        }
    }

    /**
     * Registers a user in the database
     * @param username the username of the new user
     * @param password the password of the new user (encrypted)
     * @throws UserException of the username is taken
     */
    public void registerUser(String username, String password) throws UserException {
        user = createUser(username,password);
        db.addUser(user);
    }
}

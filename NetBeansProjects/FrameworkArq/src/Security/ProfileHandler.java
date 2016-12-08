package Security;

import Exceptions.NoSuchUserException;
import Exceptions.UserException;

/**
 * Created by Julian on 07/12/2016.
 */
public class ProfileHandler {
    String permisos;
    User user;
    DB db;

    public ProfileHandler() {
        this.db = new DB();
    }

    /**
     * Returns <code>true</code> if a username is already registered
     * @param username the username to look up
     * @return <code>true</code> if registered ; throws exception otherwise
     * @throws NoSuchUserException if username doesnt exist
     */
    public boolean isRegistered(String username) throws NoSuchUserException {
        user = db.getUser(username);
        return true;
    }

    public boolean isUserPassword(String password) throws UserException {
        if(user == null){
            throw new UserException("No username specified!");
        }
        return (user.getPassword().equals(password));
    }

    public User getUser() {
        return user;
    }
}

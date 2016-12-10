package Security;

import Exceptions.LoginAttemptException;
import Exceptions.UserException;

/**
 * Created by Julian on 06/12/2016.
 */
public class LoginHandler {
    private final int MAX_ATTEMPTS;
    private int attempt;

    /**
     * Constructor to create a login verifier with a maximum number of attempts
     * @param attempts the max number of attempts to set
     */
    public LoginHandler(int attempts){
        this.MAX_ATTEMPTS = attempts;
    }

    /**
     * Returns <code>true</code> if the user exists, and starts the attempt counter
     * @param user the username to look up
     * @return <code>true</code> if user exists
     * @throws LoginAttemptException if the user doesnt exist
     */
    public boolean verifyUser(String user) throws LoginAttemptException {
        try {
            this.attempt = 0;
            boolean what = ProfileHandler.isRegistered(user);
            return what;
        } catch (UserException ure) {
            throw new LoginAttemptException("User doesnt exist");
        }
    }

    /**
     * Checks if the password exists
     * @param pass
     * @return <code>true</code> if password is correct
     * @throws LoginAttemptException if the password is wrong or if the user is out of attempts
     */
    public boolean checkPassword(String pass) throws LoginAttemptException {
        //todo passwords are always stored in hash form
        //error handling
        String encryptedPass = MD5.encrypt(pass);

        if(pass.equals("")||pass == null){
            throw new LoginAttemptException("Password field is empty!");
        }

        attempt++;
        if (attempt >= MAX_ATTEMPTS) {
            throw new LoginAttemptException("You can only fail a password "+ MAX_ATTEMPTS +" times!");
        }

        try {
            if(ProfileHandler.isUserPassword(encryptedPass)){
                return true;
            } else {
                throw new LoginAttemptException("Incorrect password. " + (MAX_ATTEMPTS - attempt) + " attempts remaining");
            }
        } catch (UserException NoUser) { //when a password attempt was sent without specifying username
            throw new LoginAttemptException();
        }
    }
}

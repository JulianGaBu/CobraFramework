package Exceptions;

/**
 * Created by Julian on 07/12/2016.
 */
public class LoginAttemptException extends Exception {
    public LoginAttemptException() { super(); }
    public LoginAttemptException(String message) { super(message); }
    public LoginAttemptException(String message, Throwable cause) { super(message, cause); }
    public LoginAttemptException(Throwable cause) { super(cause); }
}

package Exceptions;

/**
 * Created by Julian on 07/12/2016.
 */
public class NoSuchUserException extends  UserException {
    public NoSuchUserException(String message) {
        super(message);
    }

    public NoSuchUserException(Throwable cause) {
        super(cause);
    }
}

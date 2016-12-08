package Exceptions;

/**
 * Created by Julian on 07/12/2016.
 */
public class PasswordSecurityException extends Exception{
    public PasswordSecurityException() { super(); }
    public PasswordSecurityException(String message) { super(message); }
    public PasswordSecurityException(String message, Throwable cause) { super(message, cause); }
    public PasswordSecurityException(Throwable cause) { super(cause); }
}

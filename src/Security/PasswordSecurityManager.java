package Security;

import Exceptions.PasswordSecurityException;

/**
 * Created by Julian on 06/12/2016.
 */
public class PasswordSecurityManager implements PasswordSecurityLevels{
    final int MIN_PASS_LEVEL;

    public PasswordSecurityManager(){
        MIN_PASS_LEVEL = ANY_PASSWORD;
    }

    /**
     * Constructor to create a password manager with a specific security level
     * @param level the minimum security level
     */
    public PasswordSecurityManager(int level){
        MIN_PASS_LEVEL = level;
    }

    /**
     * Checks the security level of a password
     * @param password
     * @return int level
     */
    public int getPasswordSecurityLevel(String password){
        int level = 0;
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasNumbers = password.matches(".*\\d+.*");

        if(hasLowercase && hasUppercase){
            level = CAPS;
            if(hasNumbers)
                level = CAPS_NUMBERS;
        }else{
            level = ANY_PASSWORD;
            if(hasNumbers)
                level = NUMBERS;
        }

        boolean hasSpecial = !password.matches("[A-Za-z0-9 ]*");
        if(hasSpecial)
            switch(level){
                case 0: level = SYMBOLS; break;
                case 1: level = CAPS_SYMBOLS; break;
                case 2: level = NUMBERS_SYMBOLS; break;
                case 4: level = CAPS_NUMBERS_SYMBOLS; break;
            }

        return level;
    }

    /**
     * Returns <code>true</code> if the security level of a password is higher than the minimum
     * @param password the password to verify
     * @return <code>true</code> if secure;
     *         <code>false</code> otherwise
     */
    public boolean isSecure(String password) throws PasswordSecurityException {
        int passlevel = getPasswordSecurityLevel(password);
        if(passlevel == CAPS_NUMBERS_SYMBOLS) return true; //if already at max security, return true
        switch (MIN_PASS_LEVEL){
            case CAPS:
                if(passlevel == CAPS||passlevel == CAPS_NUMBERS||passlevel == CAPS_SYMBOLS) return true;
                else throw new PasswordSecurityException("Password doesn't match security requirements (CAPS)");
            case NUMBERS:
                if(passlevel == NUMBERS||passlevel == CAPS_NUMBERS||passlevel == NUMBERS_SYMBOLS) return true;
                else throw new PasswordSecurityException("Password doesn't match security requirements (NUMBERS)");
            case SYMBOLS:
                if(passlevel == SYMBOLS||passlevel == CAPS_SYMBOLS||passlevel == NUMBERS_SYMBOLS)return true;
                else throw new PasswordSecurityException("Password doesn't match security requirements (SYMBOLS)");
            case CAPS_NUMBERS:
                if(passlevel == CAPS_NUMBERS) return true;
                else throw new PasswordSecurityException("Password doesn't match security requirements (CAPS_NUMBERS)");
            case NUMBERS_SYMBOLS:
                if(passlevel == NUMBERS_SYMBOLS) return true;
                else throw new PasswordSecurityException("Password doesn't match security requirements (NUMBERS_SYMBOLS)");
            case CAPS_SYMBOLS:
                if(passlevel == CAPS_SYMBOLS) return true;
                else throw new PasswordSecurityException("Password doesn't match security requirements (NUMBERS_SYMBOLS)");
        }
        return false;
    }
}

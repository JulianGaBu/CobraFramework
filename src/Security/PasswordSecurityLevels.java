package Security;

/**
 * Created by Julian on 07/12/2016.
 */
public interface PasswordSecurityLevels {
    int ANY_PASSWORD = 0;
    int CAPS = 1;
    int NUMBERS = 2;
    int SYMBOLS = 3;
    int CAPS_NUMBERS = 4;
    int CAPS_SYMBOLS = 5;
    int NUMBERS_SYMBOLS = 6;
    int CAPS_NUMBERS_SYMBOLS = 7;
}

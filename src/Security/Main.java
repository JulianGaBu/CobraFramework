package Security;

import Exceptions.LoginAttemptException;

import java.util.Scanner;

/**
 * Created by Julian on 06/12/2016.
 */
public class Main {
    static String usuario;
    static String password;
    static LoginHandler login;
    static PasswordSecurityManager passManager;

    public static void main(String[] args) {
        login = new LoginHandler(3);
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        try {
            while (!stop) {
                System.out.println("Introduzca su nombre de usuario: ");
                usuario = scanner.nextLine();
                stop = login.verifyUser(usuario);
            }
            stop = false;
            while (!stop) {
                System.out.println("Introduzca su contraseña: ");
                password = scanner.nextLine();
                stop = login.checkPassword(password);
            }
        } catch (LoginAttemptException e) {
            e.printStackTrace();
        }
    }

}

package Security;

import DataBaseAdmin.DatabaseConnection;
import Exceptions.LoginAttemptException;
import Exceptions.PasswordSecurityException;
import Exceptions.UserException;

import java.util.Scanner;

/**
 * Created by Julian on 06/12/2016.
 */
public class Main {
    static String usuario;
    static String password;
    static LoginHandler login;
    static PasswordSecurityManager passManager;
    static RegisterHandler regH;

    public static void main(String[] args) {
        DB.populateUsers();
        login = new LoginHandler(3);
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);
        regH = new RegisterHandler(1);

        try {
            System.out.println("Introduzca su nombre de usuario: ");
            usuario = scanner.nextLine();
            System.out.println("Introduzca su contraseña: ");
            password = scanner.nextLine();
            regH.registerUser(usuario, password);
        } catch (PasswordSecurityException e) {
            e.printStackTrace();
        } catch (UserException e) {
            e.printStackTrace();
        }

        while (!stop) {
            try {
                System.out.println("Introduzca su nombre de usuario: ");
                usuario = scanner.nextLine();
                stop = login.verifyUser(usuario);
            } catch (LoginAttemptException e) {
                e.printStackTrace();
            }
        }
        stop = false;
        while (!stop) {
            try {
                System.out.println("Introduzca su contraseña: ");
                password = scanner.nextLine();
                login.checkPassword(password);
                stop = true;
            } catch (LoginAttemptException e) {
                e.printStackTrace();
            }
        }
    }

}

package Security;

import Exceptions.NoSuchUserException;
import Exceptions.UserException;

import java.util.ArrayList;

/**
 * Created by Julian on 06/12/2016.
 */
public class DB {
    static ArrayList<User> users = new ArrayList<>();

//    public DB(){
//        //users = new ArrayList<>();
//        populateUsers();
//    }

    public static void addUser(User user){
        users.add(user);
    }

    public static User getUser(String username) throws NoSuchUserException {
        if(users.isEmpty()){
            throw new NoSuchUserException("No users in the database!");
        }
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(username)){
                return users.get(i);
            }
        }
        throw new NoSuchUserException("No such user in the database!");
    }

    public static void populateUsers(){
        users.add(new User("Jerry","525bf8dbdb6379a98321af620e1bfcb8"));
        users.add(new User("Gerry","d2f21ebb2bb6c901b6cad7251e44f53f"));
        users.add(new User("Roli","75f5750f6dd6afbec57b0928a0ec306b"));
        users.add(new User("Rod","d4e94fde850af13e8278f0a91d4e2060"));
    }

}

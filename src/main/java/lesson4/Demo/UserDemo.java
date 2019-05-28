package lesson4.Demo;

import lesson4.Controller.UserController;
import lesson4.model.User;


public class UserDemo {

    public static void main(String[] args) {

    UserController userController = new UserController();


        User user = new User("Test", "Password", "USA", "USER");

        userController.registerUser(user);
    }
}

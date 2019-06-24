package lesson4.Demo;

import lesson4.Controller.UserController;
import lesson4.exception.BadRequestException;
import lesson4.exception.InternalServerException;
import lesson4.model.User;


public class UserDemo {

    public static void main(String[] args) throws BadRequestException, InternalServerException {

    UserController userController = new UserController();


        User user = new User("Test2221111", "Password222", "USA", "USER");

        userController.registerUser(user);
    }
}

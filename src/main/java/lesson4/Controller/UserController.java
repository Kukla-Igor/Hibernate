package lesson4.Controller;

import lesson4.model.User;
import lesson4.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public User registerUser(User user) {
        return userService.registerUser(user);
    }
}

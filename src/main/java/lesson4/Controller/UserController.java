package lesson4.Controller;

import lesson4.exception.BadRequestException;
import lesson4.exception.InternalServerException;
import lesson4.model.User;
import lesson4.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public User registerUser(User user) throws BadRequestException, InternalServerException {
        return userService.registerUser(user);
    }
}

package lesson4.service;


import lesson4.DAO.UserDAO;
import lesson4.exception.BadRequestException;
import lesson4.exception.InternalServerException;
import lesson4.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws BadRequestException, InternalServerException {

        if (userDAO.check(user))
            return (User) userDAO.save(user);
        else
            throw new BadRequestException("User is already registered");

    }
}

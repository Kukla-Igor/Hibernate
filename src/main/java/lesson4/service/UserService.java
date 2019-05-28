package lesson4.service;


import lesson4.DAO.UserDAO;
import lesson4.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) {
        return (User) userDAO.save(user);
    }
}

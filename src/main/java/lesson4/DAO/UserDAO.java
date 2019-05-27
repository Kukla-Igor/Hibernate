package lesson4.DAO;


import lesson4.model.User;

public class UserDAO extends GeneralDAO {

    @Override
    Class aClass() {
        return User.class;
    }
}
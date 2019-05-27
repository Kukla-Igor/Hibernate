package lesson4.Demo;

import lesson4.DAO.UserDAO;


public class UserDemo {

    public static void main(String[] args) {

    UserDAO userDAO = new UserDAO();


        System.out.println(userDAO.findById((long)1));
    }
}

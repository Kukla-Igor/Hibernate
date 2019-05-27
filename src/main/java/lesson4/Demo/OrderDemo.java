package lesson4.Demo;


import lesson4.Controller.OrderController;
import lesson4.DAO.OrderDAO;

import java.util.Date;


public class OrderDemo {

    public static void main(String[] args) throws Exception  {

//        OrderController orderController = new OrderController();
////
////        orderController.bookRoom(57, 1, new Date(), new Date());

        OrderDAO orderDAO = new OrderDAO();


        System.out.println(orderDAO.findById((long)1));
    }
}


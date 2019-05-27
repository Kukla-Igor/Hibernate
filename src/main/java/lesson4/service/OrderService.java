package lesson4.service;


import lesson4.DAO.OrderDAO;

import java.util.Date;

public class OrderService {
   private OrderDAO orderDAO = new OrderDAO();

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception{
        orderDAO.bookRoom(roomId,userId,dateFrom,dateTo);
    }
//
//    public void cancelReservation(long roomId, long userId) throws Exception{
//        orderDAO.cancelReservation(roomId, userId);
//    }
}

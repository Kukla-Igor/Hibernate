package lesson4.DAO;


import lesson4.exception.BadRequestException;
import lesson4.model.Order;
import lesson4.model.Room;
import lesson4.model.User;

import java.util.Date;

public class OrderDAO extends GeneralDAO  {

public void bookRoom (long roomId, long userId, Date dateFrom, Date dateTo) throws BadRequestException{
    UserDAO userDAO = new UserDAO();
    RoomDAO roomDAO = new RoomDAO();

    Room room = (Room) roomDAO.findById(roomId);
    System.out.println(room);
    User user = (User) userDAO.findById(userId);



    System.out.println(user);

    if (user == null || room == null)
        throw  new BadRequestException("room or user not found");

    if (room.getDateAvailableFrom().getTime() > dateFrom.getTime())
        throw new BadRequestException("Sorry, the room with id " + roomId + " is busy");

    Order order = new Order(user, room, dateFrom, dateTo, room.getPrice());

    save(order);

    new RoomDAO().updateDateRoom(order.getDateTo(), roomId);
}

    @Override
    Class aClass() {
        return Order.class;
    }
}
package lesson4.DAO;


import lesson4.exception.BadRequestException;
import lesson4.exception.UserNotFoundException;
import lesson4.model.Order;
import lesson4.model.Room;
import lesson4.model.User;

import java.util.Date;

public class OrderDAO extends GeneralDAO {
    UserDAO userDAO = new UserDAO();
    RoomDAO roomDAO = new RoomDAO();

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws BadRequestException {

        Room room = (Room) roomDAO.findById(roomId);
        User user = (User) userDAO.findById(userId);

        check(user, room);

        if (room.getDateAvailableFrom().getTime() > dateFrom.getTime())
            throw new BadRequestException("Sorry, the room with id " + roomId + " is busy");

        Order order = new Order(user, room, dateFrom, dateTo, room.getPrice());

        save(order);

        roomDAO.updateDateRoom(order.getDateTo(), roomId);
    }

    public void cancelReservation (long roomId, long userId) throws Exception{

        Room room = (Room) roomDAO.findById(roomId);
        User user = (User) userDAO.findById(userId);

        check(user, room);

        if (user.getOrders().isEmpty()) {
            throw new UserNotFoundException("Order is not found");
        }

        for (Order order:user.getOrders()) {
            if(order.getRoom().getId() == roomId){
                delete(order.getId());
                roomDAO.updateDateRoom(new Date(), roomId);
            }
            else {
                throw new UserNotFoundException("Order is not found");
            }
        }
    }

    private void check (User user, Room room) throws BadRequestException {
        if (user == null || room == null)
            throw new BadRequestException("room or user not found");
    }
    @Override
    Class aClass() {
        return Order.class;
    }
}
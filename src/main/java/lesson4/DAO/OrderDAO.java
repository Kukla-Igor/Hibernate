package lesson4.DAO;


import lesson4.exception.BadRequestException;
import lesson4.exception.InternalServerException;
import lesson4.exception.UserNotFoundException;
import lesson4.model.Order;
import lesson4.model.Room;
import lesson4.model.User;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;

public class OrderDAO extends GeneralDAO {
    UserDAO userDAO = new UserDAO();
    RoomDAO roomDAO = new RoomDAO();

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws BadRequestException, UserNotFoundException, InternalServerException {

        Room room = (Room) roomDAO.findById(roomId, Room.class);
        User user = (User) userDAO.findById(userId, User.class);

        if (room.getDateAvailableFrom().getTime() > dateFrom.getTime())
            throw new BadRequestException("Sorry, the room with id " + roomId + " is busy");

        Order order = new Order(user, room, dateFrom, dateTo, room.getPrice());

        try (Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            session.save(order);
            updateDateRoom(session, dateTo, roomId);


            tr.commit();

            System.out.println("Save is done");
        } catch (HibernateError e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
        }
    }

    public void cancelReservation (long roomId, long userId) throws Exception{

        User user = (User) userDAO.findById(userId, User.class);


        if (user.getOrders().isEmpty()) {
            throw new BadRequestException("Order is not found");
        }

        for (Order order:user.getOrders()) {
            if(order.getRoom().getId() == roomId){
                try (Session session = createSessionFactory().openSession()) {

                    tr = session.getTransaction();
                    tr.begin();

                    session.delete(order);

                    updateDateRoom(session, new Date(), roomId);

                    tr.commit();

                    System.out.println("Delete is done");
                } catch (HibernateError e) {
                    System.err.println("Delete is failed");
                    System.err.println(e.getMessage());
                }
            }
            else {
                throw new UserNotFoundException("Order is not found");
            }
        }
    }

    private void updateDateRoom(Session session, Date date, Long roomId){
        Query query = session.createNativeQuery("UPDATE ROOM SET DATE_AVAILABLE_FROM = ? where ID = ?");
        query.setParameter(1, date);
        query.setParameter(2, roomId);

        query.executeUpdate();
    }


    @Override
    Class aClass() {
        return Order.class;
    }
}
package lesson4.DAO;

import lesson4.exception.UserNotFoundException;
import lesson4.model.Filter;
import lesson4.model.Hotel;
import lesson4.model.Room;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomDAO extends GeneralDAO {


    GeneralDAO generalDAO;

    public List<Room> findRooms(Filter filter) throws UserNotFoundException {
        ArrayList<Room> roomList = new ArrayList<>();
        List<Hotel> hotelList = new ArrayList<>();

        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            filter = checkFilter(filter);

            Query query = session.createNativeQuery("SELECT * FROM HOTEL where NAME like ? AND COUNTRY like ? AND CITY like ?", Hotel.class);
            query.setParameter(1, filter.getName());
            query.setParameter(2, filter.getCountry());
            query.setParameter(3, filter.getCity());

            hotelList = query.list();

            tr.commit();

        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        }


        for (Hotel hotel : hotelList) {
            List<Room> rooms = findRoom(hotel, filter);
            if (rooms != null) {
                roomList.addAll(rooms);
            }
        }

        if (roomList.isEmpty())
            throw new UserNotFoundException("Rooms are not found");

        return roomList;

    }

    private Filter checkFilter(Filter filter) {
        if (filter.getName() == null)
            filter.setName("%");
        if (filter.getCountry() == null)
            filter.setCountry("%");
        if (filter.getCity() == null)
            filter.setCity("%");
        return filter;
    }

    private List<Room> findRoom(Hotel hotel, Filter filter) {
        List <Room> rooms = new ArrayList<>();
        for (int i = 0; i< hotel.getRooms().size(); i++){
            Room room = hotel.getRooms().get(i);
            if ((filter.getNumberOfGuests() == 0 || filter.getNumberOfGuests() == room.getNumberOfGuets()) && (filter.getPrice() == 0 || filter.getPrice() == room.getPrice()) && (filter.isBreakfastIncluded() == room.isBreakfastIncluded()) && (filter.isPetsAllowed() == room.isPetsAllowed()) && (filter.getDateAvailableFrom() == null || filter.getDateAvailableFrom().equals(room.getDateAvailableFrom())))
                rooms.add(room);
        }
        return rooms;
    }

    public void updateDateRoom(Date newDate, long id){
        try {
            Session session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createNativeQuery("UPDATE ROOM SET DATE_AVAILABLE_FROM = ? where ID = ?");
            query.setParameter(1, newDate);
            query.setParameter(2, id);

            tr.commit();

        } catch (HibernateError e) {
            System.err.println(e.getMessage());
        }

    }

//    public Room findById(Long id) {
//        return (Room) generalDAO.findById(id);
//    }

    @Override
    Class aClass() {
        return Room.class;
    }
}


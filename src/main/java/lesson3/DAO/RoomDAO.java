package lesson3.DAO;


import lesson3.Room;

public class RoomDAO extends GeneralDAO {

    @Override
    String getQuery() {
        return "FROM Room where id = :id";
    }

    @Override
    Class aClass() {
        return Room.class;
    }
}

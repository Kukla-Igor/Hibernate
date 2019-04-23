package lesson3.DAO;


public class RoomDAO extends GeneralDAO {

    @Override
    String getQuery() {
        return "FROM Room where id = :id";
    }
}

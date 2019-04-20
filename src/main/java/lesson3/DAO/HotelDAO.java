package lesson3.DAO;


public class HotelDAO extends GeneralDAO {

    @Override
    String getQuery() {
        return "FROM Hotel where id = :id";
    }
}
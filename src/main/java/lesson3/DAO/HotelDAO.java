package lesson3.DAO;


import lesson3.Hotel;
import lesson3.IdEntity;

public class HotelDAO extends GeneralDAO {

    @Override
    String getQuery() {
        return "FROM Hotel where id = :id";
    }

    @Override
    Class aClass() {
        return Hotel.class;
    }
}
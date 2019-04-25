package lesson3.DAO;


import lesson3.Hotel;
import lesson3.IdEntity;

public class HotelDAO extends GeneralDAO {

    @Override
    Class aClass() {
        return Hotel.class;
    }
}
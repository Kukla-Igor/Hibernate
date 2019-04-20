package lesson3;

import lesson3.DAO.HotelDAO;
import lesson3.DAO.RoomDAO;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();
        Hotel hotel = new Hotel( 5,"Fregat", "Ukraine2", "Kherson2", "Ushakova");
        Room room = new Room(5, 225, 1, 1, new Date(), hotel);
        //System.out.println(hotelDAO.save(hotel));

        System.out.println(roomDAO.findById((long) 3));

        //roomDAO.Delete((long) 11);

        //System.out.println(roomDAO.update(room));

    }
}

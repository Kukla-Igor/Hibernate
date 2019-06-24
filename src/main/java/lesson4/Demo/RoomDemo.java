package lesson4.Demo;


import lesson4.Controller.RoomController;
import lesson4.DAO.HotelDAO;
import lesson4.DAO.RoomDAO;
import lesson4.model.Filter;
import lesson4.model.Hotel;
import lesson4.model.Room;

import java.util.Date;

public class RoomDemo {

    public static void main(String[] args) throws Exception {

        RoomController roomController = new RoomController();
        //RoomDAO roomDAO = new RoomDAO();

        Filter filter = new Filter(5, 20.5, true, false, null, null, null, null);

        Hotel hotel = new Hotel( 41, "Sharm", "Egypt", "Sinay", "Streer");

        Room room = new Room(5, 20.5, true, false, new Date(), hotel);
        //System.out.println(roomController.findRooms(filter));
        //System.out.println(roomDAO.save(room));
        roomController.deleteRoom((long) 57);
    }
}

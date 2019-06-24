package lesson4.Demo;

import lesson4.Controller.HotelController;
import lesson4.DAO.HotelDAO;
import lesson4.model.Hotel;

public class HotelDemo {

    public static void main(String[] args) throws Exception {

        HotelController hotelController = new HotelController();

//        System.out.println(hotelController.findHotelByName(""));
        //System.out.println(hotelController.findHotelByCity("Kherson"));

        Hotel hotel = new Hotel("Sharm", "Egypt", "Sinay", "Street");

        HotelDAO hotelDAO = new HotelDAO();


    }
}

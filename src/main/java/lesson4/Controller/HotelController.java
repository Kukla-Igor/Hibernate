package lesson4.Controller;


import lesson4.model.Hotel;
import lesson4.service.HotelService;

public class HotelController {
    private HotelService hotelService = new HotelService();

    public Hotel findHotelByName (String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity (String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }
//
//    public Hotel addHotel(Hotel hotel) throws Exception {
//        return hotelService.addHotel(hotel);
//    }
//
//    public void deleteHotel(Long hotelId) throws Exception{
//        hotelService.deleteHotel(hotelId);
//    }
}

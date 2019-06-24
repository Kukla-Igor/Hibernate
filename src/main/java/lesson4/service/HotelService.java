package lesson4.service;


import lesson4.DAO.HotelDAO;
import lesson4.exception.BadRequestException;
import lesson4.model.Hotel;

public class HotelService {

    private HotelDAO hotelDAO = new HotelDAO();

    public Hotel findHotelByName(String name) throws Exception {
        if (name.isEmpty())
            throw new BadRequestException("You do not enter the name of the hotel");
        return hotelDAO.findHotelByName(name);
    }

    public Hotel findHotelByCity(String city) throws Exception {
        if (city.isEmpty())
            throw new BadRequestException("You do not enter the name of the hotel");
        return hotelDAO.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        if (hotel == null)
            throw new BadRequestException("You do not enter the name of the hotel");
        return (Hotel) hotelDAO.save(hotel);
    }

    public void deleteHotel(Long hotelId) throws Exception{
        if (hotelId == null)
            throw new BadRequestException("You do not enter the name of the hotel");
        hotelDAO.delete(hotelId);
    }
}

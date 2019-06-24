package lesson4.service;


import lesson4.DAO.RoomDAO;
import lesson4.exception.BadRequestException;
import lesson4.model.Filter;
import lesson4.model.Room;

import java.util.List;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public List<Room> findRooms(Filter filter) throws Exception {
        if (filter == null)
            throw new BadRequestException("You do not enter the filter");
        return roomDAO.findRooms(filter);
    }

    public Room addRoom(Room room) throws Exception {
        if (room == null)
            throw new BadRequestException("You do not enter the name of the hotel");
        return (Room) roomDAO.save(room);
    }

    public void deleteRoom(Long roomId) throws Exception{
        if (roomId == null)
            throw new BadRequestException("You do not enter the name of the hotel");
        roomDAO.delete(roomId);
    }
}

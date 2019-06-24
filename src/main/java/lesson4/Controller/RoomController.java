package lesson4.Controller;


import lesson4.model.Filter;
import lesson4.model.Room;
import lesson4.service.RoomService;

import java.util.List;

public class RoomController {

    private RoomService roomService = new RoomService();

    public List<Room> findRooms(Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }

    public Room addRoom(Room room) throws Exception {
        return roomService.addRoom(room);
    }

    public void deleteRoom(Long roomId) throws Exception{
        roomService.deleteRoom(roomId);
    }
}

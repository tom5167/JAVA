package patientCareBusinessLogic;

import java.util.List;

import patientCareDAO.RoomDAO;
import patientCarePOJO.Room;

public class RoomLogic {
	RoomDAO roomDAO = new RoomDAO();

	public List<Room> getAlRoomDetails(String firstName) {
		return roomDAO.getAlRoomDetails(firstName);
	}
	
	public boolean saveRoomDetails(Room roomDetails) {
		if(roomDetails.getRoomId() < 1) {
			return roomDAO.insertRoomDetails(roomDetails);
		} else {
			return roomDAO.updateRoomDetails(roomDetails);
		}
	}
	
	public boolean deleteRoomDetails(Room roomDetails) {
		return roomDAO.deleteRoomDetails(roomDetails);
	}
	
}

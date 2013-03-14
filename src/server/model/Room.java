package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

public class Room extends Model {

	private int roomID, personCapacity;
	private String roomName;
	
	public Room(int roomID) throws SQLException {
		super("Room", createTableFields(), "roomID");
		ResultSet result = super.getFromDB(roomID);
		if(result.next()) {
			this.roomID = result.getInt("roomID");
			this.roomName = result.getString("roomName");
			this.personCapacity = result.getInt("personCapacity");
		}
	}
	
	public Room() throws SQLException {
		super("Room", createTableFields(), "roomID");
		ArrayList<Integer> keyList = super.addToDB();
		this.roomID = keyList.get(0);
	}
	
	public int getRoomID() {
		return roomID;
	}

	public int getPersonCapacity() {
		return personCapacity;
	}

	public String getRoomName() {
		return roomName;
	}

	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("roomID");
		tableFields.add("roomName");
		tableFields.add("personCapacity");
		return tableFields;
	}
	
	public boolean isBookedInPeriod(DateTime start, DateTime end) {
		return false;
	}

	public void setPersonCapacity(int personCapacity) throws SQLException {
		super.updateField("personCapacity", personCapacity, roomID);
		this.personCapacity = personCapacity;
	}

	public void setRoomName(String roomName) throws SQLException {
		super.updateField("roomName", roomName, roomID);
		this.roomName = roomName;
	}
	
	@Override
	public void delete() throws SQLException {
		super.delete(roomID);		
	}
}

package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

public class Room extends Model {

	private int roomID, personCapacity;
	private String roomName;
	
	public Room(int roomID) throws SQLException {
		super("Room", createTableFields(), "roomID", null);
		ResultSet result = super.getFromDB(roomID);
		if(result.next()) {
			this.roomID = result.getInt("roomID");
			this.roomName = result.getString("roomName");
			this.personCapacity = result.getInt("personCapacity");
		}
	}
	
	public Room(String roomName, int personCapacity) throws SQLException {
		super("Room", createTableFields(), "roomID", null);
		String values = "'" + roomName + "', " + personCapacity ;
		ArrayList<Integer> keyList = super.addToDB(values);
		this.roomID = keyList.get(0);
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
}

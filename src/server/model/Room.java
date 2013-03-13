package server.model;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Room extends Model {

	private int roomID, personCapacity;
	private String roomName;
	
	public Room() {
		super("Room", createTableFields(), "roomID", null);
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

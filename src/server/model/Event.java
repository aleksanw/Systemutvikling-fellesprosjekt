package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

public class Event extends Model{
	
	private int eventID;
	private boolean isActive, isWholeDay;
	private boolean isMeeting;
	private String eventName, description, location;
	private DateTime start, end;
	private boolean isWholeday;
	private int roomBooked;
	private int createdByUser;
	private int createdByGroup;
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) throws SQLException {
		super.updateField("isActive", isActive, eventID);
		this.isActive = isActive;
	}

	public boolean isWholeDay() {
		return isWholeDay;
	}

	public void setWholeDay(boolean isWholeDay) throws SQLException {
		super.updateField("isWholeDay", isWholeDay, eventID);
		this.isWholeDay = isWholeDay;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) throws SQLException {
		super.updateField("eventName", eventName, eventID);
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws SQLException {
		super.updateField("description", description, eventID);
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) throws SQLException {
		super.updateField("location", location, eventID);
		this.location = location;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) throws SQLException {
		super.updateField("start", start, eventID);
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) throws SQLException{
		super.updateField("end", end, eventID);
		this.end = end;
	}

	public int getRoomBooked() {
		return roomBooked;
	}

	public void setRoomBooked(int roomBooked) throws SQLException {
		super.updateField("roomBooked",roomBooked, eventID);
		this.roomBooked = roomBooked;
	}

	public int getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(int createdByUser) throws SQLException {
		super.updateField("createdByUser", createdByUser, eventID);
		this.createdByUser = createdByUser;
	}

	public int getCreatedByGroup() {
		return createdByGroup;
	}

	public void setCreatedByGroup(int createdByGroup) throws SQLException {
		super.updateField("createdByGroup", createdByGroup, eventID);
		this.createdByGroup = createdByGroup;
	}

	public boolean isMeeting() {
		return isMeeting;
	}
	
	public Event(int eventID) throws SQLException {
		super("Event", createTableFields(), "eventID", null);
		ResultSet result = super.getFromDB(eventID);
		if(result.next()) {
			this.eventID = result.getInt("eventID");
			this.eventName = result.getString("eventName");
			this.isActive = result.getBoolean("isActive");
			this.start = new DateTime(result.getDate("start"));
			this.end = new DateTime(result.getDate("end"));
			this.isWholeday = result.getBoolean("isWholeDay");
			this.description = result.getString("description");
			this.location = result.getString("location");
			this.isMeeting = result.getBoolean("isMeeting");
			this.roomBooked = result.getInt("roomBooked");
			this.createdByUser = result.getInt("createdByUser");
			this.createdByGroup = result.getInt("createdByGroup");
		}	
	}
	
	public Event(String eventName, boolean isMeeting) throws SQLException {
		super("Event", createTableFields(), "eventID", null);
		String values =  "'" + eventName + "', true, '0000-01-01 00:00:00', '0000-01-01 00:00:00', false, ''," +
				" '', " + isMeeting + ", null, null, null";
		ArrayList<Integer> keyList = super.addToDB(values);
		this.eventID = keyList.get(0);
		this.eventName = eventName;
		this.isMeeting = isMeeting;
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("eventID");
		tableFields.add("eventName");
		tableFields.add("isActive");
		tableFields.add("start");
		tableFields.add("end");
		tableFields.add("isWholeDay");
		tableFields.add("description");
		tableFields.add("location");
		tableFields.add("isMeeting");
		tableFields.add("roomBooked");
		tableFields.add("createdByUser");
		tableFields.add("createdByGroup");
		return tableFields;
	}
	
	public ArrayList<Invitation> getInvitationList() {
		return new ArrayList<Invitation>();
	}
	
	public void invite(User user) {
		
	}

	public int getEventID() {
		return eventID;
	}
}

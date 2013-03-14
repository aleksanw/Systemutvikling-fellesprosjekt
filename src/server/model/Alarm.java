package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class Alarm extends Model {
	
	private Time numberOfHoursBeforeMeeting;
	private int userID, eventID;
	
	public int getUserID() {
		return userID;
	}

	public int getEventID() {
		return eventID;
	}

	public void setNumberOfHoursBeforeMeeting(Time numberOfHoursBeforeMeeting) {
		this.numberOfHoursBeforeMeeting = numberOfHoursBeforeMeeting;
	}

	public Alarm(int userID, int eventID) throws SQLException{
		super("Alarm", createTableFields(), "Event_eventID", "User_userID");
		ResultSet result = super.getFromDB(userID, eventID);
		if(result.next()) {
			this.eventID = result.getInt("Event_eventID");
			this.userID = result.getInt("User_userID");
			this.numberOfHoursBeforeMeeting = result.getTime("numberOfHoursBeforeMeeting");
		}		
	}
	
	public Alarm(int eventID, int userID, Time numberOfHoursBeforeMeeting) throws SQLException{
		super("Alarm", createTableFields(), "Event_eventID", "User_userID");
		String values = "'" + eventID+ "', '" + userID + "', '" + numberOfHoursBeforeMeeting + "'";
		super.addRelationToDB(values);
		this.eventID = eventID;
		this.userID = userID;
		this.numberOfHoursBeforeMeeting = numberOfHoursBeforeMeeting;		
	}
	
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("Event_eventID");
		tableFields.add("User_userID");
		tableFields.add("numberOfHoursBeforeMeeting");
		return tableFields;
	}
	
	public User getUser() throws SQLException {
		return new User(-1);
	}
	
	public Event getEvent() {
		return null;
	}
	
	public Time getNumberOfHoursBeforeMeeting() {
		return numberOfHoursBeforeMeeting;
	}
}

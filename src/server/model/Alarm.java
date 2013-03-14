package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class Alarm extends Model {
	
	private Time numberOfHoursBeforeMeeting;
	private int alarmID, userID, eventID;

	public Alarm(int alarmID) throws SQLException{
		super("alarm", createTableFields(), "alarmID");
		ResultSet result = super.getFromDB(alarmID);
		if(result.next()) {
			this.alarmID = result.getInt("alarmID");
			this.eventID = result.getInt("eventID");
			this.userID = result.getInt("userID");
			this.numberOfHoursBeforeMeeting = result.getTime("numberOfHoursBeforeMeeting");
		}		
	}
	
	public Alarm() throws SQLException{
		super("Alarm", createTableFields(), "AlarmID");
		ArrayList<Integer> keyList = super.addToDB();
		this.alarmID = keyList.get(0);	
	}
	
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("alarmID");
		tableFields.add("eventID");
		tableFields.add("userID");
		tableFields.add("numberOfHoursBeforeMeeting");
		return tableFields;
	}


	public int getAlarmID() {
		return alarmID;
	}
	
	public int getUserID() {
		return userID;
	}

	public int getEventID() {
		return eventID;
	}
	
	public Time getNumberOfHoursBeforeMeeting() {
		return numberOfHoursBeforeMeeting;
	}

	public void setUserID(int userID) throws SQLException {
		super.updateField("userID", userID, alarmID);
		this.userID = userID;
	}

	public void setEventID(int eventID) throws SQLException {
		super.updateField("eventID", eventID, alarmID);
		this.eventID = eventID;
	}

	public void setNumberOfHoursBeforeMeeting(Time numberOfHoursBeforeMeeting) throws SQLException {
		super.updateField("numberOfhoursBeforeMeeting", numberOfHoursBeforeMeeting, alarmID);
		this.numberOfHoursBeforeMeeting = numberOfHoursBeforeMeeting;
	}

	@Override
	public void delete() throws SQLException {
		super.delete(alarmID);		
	}
}

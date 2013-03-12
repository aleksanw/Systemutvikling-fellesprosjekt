package model;

import java.sql.Time;
import java.util.ArrayList;

public class Alarm extends Model {
	
	private Time numberOfHourBeforeMeeting;
	
	public Alarm(){
		super("Alarm", createTableFields(), "Event_eventID", "User_userID");
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("Event_eventID");
		tableFields.add("User_userID");
		tableFields.add("nymberOfHoursBeforeMeeting");
		return tableFields;
	}
	
	public User getUser() {
		return new User();
	}
	
	public Event getEvent() {
		return new Event(true);
	}
	
}

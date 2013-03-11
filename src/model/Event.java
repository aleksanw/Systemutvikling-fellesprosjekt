package model;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Event extends Model{
	
	private int eventID;
	private boolean isActive, isAllDay;
	private final boolean isMeeting;
	private String name, description, location;
	private DateTime start, end;
	
	public Event(boolean isMeeting) {
		super("Event", createTableFields());
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
	
	public Room getBookedRoom() {
		return new Room();
	}
	
	public void setBookedRoom(Room room) {
		
	}
	
	public ArrayList<Invitation> getInvitationList() {
		return new ArrayList<Invitation>();
	}
	
	public void invite(User user) {
		
	}
}

package model;

import org.joda.time.DateTime;

public class Event extends Model{
	
	private int eventID;
	private boolean isActive, isAllDay;
	private String name, description, location;
	private DateTime start, end;
	
	public Room getBookedRoom() {
		return new Room();
	}
}

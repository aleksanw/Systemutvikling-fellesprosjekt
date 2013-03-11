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
		this.isMeeting = isMeeting;
	}
	
	public Room getBookedRoom() {
		return new Room();
	}
<<<<<<< HEAD
	
	public void setBookedRoom(Room room) {
		
	}
	
	public ArrayList<Invitation> getInvitationList() {
		return new ArrayList<Invitation>();
	}
	
	public void invite(User user) {
		
	}
	
	
	
}
=======
}
>>>>>>> Tulliball

package model;

import java.util.ArrayList;
import java.util.Date;

public class User extends Model {
	
	private int userID;
	private String name, email;
	private Date dateOfBirth;
	
	public boolean isCreatorOfEvent(Event event) {
		return true;
	}
	
	public ArrayList<Alarm> getAlarms() {
		return new ArrayList<Alarm>();
	}
	
	public ArrayList<Alarm> getAlarmsBeforeNow() {
		return new ArrayList<Alarm>();
	}
	
	public void addToGroup(Group group) {
		
	}
	
	public ArrayList<Event> getCreatedEvents() {
		return new ArrayList<Event>();
	}
	
	public ArrayList<Invitation> getInvitations() {
		return new ArrayList<Invitation>();
	}
}

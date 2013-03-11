package model;

import java.sql.Time;

public class Alarm extends Model {
	
	private Time numberOfHourBeforeMeeting;
	
	public User getUser() {
		return new User();
	}
	
	public Event getEvent() {
		return new Event(true);
	}
	
}

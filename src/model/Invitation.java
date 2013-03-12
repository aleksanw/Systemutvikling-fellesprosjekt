package model;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Invitation extends Model {
	
	private boolean isAttending;
	private DateTime timeDateOfInvitation;
	private Event invitedTo;
	
	public Invitation() {
		super("InvitedTo", createTableFields(), "User_userID", "Event_eventID");
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("User_userID");
		tableFields.add("Event_eventID");
		tableFields.add("isAttending");
		tableFields.add("dateOfInvitation");
		return tableFields;
	}
}

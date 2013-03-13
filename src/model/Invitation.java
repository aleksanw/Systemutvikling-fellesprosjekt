package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

public class Invitation extends Model {
	
	private boolean isAttending;
	private DateTime timeDateOfInvitation;
	private Event invitedTo;
	private int userID, eventID;
	
	public Invitation(int userID, int eventID) throws SQLException {
		super("InvitedTo", createTableFields(), "User_userID", "Event_eventID");
		ResultSet result = super.getFromDB(userID, eventID);
		if(result.next()) {
			this.userID = result.getInt("userID");
			this.eventID = result.getInt("eventID");
		}
	}
	
	public Invitation() {
		
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

package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Invitation extends Model {
	
	private boolean isAttending;
	private DateTime dateTimeOfInvitation;
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
	
	public Invitation(int userID, int eventID, DateTime dateTimeOfInvitation) throws SQLException {
		super("InvitedTo", createTableFields(), "User_userID", "Event_eventID");
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		String dateToString = fmt.print(dateTimeOfInvitation);
		String values = "'" + userID + "', '" + eventID + "', " +null+ ", '" + dateToString + "'";
		super.addRelationToDB(values);
		this.userID = userID;
		this.eventID = eventID;
		this.dateTimeOfInvitation = dateTimeOfInvitation;
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("User_userID");
		tableFields.add("Event_eventID");
		tableFields.add("isAttending");
		tableFields.add("dateOfInvitation");
		return tableFields;
	}
	
	public DateTime getDateTimeOfInvitation() {
		return dateTimeOfInvitation;
	}
}

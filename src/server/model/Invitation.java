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
	private int invitationID, userID, eventID;
	
	public Invitation(int invitationID) throws SQLException {
		super("InvitedTo", createTableFields(), "invitedToID");
		ResultSet result = super.getFromDB(invitationID);
		if(result.next()) {
			this.invitationID = result.getInt("invitedToID");
			this.userID = result.getInt("userID");
			this.eventID = result.getInt("eventID");
			this.isAttending = result.getBoolean("isAttending");
			this.dateTimeOfInvitation = new DateTime(result.getDate("dateOfInvitation"));
		}
	}

	public Invitation() throws SQLException {
		super("InvitedTo", createTableFields(), "invitedToID");
		ArrayList<Integer> keyList = super.addToDB();
		this.invitationID = keyList.get(0);
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("invitedToID");
		tableFields.add("User_userID");
		tableFields.add("Event_eventID");
		tableFields.add("isAttending");
		tableFields.add("dateOfInvitation");
		return tableFields;
	}
	
	public DateTime getDateTimeOfInvitation() {
		return dateTimeOfInvitation;
	}
	
	public boolean isAttending() {
		return isAttending;
	}

	public void setAttending(boolean isAttending) throws SQLException {
		super.updateField("isAttending", isAttending, invitationID);
		this.isAttending = isAttending;
	}

	public int getEventID() {
		return eventID;
	}

	public int getUserID() {
		return userID;
	}

	public void setDateTimeOfInvitation(DateTime dateTimeOfInvitation) throws SQLException {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		String dateToString = fmt.print(dateTimeOfInvitation);
		super.updateField("dateTimeOfInvitation", dateToString, invitationID);
		this.dateTimeOfInvitation = dateTimeOfInvitation;
	}

	public int getInvitationID() {
		return invitationID;
	}

	public void setUserID(int userID) throws SQLException {
		super.updateField("userID", userID, invitationID);
		this.userID = userID;
	}

	public void setEventID(int eventID) throws SQLException {
		super.updateField("eventID", eventID, invitationID);
		this.eventID = eventID;
	}
	
	@Override
	public void delete() throws SQLException {
		super.delete(invitationID);		
	}
}

package server.model;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import common.EventI;
import common.InvitationI;
import common.UserI;

import exceptions.ObjectNotFoundException;

public class Invitation extends Model implements InvitationI {

	private Boolean isAttending;
	private DateTime dateTimeOfInvitation;
	private int invitationID, userID, eventID;

	public Invitation(Integer invitationID) throws RemoteException,
			SQLException {
		super("InvitedTo", createTableFields(), "invitedToID");
		ResultSet result = super.getFromDB(invitationID);
		if (result.next()) {
			this.invitationID = result.getInt("invitedToID");
			this.userID = result.getInt("userID");
			this.eventID = result.getInt("eventID");
			this.isAttending = (Boolean)result.getObject("isAttending");
			this.dateTimeOfInvitation = new DateTime(
					result.getDate("dateOfInvitation"));
		}
	}

	public Invitation() throws RemoteException, SQLException {
		super("InvitedTo", createTableFields(), "invitedToID");
		ArrayList<Integer> keyList = super.addToDB();
		this.invitationID = keyList.get(0);
	}

	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("invitedToID");
		tableFields.add("userID");
		tableFields.add("eventID");
		tableFields.add("isAttending");
		tableFields.add("dateOfInvitation");
		return tableFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#getDateTimeOfInvitation()
	 */
	@Override
	public DateTime getDateTimeOfInvitation() {
		return dateTimeOfInvitation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#isAttending()
	 */
	@Override
	public Boolean isAttending() {
		return isAttending;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#setAttending(boolean)
	 */
	@Override
	public void setAttending(boolean isAttending) {
		super.updateField("isAttending", isAttending, invitationID);
		this.isAttending = isAttending;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#getEventID()
	 */
	@Override
	public EventI getEvent() {
		try {
			return new Event(eventID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#getUserID()
	 */
	@Override
	public UserI getUser() {
		try {
			return new User(userID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * server.model.InvitationI#setDateTimeOfInvitation(org.joda.time.DateTime)
	 */
	@Override
	public void setDateTimeOfInvitation(DateTime dateTimeOfInvitation) {
		DateTimeFormatter fmt = DateTimeFormat
				.forPattern("yyyy-MM-dd HH:mm:SS");
		String dateToString = fmt.print(dateTimeOfInvitation);
		super.updateField("dateTimeOfInvitation", dateToString, invitationID);
		this.dateTimeOfInvitation = dateTimeOfInvitation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#getInvitationID()
	 */
	@Override
	public int getInvitationID() {
		return invitationID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#setUserID(int)
	 */
	@Override
	public void setUser(UserI user) {
		int userID;
		try {
			userID = user.getUserID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		super.updateField("userID", userID, invitationID);
		this.userID = userID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#setEventID(int)
	 */
	@Override
	public void setEvent(EventI event) {
		int eventID;
		try {
			eventID = event.getEventID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		super.updateField("eventID", eventID, invitationID);
		this.eventID = eventID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.InvitationI#delete()
	 */
	@Override
	public void delete() {
		try {
			super.delete(invitationID);
		} catch (ObjectNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

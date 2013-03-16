package common;

import java.rmi.Remote;
import java.sql.SQLException;

import org.joda.time.DateTime;

public interface InvitationI extends Remote {

	public abstract DateTime getDateTimeOfInvitation();

	public abstract boolean isAttending();

	public abstract void setAttending(boolean isAttending) throws SQLException;

	public abstract int getEventID();

	public abstract int getUserID();

	public abstract void setDateTimeOfInvitation(DateTime dateTimeOfInvitation)
			throws SQLException;

	public abstract int getInvitationID();

	public abstract void setUserID(int userID) throws SQLException;

	public abstract void setEventID(int eventID) throws SQLException;

	public abstract void delete();

}
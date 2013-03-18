package common;

import java.sql.SQLException;

import org.joda.time.DateTime;

public interface InvitationI extends ModelI {

	public abstract DateTime getDateTimeOfInvitation();

	public abstract boolean isAttending();

	public abstract void setAttending(boolean isAttending) throws SQLException;

	public abstract EventI getEvent();

	public abstract UserI getUser();

	public abstract void setDateTimeOfInvitation(DateTime dateTimeOfInvitation)
			throws SQLException;

	public abstract int getInvitationID();

	public abstract void setUser(UserI user) throws SQLException;

	public abstract void setEvent(EventI event) throws SQLException;

	public abstract void delete();

}
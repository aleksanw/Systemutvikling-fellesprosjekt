package common;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.joda.time.DateTime;

public interface InvitationI extends ModelI {

	public abstract DateTime getDateTimeOfInvitation() throws SQLException, RemoteException;

	public abstract boolean isAttending() throws SQLException, RemoteException;

	public abstract void setAttending(boolean isAttending) throws SQLException, RemoteException;

	public abstract EventI getEvent() throws SQLException, RemoteException;

	public abstract UserI getUser() throws SQLException, RemoteException;

	public abstract void setDateTimeOfInvitation(DateTime dateTimeOfInvitation)
			throws SQLException, RemoteException;

	public abstract int getInvitationID() throws SQLException, RemoteException;

	public abstract void setUser(UserI user) throws SQLException, RemoteException;

	public abstract void setEvent(EventI event) throws SQLException, RemoteException;

	public abstract void delete() throws SQLException, RemoteException;

}
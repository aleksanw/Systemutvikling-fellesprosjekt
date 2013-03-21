package common;

import java.rmi.RemoteException;

import org.joda.time.DateTime;

public interface InvitationI extends ModelI {

	public abstract DateTime getDateTimeOfInvitation() throws RemoteException;

	public abstract Boolean isAttending() throws RemoteException;

	public abstract void setAttending(boolean isAttending)
			throws RemoteException;

	public abstract EventI getEvent() throws RemoteException;

	public abstract UserI getUser() throws RemoteException;

	public abstract void setDateTimeOfInvitation(DateTime dateTimeOfInvitation)
			throws RemoteException;

	public abstract int getInvitationID() throws RemoteException;

	public abstract void setUser(UserI user) throws RemoteException;

	public abstract void setEvent(EventI event) throws RemoteException;

	public abstract void delete() throws RemoteException;

}
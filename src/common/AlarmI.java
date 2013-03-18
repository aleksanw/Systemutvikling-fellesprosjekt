package common;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;

public interface AlarmI extends ModelI {

	public abstract int getAlarmID() throws RemoteException;

	public abstract UserI getUser() throws RemoteException;

	public abstract EventI getEvent() throws RemoteException;

	public abstract Time getNumberOfHoursBeforeMeeting() throws RemoteException;

	public abstract void setUserID(int userID) throws SQLException, RemoteException;
	public abstract void setUser(UserI user) throws SQLException, RemoteException;

	public abstract void setEventID(int eventID) throws SQLException, RemoteException;
	public abstract void setEvent(EventI event) throws SQLException, RemoteException;

	public abstract void setNumberOfHoursBeforeMeeting(Time numberOfHoursBeforeMeeting) throws RemoteException, SQLException;

	public abstract void delete() throws RemoteException;

}
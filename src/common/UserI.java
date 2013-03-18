package common;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Alarm;
import server.model.Event;
import server.model.Invitation;


public interface UserI extends ModelI {

	public abstract String getEmail()throws RemoteException, SQLException;

	public abstract void setEmail(String email) throws RemoteException, SQLException;

	public abstract Date getDateOfBirth()throws RemoteException, SQLException;

	public abstract boolean isCreatorOfEvent(EventI event)throws RemoteException, SQLException;

	public abstract ArrayList<Alarm> getAlarms()throws RemoteException, SQLException;

	public abstract ArrayList<Alarm> getAlarmsBeforeNow()throws RemoteException, SQLException;

	public abstract void addToGroup(GroupI group)throws RemoteException, SQLException;

	public abstract ArrayList<Event> getCreatedEvents() throws RemoteException, SQLException;

	public abstract ArrayList<Invitation> getInvitations()throws RemoteException, SQLException;

	public abstract int getUserID()throws RemoteException, SQLException;

	public abstract String getName()throws RemoteException, SQLException;

	public abstract void setName(String name) throws RemoteException, SQLException;

	public abstract void setDateOfBirth(Date dateOfBirth) throws RemoteException, SQLException;

	public abstract void delete() throws RemoteException;

}
package common;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import server.model.Alarm;
import server.model.Invitation;

public interface UserI extends ModelI {

	public abstract String getEmail() throws RemoteException;

	public abstract void setEmail(String email) throws RemoteException;

	public abstract Date getDateOfBirth() throws RemoteException;

	public abstract boolean isCreatorOfEvent(EventI event)
			throws RemoteException;

	public abstract ArrayList<Alarm> getAlarms() throws RemoteException;

	public abstract ArrayList<Alarm> getAlarmsBeforeNow()
			throws RemoteException;

	public abstract void addToGroup(GroupI group) throws RemoteException;

	public abstract ArrayList<EventI> getCreatedEvents() throws RemoteException;

	public abstract ArrayList<Invitation> getInvitations()
			throws RemoteException;

	public abstract int getUserID() throws RemoteException;

	public abstract String getName() throws RemoteException;

	public abstract void setName(String name) throws RemoteException;

	public abstract void setDateOfBirth(Date dateOfBirth)
			throws RemoteException;

	public abstract void delete() throws RemoteException;

}
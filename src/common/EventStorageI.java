package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Group;
import server.model.User;

public interface EventStorageI extends Remote {
	public EventI create() throws RemoteException;

	public EventI get(int ID) throws RemoteException;

	public void delete(int ID) throws RemoteException;

	public void delete(EventI model) throws RemoteException;

	public EventListI getEventList(ArrayList<User> users,
			ArrayList<Group> groups, WeekI week) throws RemoteException;
}

package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.model.Event;
import server.model.Group;
import server.model.User;

public interface EventListI extends ListModelI {

	public void nextDay() throws RemoteException;

	public void previousDay() throws RemoteException;

	public ArrayList<Event> getList() throws RemoteException;

	public ArrayList<User> getUsers() throws RemoteException;

	public void setUsers(ArrayList<User> users) throws RemoteException;

	public boolean add(User user) throws RemoteException;

	public boolean remove(User user) throws RemoteException;

	public ArrayList<Group> getGroups() throws RemoteException;

	public void setGroups(ArrayList<Group> groups) throws RemoteException;

	public boolean addGroup(Group group) throws RemoteException;

	public boolean removeGroup(Group group) throws RemoteException;

	public DateTime getDate() throws RemoteException;

	public void setDate(DateTime date) throws RemoteException;

}
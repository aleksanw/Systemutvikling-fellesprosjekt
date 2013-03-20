package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.joda.time.DateTime;

public interface EventListI extends ListModelI {

	public void nextDay() throws RemoteException;

	public void previousDay() throws RemoteException;

	public ArrayList<EventI> getList() throws RemoteException;

	public ArrayList<UserI> getUsers() throws RemoteException;

	public void setUsers(ArrayList<UserI> users) throws RemoteException;

	public boolean add(UserI user) throws RemoteException;

	public boolean remove(UserI user) throws RemoteException;

	public ArrayList<GroupI> getGroups() throws RemoteException;

	public void setGroups(ArrayList<GroupI> groups) throws RemoteException;

	public boolean addGroup(GroupI group) throws RemoteException;

	public boolean removeGroup(GroupI group) throws RemoteException;

	public DateTime getDate() throws RemoteException;

	public void setDate(DateTime date) throws RemoteException;

}
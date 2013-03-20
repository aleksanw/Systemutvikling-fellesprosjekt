package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.model.Event;
import server.model.Group;
import server.model.Model;
import server.model.User;
import server.system.StorageServer;

import common.EventListI;

public class EventList extends ListModel implements EventListI {
	private ArrayList<Event> list;

	private ArrayList<User> users;
	private ArrayList<Group> groups;
	private DateTime date;

	public EventList(ArrayList<User> users, ArrayList<Group> groups,
			DateTime date) throws RemoteException {
		this.users = users;
		this.groups = groups;
		this.date = date;

		refresh();
	}

	private int[] getUserIDs() throws RemoteException {
		int[] ids = new int[users.size()];

		for (int i = 0; i < ids.length; i++) {
			ids[i] = users.get(i).getUserID();
		}

		return ids;
	}

	private int[] getGroupIDs() throws RemoteException {
		int[] ids = new int[groups.size()];

		for (int i = 0; i < ids.length; i++) {
			ids[i] = groups.get(i).getGroupID();
		}

		return ids;
	}

	private static String intArraytoCommaSeperatedString(int[] list) {
		String string = "";

		for (int i = 0; i < list.length - 1; i++) {
			string += list[i] + ",";
		}
		string += list[list.length - 1];

		return string;
	}

	private void refresh() throws RemoteException {

		ArrayList<Event> oldList = (ArrayList<Event>) list.clone();

		list = new ArrayList<Event>();

		String query = "SELECT * FROM Event WHERE createdByUser IN ("
				+ intArraytoCommaSeperatedString(getUserIDs())
				+ ") OR createdByGroup IN ("
				+ intArraytoCommaSeperatedString(getGroupIDs()) + ")";

		ResultSet result = Model.getDB().readQuery(query);
		try {
			while (result.next()) {
				this.list.add(StorageServer.eventStorage.get(result
						.getInt("eventID")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		pcs.firePropertyChange("list", oldList, list);
	}

	public void nextDay() throws RemoteException {
		date.plusDays(1);
		refresh();
	}

	public void previousDay() throws RemoteException {
		date.plusDays(1);
		refresh();
	}

	public ArrayList<User> getUsers() throws RemoteException {
		return users;
	}

	public void setUsers(ArrayList<User> users) throws RemoteException {
		this.users = users;
		refresh();
	}

	public boolean add(User user) throws RemoteException {
		boolean r = users.add(user);
		refresh();
		return r;
	}

	public boolean remove(User user) throws RemoteException {
		boolean r = users.remove(user);
		refresh();
		return r;
	}

	public ArrayList<Group> getGroups() throws RemoteException {
		return groups;
	}

	public void setGroups(ArrayList<Group> groups) throws RemoteException {
		this.groups = groups;
		refresh();
	}

	public boolean addGroup(Group group) throws RemoteException {
		boolean r = groups.add(group);
		refresh();
		return r;
	}

	public boolean removeGroup(Group group) throws RemoteException {
		boolean r = groups.remove(group);
		refresh();
		return r;
	}

	public DateTime getDate() throws RemoteException {
		return date;
	}

	public void setDate(DateTime date) throws RemoteException {
		this.date = date;
		refresh();
	}

	@Override
	public ArrayList<Event> getList() throws RemoteException {
		return list;
	}
}

package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.model.Model;
import server.system.StorageServer;

import common.EventI;
import common.EventListI;
import common.GroupI;
import common.UserI;

public class EventList extends ListModel implements EventListI {
	private ArrayList<EventI> list;

	private ArrayList<UserI> users;
	private ArrayList<GroupI> groups;
	private DateTime date;

	public EventList(ArrayList<UserI> users, ArrayList<GroupI> groups,
			DateTime date) throws RemoteException {
		this.users = users;
		this.groups = groups;
		this.date = date;

		refresh();
	}

	private int[] getUserIDs() throws RemoteException {
		int[] ids = new int[users.size()];

		for (int i = 0; i < ids.length-1; i++) {
			ids[i] = users.get(i).getUserID();
		}

		return ids;
	}

	private int[] getGroupIDs() throws RemoteException {
		int[] ids = new int[groups.size()];

		for (int i = 0; i < ids.length-1; i++) {
			ids[i] = groups.get(i).getGroupID();
		}

		return ids;
	}

	private static String intArraytoCommaSeperatedString(int[] list) {
		String string = "";

		for (int i = 0; i < list.length - 1; i++) {
			string += list[i] + ",";
		}
		string += list[list.length -1];

		return string;
	}

	private void refresh() throws RemoteException {

		//ArrayList<EventI> oldList = (ArrayList<EventI>) list.clone();

		list = new ArrayList<EventI>();
		String query = "SELECT * FROM Event WHERE start=";
		if(groups.size() < 1) {
			query += "createdByUser IN ("
					+ intArraytoCommaSeperatedString(getUserIDs())
					+ ");";
		} else if (users.size() <1) {
			query += "createdByGroup IN ("
					+ intArraytoCommaSeperatedString(getGroupIDs()) + ");";
		} else {

			query += "createdByUser IN ("
					+ intArraytoCommaSeperatedString(getUserIDs())
					+ ") OR createdByGroup IN ("
					+ intArraytoCommaSeperatedString(getGroupIDs()) + ");";
		}
		ResultSet result = Model.getDB().readQuery(query);
		try {
			while (result.next()) {
				this.list.add(StorageServer.eventStorage.get(result
						.getInt("eventID")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		//pcs.firePropertyChange("list", oldList, list);
	}

	public void nextDay() throws RemoteException {
		date.plusDays(1);
		refresh();
	}

	public void previousDay() throws RemoteException {
		date.plusDays(1);
		refresh();
	}

	public ArrayList<UserI> getUsers() throws RemoteException {
		return users;
	}

	public void setUsers(ArrayList<UserI> users) throws RemoteException {
		this.users = users;
		refresh();
	}

	public boolean add(UserI user) throws RemoteException {
		boolean r = users.add(user);
		refresh();
		return r;
	}

	public boolean remove(UserI user) throws RemoteException {
		boolean r = users.remove(user);
		refresh();
		return r;
	}

	public ArrayList<GroupI> getGroups() throws RemoteException {
		return groups;
	}

	public void setGroups(ArrayList<GroupI> groups) throws RemoteException {
		this.groups = groups;
		refresh();
	}

	public boolean addGroup(GroupI group) throws RemoteException {
		boolean r = groups.add(group);
		refresh();
		return r;
	}

	public boolean removeGroup(GroupI group) throws RemoteException {
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
	public ArrayList<EventI> getList() throws RemoteException {
		return list;
	}
}

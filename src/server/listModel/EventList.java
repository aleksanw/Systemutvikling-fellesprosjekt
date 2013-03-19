package server.listModel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.model.Event;
import server.model.Group;
import server.model.User;

import common.EventListI;

public class EventList extends ListModel implements EventListI {
	private ArrayList<Event> events;

	private ArrayList<User> users;
	private ArrayList<Group> groups;
	// TODO: This should be a Week object
	private DateTime date;

	// TODO: private ListListner ll;

	public EventList(ArrayList<User> users, ArrayList<Group> groups,
			DateTime date) throws RemoteException {
		this.users = users;
		this.groups = groups;
		this.date = date;

		refresh();
	}

	private int[] getUserIDs() {
		int[] ids = new int[users.size()];

		for (int i = 0; i < ids.length; i++) {
			ids[i] = users.get(i).getUserID();
		}

		return ids;
	}

	private int[] getGroupIDs() {
		int[] ids = new int[groups.size()];

		for (int i = 0; i < ids.length; i++) {
			ids[i] = groups.get(i).getGroupID();
		}

		return ids;
	}

	public void refresh() {
		// TODO: Update
	}

	public void nextDay() {
		date.plusDays(1);
		refresh();
	}

	public void previousDay() {
		date.plusDays(1);
		refresh();
	}

	public ArrayList<Event> toArrayList() {
		return events;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
		refresh();
	}

	public boolean add(User user) {
		boolean r = users.add(user);
		refresh();
		return r;
	}

	public boolean remove(User user) {
		boolean r = users.remove(user);
		refresh();
		return r;
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
		refresh();
	}

	public boolean addGroup(Group group) {
		boolean r = groups.add(group);
		refresh();
		return r;
	}

	public boolean removeGroup(Group group) {
		boolean r = groups.remove(group);
		refresh();
		return r;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
		refresh();
	}

	@Override
	public ArrayList<Event> getList() throws RemoteException {
		return events;
	}
}

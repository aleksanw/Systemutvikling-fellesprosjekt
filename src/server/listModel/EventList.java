package server.listModel;

import java.util.ArrayList;

import server.model.Event;
import server.model.Group;
import server.model.User;

import common.EventListI;
import common.WeekI;

public class EventList extends ListModel implements EventListI {
	private ArrayList<Event> events;

	private ArrayList<User> users;
	private ArrayList<Group> groups;
	// TODO: This should be a Week object
	private WeekI week;

	// TODO: private ListListner ll;

	public EventList(ArrayList<User> users, ArrayList<Group> groups, WeekI week) {
		this.users = users;
		this.groups = groups;
		this.week = week;

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

	public void nextWeek() {
		week = week.getNextWeek();
		refresh();
	}

	public void previousWeek() {
		week = week.getPreviousWeek();
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

	public WeekI getWeek() {
		return week;
	}

	public void setWeek(WeekI week) {
		this.week = week;
		refresh();
	}
}

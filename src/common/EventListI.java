package common;

import java.util.ArrayList;

import server.model.Event;
import server.model.Group;
import server.model.User;

public interface EventListI extends ListModelI {

	public void refresh();

	public void nextWeek();

	public void previousWeek();

	public ArrayList<Event> getList();

	public ArrayList<User> getUsers();

	public void setUsers(ArrayList<User> users);

	public boolean add(User user);

	public boolean remove(User user);

	public ArrayList<Group> getGroups();

	public void setGroups(ArrayList<Group> groups);

	public boolean addGroup(Group group);

	public boolean removeGroup(Group group);

	public WeekI getWeek();

	public void setWeek(WeekI week);

}
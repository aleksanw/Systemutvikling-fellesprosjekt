package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Group extends Model {

	private int groupID;
	private String groupName;
	
	public Group getParentGroup() {
		return new Group();
	}
	
	public ArrayList<Group> getChildrenGroups() {
		return new ArrayList<Group>();
	}
	
	public ArrayList<User> getUsers() {
		return new ArrayList<User>();
	}
	
	public void addUser(User user) {
		
	}
	
	public void removeUser(User user) {
		
	}

	public ArrayList<Event> getEvents() {
		return new ArrayList<Event>();
	}
}
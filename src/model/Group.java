package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Group extends Model {

	private int groupID;
	private String groupName;
	
	public Group(int groupID) throws SQLException {
		super("Groups", createTableFields(), "groupID", null);
		ResultSet result = super.getFromDB(groupID);
		if(result.next()) {
			this.groupID = result.getInt("groupID");
			this.groupName = result.getString("groupName");
		}
	}
	
	public Group(String groupName) throws SQLException {
		super("Groups", createTableFields(), "groupID", null);
		String values = "'" + groupName + "'";
		ArrayList<Integer> keyList = super.addToDB(values);
		this.groupID = keyList.get(0);
		this.groupName = groupName;
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("GroupID");
		tableFields.add("groupName");
		return tableFields;
	}
	
	public Group getParentGroup() throws SQLException {
		return new Group(0);
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
	
	public String getGroupName() {
		return this.groupName;
	}
}

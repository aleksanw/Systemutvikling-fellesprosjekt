package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class User extends Model {
	
	private int userID;
	private String name, email;
	private Date dateOfBirth;
	
	
	public User(int userID) {
		super("User", createTableFields(), "userID", null);
		
	}
	
	public User(String userName, String password, String name) throws SQLException {
		super("User", createTableFields(), "userID", null);
		this.name = name;
		String values = "'" + userName + "', '" + password + "', '" + name +"', '', '0000-00-00'";
		super.addToDB(values);
		
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("userID");
		tableFields.add("username");
		tableFields.add("password");
		tableFields.add("name");
		tableFields.add("email");
		tableFields.add("dateOfBirth");
		return tableFields;
	}
	
	public boolean isCreatorOfEvent(Event event) {
		return true;
	}
	
	public ArrayList<Alarm> getAlarms() {
		return new ArrayList<Alarm>();
	}
	
	public ArrayList<Alarm> getAlarmsBeforeNow() {
		return new ArrayList<Alarm>();
	}
	
	public void addToGroup(Group group) {
		
	}
	
	public ArrayList<Event> getCreatedEvents() {
		return new ArrayList<Event>();
	}
	
	public ArrayList<Invitation> getInvitations() {
		return new ArrayList<Invitation>();
	}
}

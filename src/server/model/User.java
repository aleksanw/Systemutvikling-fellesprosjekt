package server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class User extends Model {
	
	private int userID;
	private String name, email;
	private Date dateOfBirth;
	public String userName;
	
		
	
	public User(int userID) throws SQLException {
		super("User", createTableFields(), "userID");
		ResultSet result = super.getFromDB(userID);
		if(result.next()) {
			this.userID = result.getInt("userID");
			this.name = result.getString("name");
			this.email = result.getString("email");
			this.dateOfBirth = result.getDate("dateOfBirth");
		}
	}
	
	public User(String username, String password) throws SQLException {
		super("User", createTableFields(), "userID");
		String query = "SELECT userID FROM User WHERE username='' AND password='';";
		ResultSet result = super.getDB().readQuery(query);
		result.getInt("userID");
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException {
		super.updateField(email, email, userID);
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public User() throws SQLException {
		super("User", createTableFields(), "userID");
		ArrayList<Integer> keyList = super.addToDB();
		this.userID = keyList.get(0);
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
	
	public int getUserID() {
		return this.userID;
	}
	public String getName() {
		return this.name;
	}

	public void setName(String name) throws SQLException {
		super.updateField("name", name, userID);
		this.name = name;
	}

	public void setDateOfBirth(Date dateOfBirth) throws SQLException {
		super.updateField("dateOfBirth", dateOfBirth, userID);
		this.dateOfBirth = dateOfBirth;
	}

	
}

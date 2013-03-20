package server.model;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.EventI;
import common.GroupI;
import common.UserI;

import exceptions.ObjectNotFoundException;

public class User extends Model implements UserI {

	private int userID;
	private String name, email;
	private Date dateOfBirth;
	public String userName;

	public User(Integer userID) throws RemoteException {
		super("User", createTableFields(), "userID");
		ResultSet result = super.getFromDB(userID);
		try {
			if (result.next()) {
				this.userID = result.getInt("userID");
				this.name = result.getString("name");
				this.email = result.getString("email");
				this.dateOfBirth = result.getDate("dateOfBirth");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public User(String username, String password) throws RemoteException {
		super("User", createTableFields(), "userID");
		String query = "SELECT userID FROM User WHERE username='" + username
				+ "' AND password='" + password + "';";
		System.out.println(query);
		ResultSet result = super.getDB().readQuery(query);
		try {
			if (result.next())
				this.userID = result.getInt("userID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public User() throws RemoteException, SQLException {
		super("User", createTableFields(), "userID");
		ArrayList<Integer> keyList = super.addToDB();
		this.userID = keyList.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		super.updateField(email, email, userID);
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getDateOfBirth()
	 */
	@Override
	public Date getDateOfBirth() {
		return dateOfBirth;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#isCreatorOfEvent(common.EventI)
	 */
	@Override
	public boolean isCreatorOfEvent(EventI event) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getAlarms()
	 */
	@Override
	public ArrayList<Alarm> getAlarms() {
		return new ArrayList<Alarm>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getAlarmsBeforeNow()
	 */
	@Override
	public ArrayList<Alarm> getAlarmsBeforeNow() {
		return new ArrayList<Alarm>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#addToGroup(server.model.GroupI)
	 */
	@Override
	public void addToGroup(GroupI group) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getCreatedEvents()
	 */
	@Override
	public ArrayList<EventI> getCreatedEvents() throws RemoteException {
		ArrayList<EventI> events = new ArrayList<EventI>();
		String query = "SELECT eventID FROM Event WHERE createdByUser="
				+ this.userID + ";";
		ResultSet result = Model.getDB().readQuery(query);
		try {
			while (result.next()) {
				events.add(new Event((result.getInt("eventID"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return events;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getInvitations()
	 */
	@Override
	public ArrayList<Invitation> getInvitations() {
		return new ArrayList<Invitation>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getUserID()
	 */
	@Override
	public int getUserID() {
		return this.userID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		super.updateField("name", name, userID);
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#setDateOfBirth(java.sql.Date)
	 */
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		super.updateField("dateOfBirth", dateOfBirth, userID);
		this.dateOfBirth = dateOfBirth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.UserI#delete()
	 */
	@Override
	public void delete() {
		try {
			super.delete(userID);
		} catch (ObjectNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

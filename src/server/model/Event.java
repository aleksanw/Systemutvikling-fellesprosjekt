package server.model;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import server.system.StorageServer;

import common.EventI;
import common.GroupI;
import common.RoomI;
import common.UserI;

import exceptions.ObjectNotFoundException;

public class Event extends Model implements EventI{
	
	private int eventID;
	private boolean isActive, isWholeDay;
	private boolean isMeeting;
	private String eventName, description, location;

	private DateTime start, end;
	private boolean isWholeday;
	private int roomBooked;
	private int createdByUser;
	private int createdByGroup;
	
	
	public Event(Integer eventID) throws RemoteException, SQLException {
		super("Event", createTableFields(), "eventID");
		ResultSet result = super.getFromDB(eventID);
		if(result.next()) {
			this.eventID = result.getInt("eventID");
			this.eventName = result.getString("eventName");
			this.isActive = result.getBoolean("isActive");
			this.start = new DateTime(result.getDate("start"));
			this.end = new DateTime(result.getDate("end"));
			this.isWholeday = result.getBoolean("isWholeDay");
			this.description = result.getString("description");
			this.location = result.getString("location");
			this.isMeeting = result.getBoolean("isMeeting");
			this.roomBooked = result.getInt("roomBooked");
			this.createdByUser = result.getInt("createdByUser");
			this.createdByGroup = result.getInt("createdByGroup");
		}	
	}
	
	public Event() throws RemoteException, SQLException {
		super("Event", createTableFields(), "eventID");
		ArrayList<Integer> keyList = super.addToDB();
		this.eventID = keyList.get(0);
	}
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("eventID");
		tableFields.add("eventName");
		tableFields.add("isActive");
		tableFields.add("start");
		tableFields.add("end");
		tableFields.add("isWholeDay");
		tableFields.add("description");
		tableFields.add("location");
		tableFields.add("isMeeting");
		tableFields.add("roomBooked");
		tableFields.add("createdByUser");
		tableFields.add("createdByGroup");
		return tableFields;
	}
	
	/* (non-Javadoc)
	 * @see server.model.EventI#getInvitationList()
	 */
	@Override
	public ArrayList<Invitation> getInvitationList() {
		return new ArrayList<Invitation>();
	}
	
	/* (non-Javadoc)
	 * @see server.model.EventI#invite(server.model.User)
	 */
	@Override
	public void invite(UserI user) {
		
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getEventID()
	 */
	@Override
	public int getEventID() {
		return eventID;
	}
	
	/* (non-Javadoc)
	 * @see server.model.EventI#isWholeday()
	 */
	@Override
	public boolean isWholeday() {
		return isWholeday;
	}
	
	/* (non-Javadoc)
	 * @see server.model.EventI#setWholeday(boolean)
	 */
	@Override
	public void setWholeday(boolean isWholeday) {
		this.isWholeday = isWholeday;
	}
	
	/* (non-Javadoc)
	 * @see server.model.EventI#setMeeting(boolean)
	 */
	@Override
	public void setMeeting(boolean isMeeting) {
		this.isMeeting = isMeeting;
	}
	
	/* (non-Javadoc)
	 * @see server.model.EventI#isActive()
	 */
	@Override
	public boolean isActive() {
		return isActive;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setActive(boolean)
	 */
	@Override
	public void setActive(boolean isActive) throws SQLException {
		super.updateField("isActive", isActive, eventID);
		this.isActive = isActive;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#isWholeDay()
	 */
	@Override
	public boolean isWholeDay() {
		return isWholeDay;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setWholeDay(boolean)
	 */
	@Override
	public void setWholeDay(boolean isWholeDay) throws SQLException {
		super.updateField("isWholeDay", isWholeDay, eventID);
		this.isWholeDay = isWholeDay;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getEventName()
	 */
	@Override
	public String getEventName() {
		return eventName;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setEventName(java.lang.String)
	 */
	@Override
	public void setEventName(String eventName) throws SQLException {
		super.updateField("eventName", eventName, eventID);
		this.eventName = eventName;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) throws SQLException {
		super.updateField("description", description, eventID);
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getLocation()
	 */
	@Override
	public String getLocation() {
		return location;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setLocation(java.lang.String)
	 */
	@Override
	public void setLocation(String location) throws SQLException {
		super.updateField("location", location, eventID);
		this.location = location;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getStart()
	 */
	@Override
	public DateTime getStart() {
		return start;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setStart(org.joda.time.DateTime)
	 */
	@Override
	public void setStart(DateTime start) throws SQLException {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		String dateToString = fmt.print(start);
		super.updateField("start", dateToString, eventID);
		this.start = start;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getEnd()
	 */
	@Override
	public DateTime getEnd() {
		return end;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setEnd(org.joda.time.DateTime)
	 */
	@Override
	public void setEnd(DateTime end) throws SQLException{
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		String dateToString = fmt.print(end);
		super.updateField("end", dateToString, eventID);
		this.end = end;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getRoomBooked()
	 */
	@Override
	public Room getRoomBooked() throws RemoteException {
		return StorageServer.roomStorage.get(roomBooked);
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setRoomBooked(int)
	 */
	@Override
	public void setRoomBooked(int roomBooked) throws SQLException {
		super.updateField("roomBooked",roomBooked, eventID);
		this.roomBooked = roomBooked;
	}
	
	public void setRoomBooked(RoomI roomBooked) throws SQLException, RemoteException {
		setRoomBooked(roomBooked.getRoomID());
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getCreatedByUser()
	 */
	@Override
	public int getCreatedByUser() {
		return createdByUser;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setCreatedByUser(int)
	 */
	@Override
	public void setCreatedByUser(int createdByUser) throws SQLException {
		super.updateField("createdByUser", createdByUser, eventID);
		this.createdByUser = createdByUser;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#getCreatedByGroup()
	 */
	@Override
	public int getCreatedByGroup() {
		return createdByGroup;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#setCreatedByGroup(int)
	 */
	@Override
	public void setCreatedByGroup(int createdByGroup) throws SQLException {
		super.updateField("createdByGroup", createdByGroup, eventID);
		this.createdByGroup = createdByGroup;
	}

	/* (non-Javadoc)
	 * @see server.model.EventI#isMeeting()
	 */
	@Override
	public boolean isMeeting() {
		return isMeeting;
	}
	
	/* (non-Javadoc)
	 * @see server.model.EventI#delete()
	 */
	
	@Override
	public void delete() {
		try {
			super.delete(eventID);
		} catch (ObjectNotFoundException e) {
			throw new RuntimeException(e);
		}		
	}

	@Override
	public void setCreatedByUser(UserI createdByUser) throws SQLException,RemoteException {
		setCreatedByUser(createdByUser.getUserID());	
	}

	@Override
	public void setCreatedByGroup(GroupI createdByGroup) throws SQLException,RemoteException {
		setCreatedByGroup(createdByGroup.getGroupID());
	}
}

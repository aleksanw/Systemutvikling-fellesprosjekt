kakepackage server.model;

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

public class Event extends Model implements EventI {

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
		if (result.next()) {
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

	public ArrayList<Invitation> getInvitationList() {
		return new ArrayList<Invitation>();
	}

	public void invite(UserI user) {

	}

	public int getEventID() {
		return eventID;
	}

	public boolean isWholeday() {
		return isWholeday;
	}

	public void setWholeday(boolean isWholeday) {
		this.isWholeday = isWholeday;
	}

	public void setMeeting(boolean isMeeting) {
		this.isMeeting = isMeeting;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		super.updateField("isActive", isActive, eventID);
		this.isActive = isActive;
	}

	public boolean isWholeDay() {
		return isWholeDay;
	}

	public void setWholeDay(boolean isWholeDay) {
		super.updateField("isWholeDay", isWholeDay, eventID);
		this.isWholeDay = isWholeDay;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		super.updateField("eventName", eventName, eventID);
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		super.updateField("description", description, eventID);
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	@Override
	public void setLocation(String location) {
		super.updateField("location", location, eventID);
		this.location = location;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		DateTimeFormatter fmt = DateTimeFormat
				.forPattern("yyyy-MM-dd HH:mm:SS");
		String dateToString = fmt.print(start);
		super.updateField("start", dateToString, eventID);
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		DateTimeFormatter fmt = DateTimeFormat
				.forPattern("yyyy-MM-dd HH:mm:SS");
		String dateToString = fmt.print(end);
		super.updateField("end", dateToString, eventID);
		this.end = end;
	}

	public Room getRoomBooked() throws RemoteException {
		return StorageServer.roomStorage.get(roomBooked);
	}

	public void setRoomBooked(int roomBooked) {
		super.updateField("roomBooked", roomBooked, eventID);
		this.roomBooked = roomBooked;
	}

	public void setRoomBooked(RoomI roomBooked) {
		try {
			setRoomBooked(roomBooked.getRoomID());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public User getCreatedByUser() throws RemoteException {
		return StorageServer.userStorage.get(createdByUser);
	}

	public void setCreatedByUser(int createdByUser) {
		super.updateField("createdByUser", createdByUser, eventID);
		this.createdByUser = createdByUser;
	}

	public Group getCreatedByGroup() throws RemoteException {
		return StorageServer.groupStorage.get(createdByGroup);
	}

	public void setCreatedByGroup(int createdByGroup) {
		super.updateField("createdByGroup", createdByGroup, eventID);
		this.createdByGroup = createdByGroup;
	}

	public boolean isMeeting() {
		return isMeeting;
	}

	public void delete() {
		try {
			super.delete(eventID);
		} catch (ObjectNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void setCreatedByUser(UserI createdByUser) {
		try {
			setCreatedByUser(createdByUser.getUserID());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public void setCreatedByGroup(GroupI createdByGroup) {
		try {
			setCreatedByGroup(createdByGroup.getGroupID());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

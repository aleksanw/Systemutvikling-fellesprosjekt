package server.model;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import common.RoomI;

public class Room extends Model implements RoomI {

	private int roomID, personCapacity;
	private String roomName;

	public Room(Integer roomID) throws RemoteException, SQLException {
		super("Room", createTableFields(), "roomID");
		ResultSet result = super.getFromDB(roomID);
		if (result.next()) {
			this.roomID = result.getInt("roomID");
			this.roomName = result.getString("roomName");
			this.personCapacity = result.getInt("personCapacity");
		}
	}

	public Room() throws RemoteException, SQLException {
		super("Room", createTableFields(), "roomID");
		ArrayList<Integer> keyList = super.addToDB();
		this.roomID = keyList.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.RoomI#getRoomID()
	 */
	@Override
	public int getRoomID() {
		return roomID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.RoomI#getPersonCapacity()
	 */
	@Override
	public int getPersonCapacity() {
		return personCapacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.RoomI#getRoomName()
	 */
	@Override
	public String getRoomName() {
		return roomName;
	}

	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("roomID");
		tableFields.add("roomName");
		tableFields.add("personCapacity");
		return tableFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.RoomI#isBookedInPeriod(org.joda.time.DateTime,
	 * org.joda.time.DateTime)
	 */
	@Override
	public boolean isBookedInPeriod(DateTime start, DateTime end) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.RoomI#setPersonCapacity(int)
	 */
	@Override
	public void setPersonCapacity(int personCapacity) throws SQLException {
		super.updateField("personCapacity", personCapacity, roomID);
		this.personCapacity = personCapacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.RoomI#setRoomName(java.lang.String)
	 */
	@Override
	public void setRoomName(String roomName) throws SQLException {
		super.updateField("roomName", roomName, roomID);
		this.roomName = roomName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see server.model.RoomI#delete()
	 */
	@Override
	public void delete() {
		super.delete(roomID);
	}
}

package common;

import java.rmi.Remote;
import java.sql.SQLException;

import org.joda.time.DateTime;

public interface RoomI extends Remote {

	public abstract int getRoomID();

	public abstract int getPersonCapacity();

	public abstract String getRoomName();

	public abstract boolean isBookedInPeriod(DateTime start, DateTime end);

	public abstract void setPersonCapacity(int personCapacity)
			throws SQLException;

	public abstract void setRoomName(String roomName) throws SQLException;

	public abstract void delete();

}
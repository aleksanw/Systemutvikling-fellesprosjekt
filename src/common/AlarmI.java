package common;

import java.sql.SQLException;
import java.sql.Time;

public interface AlarmI extends ModelI {

	public abstract int getAlarmID();

	public abstract int getUserID();

	public abstract int getEventID();

	public abstract Time getNumberOfHoursBeforeMeeting();

	public abstract void setUserID(int userID) throws SQLException;

	public abstract void setEventID(int eventID) throws SQLException;

	public abstract void setNumberOfHoursBeforeMeeting(
			Time numberOfHoursBeforeMeeting) throws SQLException;

	public abstract void delete();

}
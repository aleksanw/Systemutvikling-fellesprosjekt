package server.model;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import common.AlarmI;

public class Alarm extends Model implements AlarmI {
	
	private Time numberOfHoursBeforeMeeting;
	private int alarmID, userID, eventID;

	public Alarm(int alarmID) throws RemoteException, SQLException{
		super("alarm", createTableFields(), "alarmID");
		ResultSet result = super.getFromDB(alarmID);
		if(result.next()) {
			this.alarmID = result.getInt("alarmID");
			this.eventID = result.getInt("eventID");
			this.userID = result.getInt("userID");
			this.numberOfHoursBeforeMeeting = result.getTime("numberOfHoursBeforeMeeting");
		}		
	}
	
	public Alarm() throws RemoteException, SQLException{
		super("Alarm", createTableFields(), "AlarmID");
		ArrayList<Integer> keyList = super.addToDB();
		this.alarmID = keyList.get(0);	
	}
	
	
	private static ArrayList<String> createTableFields() {
		ArrayList<String> tableFields = new ArrayList<String>();
		tableFields.add("alarmID");
		tableFields.add("eventID");
		tableFields.add("userID");
		tableFields.add("numberOfHoursBeforeMeeting");
		return tableFields;
	}


	/* (non-Javadoc)
	 * @see server.model.AlarmI#getAlarmID()
	 */
	@Override
	public int getAlarmID() {
		return alarmID;
	}
	
	/* (non-Javadoc)
	 * @see server.model.AlarmI#getUserID()
	 */
	@Override
	public int getUserID() {
		return userID;
	}

	/* (non-Javadoc)
	 * @see server.model.AlarmI#getEventID()
	 */
	@Override
	public int getEventID() {
		return eventID;
	}
	
	/* (non-Javadoc)
	 * @see server.model.AlarmI#getNumberOfHoursBeforeMeeting()
	 */
	@Override
	public Time getNumberOfHoursBeforeMeeting() {
		return numberOfHoursBeforeMeeting;
	}

	/* (non-Javadoc)
	 * @see server.model.AlarmI#setUserID(int)
	 */
	@Override
	public void setUserID(int userID) throws SQLException {
		super.updateField("userID", userID, alarmID);
		this.userID = userID;
	}

	/* (non-Javadoc)
	 * @see server.model.AlarmI#setEventID(int)
	 */
	@Override
	public void setEventID(int eventID) throws SQLException {
		super.updateField("eventID", eventID, alarmID);
		this.eventID = eventID;
	}

	/* (non-Javadoc)
	 * @see server.model.AlarmI#setNumberOfHoursBeforeMeeting(java.sql.Time)
	 */
	@Override
	public void setNumberOfHoursBeforeMeeting(Time numberOfHoursBeforeMeeting) throws SQLException {
		super.updateField("numberOfhoursBeforeMeeting", numberOfHoursBeforeMeeting, alarmID);
		this.numberOfHoursBeforeMeeting = numberOfHoursBeforeMeeting;
	}

	/* (non-Javadoc)
	 * @see server.model.AlarmI#delete()
	 */
	@Override
	public void delete() {
		super.delete(alarmID);		
	}
}

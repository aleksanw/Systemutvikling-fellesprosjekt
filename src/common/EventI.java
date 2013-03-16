package common;

import java.rmi.Remote;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.model.Invitation;

public interface EventI extends Remote {

	public ArrayList<Invitation> getInvitationList();

	public void invite(UserI user);

	public int getEventID();

	public boolean isWholeday();

	public void setWholeday(boolean isWholeday);

	public void setMeeting(boolean isMeeting);

	public boolean isActive();

	public void setActive(boolean isActive) throws SQLException;

	public boolean isWholeDay();

	public void setWholeDay(boolean isWholeDay) throws SQLException;

	public String getEventName();

	public void setEventName(String eventName) throws SQLException;

	public String getDescription();

	public void setDescription(String description) throws SQLException;

	public String getLocation();

	public void setLocation(String location) throws SQLException;

	public DateTime getStart();

	public void setStart(DateTime start) throws SQLException;

	public DateTime getEnd();

	public void setEnd(DateTime end) throws SQLException;

	public int getRoomBooked();

	public void setRoomBooked(int roomBooked) throws SQLException;

	public int getCreatedByUser();

	public void setCreatedByUser(int createdByUser)
			throws SQLException;

	public int getCreatedByGroup();

	public void setCreatedByGroup(int createdByGroup)
			throws SQLException;

	public boolean isMeeting();

	public void delete();

}
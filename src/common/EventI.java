package common;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.model.Invitation;

public interface EventI extends ModelI {

	public ArrayList<Invitation> getInvitationList() throws RemoteException;

	public void invite(UserI user) throws RemoteException;

	public int getEventID() throws RemoteException;

	public boolean isWholeday() throws RemoteException;

	public void setWholeday(boolean isWholeday) throws RemoteException;

	public void setMeeting(boolean isMeeting) throws RemoteException;

	public boolean isActive() throws RemoteException;

	public void setActive(boolean isActive) throws SQLException, RemoteException;

	public boolean isWholeDay() throws RemoteException;

	public void setWholeDay(boolean isWholeDay) throws SQLException, RemoteException;

	public String getEventName() throws RemoteException;

	public void setEventName(String eventName) throws SQLException, RemoteException;

	public String getDescription() throws RemoteException;

	public void setDescription(String description) throws SQLException, RemoteException;

	public String getLocation() throws RemoteException;

	public void setLocation(String location) throws SQLException, RemoteException;

	public DateTime getStart() throws RemoteException;

	public void setStart(DateTime start) throws SQLException, RemoteException;

	public DateTime getEnd() throws RemoteException;

	public void setEnd(DateTime end) throws SQLException, RemoteException;

	public int getRoomBooked() throws RemoteException;

	public void setRoomBooked(int roomBooked) throws SQLException, RemoteException;

	public int getCreatedByUser() throws RemoteException;

	public void setCreatedByUser(int createdByUser)
			throws SQLException, RemoteException;

	public int getCreatedByGroup() throws RemoteException;

	public void setCreatedByGroup(int createdByGroup)
			throws SQLException, RemoteException;

	public boolean isMeeting() throws RemoteException;

	public void delete() throws RemoteException;
}
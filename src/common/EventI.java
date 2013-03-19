package common;

import java.rmi.RemoteException;
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

	public void setActive(boolean isActive) throws RemoteException;

	public boolean isWholeDay() throws RemoteException;

	public void setWholeDay(boolean isWholeDay) throws RemoteException;

	public String getEventName() throws RemoteException;

	public void setEventName(String eventName) throws RemoteException;

	public String getDescription() throws RemoteException;

	public void setDescription(String description) throws RemoteException;

	public String getLocation() throws RemoteException;

	public void setLocation(String location) throws RemoteException;

	public DateTime getStart() throws RemoteException;

	public void setStart(DateTime start) throws RemoteException;

	public DateTime getEnd() throws RemoteException;

	public void setEnd(DateTime end) throws RemoteException;

	public RoomI getRoomBooked() throws RemoteException;

	public void setRoomBooked(int roomID) throws RemoteException;

	public void setRoomBooked(RoomI room) throws RemoteException;

	public int getCreatedByUser() throws RemoteException;

	public void setCreatedByUser(int createdByUser) throws RemoteException;

	public void setCreatedByUser(UserI createdByUser) throws RemoteException;

	public int getCreatedByGroup() throws RemoteException;

	public void setCreatedByGroup(int createdByGroup) throws RemoteException;

	public void setCreatedByGroup(GroupI createdByGroup) throws RemoteException;

	public boolean isMeeting() throws RemoteException;

	public void delete() throws RemoteException;
}
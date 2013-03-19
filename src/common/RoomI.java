package common;

import java.rmi.RemoteException;

import org.joda.time.DateTime;

public interface RoomI extends ModelI {

	public abstract int getRoomID() throws RemoteException;

	public abstract int getPersonCapacity() throws RemoteException;

	public abstract String getRoomName() throws RemoteException;

	public abstract boolean isBookedInPeriod(DateTime start, DateTime end)
			throws RemoteException;

	public abstract void setPersonCapacity(int personCapacity)
			throws RemoteException;

	public abstract void setRoomName(String roomName) throws RemoteException;

	public abstract void delete() throws RemoteException;

}
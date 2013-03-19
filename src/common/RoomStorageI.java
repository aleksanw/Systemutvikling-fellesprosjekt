package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RoomStorageI extends Remote {
	public RoomI create() throws RemoteException;

	public RoomI get(int ID) throws RemoteException;

	public void delete(int ID) throws RemoteException;

	public void delete(RoomI model) throws RemoteException;

	public RoomsI getRoomList() throws RemoteException;
}
package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Room;

public interface RoomStorageI extends Remote {
	public RoomI create() throws RemoteException;
	public RoomI get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Room model) throws RemoteException;
}
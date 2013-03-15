package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Room;

public interface RoomStorageI extends Remote {
	public Room create() throws RemoteException;
	public Room get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Room model) throws RemoteException;
}
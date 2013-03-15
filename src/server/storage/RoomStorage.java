package server.storage;

import java.rmi.RemoteException;
import server.model.Room;
import common.RoomStorageI;

public class RoomStorage extends Storage implements RoomStorageI {
	
	public RoomStorage() throws RemoteException {
		super(Room.class);
	}
	
	public Room create() throws RemoteException {
		return (Room) super.create();
	}
	
	public Room get(int ID) throws RemoteException {
		return (Room) super.get(ID);
	}
	
	public void delete(int ID) throws RemoteException {
		super.delete(ID);
	}
	
	public void delete(Room model) throws RemoteException {
		super.delete(model);
	}
}
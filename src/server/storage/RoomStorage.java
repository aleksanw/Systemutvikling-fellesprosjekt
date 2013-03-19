package server.storage;

import java.rmi.RemoteException;

import server.listModel.Rooms;
import server.model.Room;

import common.RoomI;
import common.RoomStorageI;
import common.RoomsI;

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

	public void delete(RoomI model) throws RemoteException {
		super.delete(model);
	}

	@Override
	public RoomsI getRoomList() throws RemoteException {
		return (RoomsI) new Rooms();
	}
}
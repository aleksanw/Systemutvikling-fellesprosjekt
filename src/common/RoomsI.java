package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Room;

public interface RoomsI extends ListModelI {

	public ArrayList<Room> getList() throws RemoteException;
}

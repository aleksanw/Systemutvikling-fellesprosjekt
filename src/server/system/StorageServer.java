package server.system;

import java.rmi.RemoteException;

import server.model.*;
import server.storage.Storage;

public class StorageServer {
	public void StorageServer() throws RemoteException {
		
		RMIServer rmiServer = new RMIServer();
		
		rmiServer.addObject("EventStorage", new Storage(Event.class));
		rmiServer.addObject("UserStorage", new Storage(User.class));
		rmiServer.addObject("GroupStorage", new Storage(User.class));
		rmiServer.addObject("RoomStorage", new Storage(Room.class));
		rmiServer.addObject("AlarmStorage", new Storage(Alarm.class));
		rmiServer.addObject("InvitationStorage", new Storage(Invitation.class));
	}
}

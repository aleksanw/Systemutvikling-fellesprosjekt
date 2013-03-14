package client.system;

import java.rmi.RemoteException;

import common.StorageI;

// This is just for the dummy server
import server.storage.Storage;
import server.model.*;

public class StorageServerConnection {
	public StorageServerConnection() throws RemoteException {
		/*
		RMIClient server = new RMIClient();
		
		StorageI eventStorage = server.getClass("EventStorage");
		StorageI userStorage = server.getClass("UserStorage");
		StorageI groupStorage = server.getClass("GroupStorage");
		StorageI roomStorage = server.getClass("RoomStorage");
		StorageI alarmStorage = server.getClass("AlarmStorage");
		StorageI invitationStorage = server.getClass("InvitationStorage");
		*/
		
		
		// Dummy server
		StorageI eventStorage = new Storage(Event.class);
		StorageI userStorage = new Storage(User.class);
		StorageI groupStorage = new Storage(Group.class);
		StorageI roomStorage = new Storage(Room.class);
		StorageI alarmStorage = new Storage(Alarm.class);
		StorageI invitationStorage = new Storage(Invitation.class);
	}
}
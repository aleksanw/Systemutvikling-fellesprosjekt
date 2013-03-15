package client.system;

import java.rmi.RemoteException;

import common.*;

// This is just for the dummy server
import server.storage.*;
import server.model.*;

public class DummyStorageServerConnection {
	public EventStorageI eventStorage;
	public UserStorageI userStorage;
	public GroupStorageI groupStorage;
	public RoomStorageI roomStorage;
	public AlarmStorageI alarmStorage;
	public InvitationStorageI invitationStorage;
	
	public DummyStorageServerConnection() throws RemoteException {
		this.eventStorage 		= new EventStorage();
		this.userStorage 		= new UserStorage();
		this.groupStorage 		= new GroupStorage();
		this.roomStorage 		= new RoomStorage();
		this.alarmStorage 		= new AlarmStorage();
		this.invitationStorage 	= new InvitationStorage();
	}
}
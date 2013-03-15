package client.system;

import java.rmi.RemoteException;

import common.*;

public class StorageServerConnection {
	public EventStorageI eventStorage;
	public UserStorageI userStorage;
	public GroupStorageI groupStorage;
	public RoomStorageI roomStorage;
	public AlarmStorageI alarmStorage;
	public InvitationStorageI invitationStorage;
	
	public StorageServerConnection() throws RemoteException {
		RMIClient server = new RMIClient();
		this.eventStorage 		= (EventStorageI) server.getObject("EventStorage");
//		this.userStorage 		= (UserStorageI) server.getObject("UserStorage");
//		this.groupStorage 		= (GroupStorageI) server.getObject("GroupStorage");
//		this.roomStorage 		= (RoomStorageI) server.getObject("RoomStorage");
//		this.alarmStorage 		= (AlarmStorageI) server.getObject("AlarmStorage");
//		this.invitationStorage 	= (InvitationStorageI) server.getObject("InvitationStorage");
	}	
}
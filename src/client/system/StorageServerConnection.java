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
	
	public StorageServerConnection() throws Exception {
		RMIClient server = new RMIClient();
		this.eventStorage 		= (EventStorageI) server.getObject("eventStorage");
		this.userStorage 		= (UserStorageI) server.getObject("userStorage");
		this.groupStorage 		= (GroupStorageI) server.getObject("groupStorage");
		this.roomStorage 		= (RoomStorageI) server.getObject("roomStorage");
		this.alarmStorage 		= (AlarmStorageI) server.getObject("alarmStorage");
		this.invitationStorage 	= (InvitationStorageI) server.getObject("invitationStorage");
	}	
}
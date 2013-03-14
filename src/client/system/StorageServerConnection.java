package client.system;

import java.rmi.RemoteException;

import common.StorageI;

public class StorageServerConnection {
	public StorageI eventStorage;
	public StorageI userStorage;
	public StorageI groupStorage;
	public StorageI roomStorage;
	public StorageI alarmStorage;
	public StorageI invitationStorage;
	
	public StorageServerConnection() throws RemoteException {
		RMIClient server = new RMIClient();
		
		this.eventStorage 		= (StorageI) server.getObject("EventStorage");
		this.userStorage 		= (StorageI) server.getObject("UserStorage");
		this.groupStorage 		= (StorageI) server.getObject("GroupStorage");
		this.roomStorage 		= (StorageI) server.getObject("RoomStorage");
		this.alarmStorage 		= (StorageI) server.getObject("AlarmStorage");
		this.invitationStorage 	= (StorageI) server.getObject("InvitationStorage");
	}
}
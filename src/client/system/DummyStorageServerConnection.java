package client.system;

import java.rmi.RemoteException;

import server.storage.AlarmStorage;
import server.storage.EventStorage;
import server.storage.GroupStorage;
import server.storage.InvitationStorage;
import server.storage.RoomStorage;
import server.storage.UserStorage;

import common.AlarmStorageI;
import common.EventStorageI;
import common.GroupStorageI;
import common.InvitationStorageI;
import common.RoomStorageI;
import common.UserStorageI;
// This is just for the dummy server

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
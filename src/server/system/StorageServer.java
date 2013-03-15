package server.system;

import java.rmi.RemoteException;

import common.AlarmStorageI;
import common.EventStorageI;
import common.GroupStorageI;
import common.InvitationStorageI;
import common.RoomStorageI;
import common.UserStorageI;
import server.model.*;
import server.storage.*;

public class StorageServer {
	public EventStorage eventStorage;
	public UserStorage userStorage;
	public GroupStorage groupStorage;
	public RoomStorage roomStorage;
	public AlarmStorage alarmStorage;
	public InvitationStorage invitationStorage;
	
	public void StorageServer() throws RemoteException {
		
		RMIServer rmiServer = new RMIServer();
		
		this.eventStorage 		= new EventStorage();
		this.userStorage 		= new UserStorage();
		this.groupStorage 		= new GroupStorage();
		this.roomStorage 		= new RoomStorage();
		this.alarmStorage 		= new AlarmStorage();
		this.invitationStorage 	= new InvitationStorage();
		
		rmiServer.addObject("EventStorage", this.eventStorage);
		rmiServer.addObject("UserStorage", this.userStorage);
		rmiServer.addObject("GroupStorage", this.groupStorage);
		rmiServer.addObject("RoomStorage", this.roomStorage);
		rmiServer.addObject("AlarmStorage", this.alarmStorage);
		rmiServer.addObject("InvitationStorage", this.invitationStorage);
	}
}

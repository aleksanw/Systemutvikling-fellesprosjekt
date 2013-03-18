package server.system;

import server.storage.AlarmStorage;
import server.storage.EventStorage;
import server.storage.GroupStorage;
import server.storage.InvitationStorage;
import server.storage.RoomStorage;
import server.storage.UserStorage;

public class StorageServer {
	public static EventStorage eventStorage;
	public static UserStorage userStorage;
	public static GroupStorage groupStorage;
	public static RoomStorage roomStorage;
	public static AlarmStorage alarmStorage;
	public static InvitationStorage invitationStorage;
	
	public StorageServer() throws Exception {
		
		RMIServer rmiServer = new RMIServer();
		
		eventStorage 		= new EventStorage();
		userStorage 		= new UserStorage();
		groupStorage 		= new GroupStorage();
		roomStorage 		= new RoomStorage();
		alarmStorage 		= new AlarmStorage();
		invitationStorage 	= new InvitationStorage();
		
		rmiServer.addObject("eventStorage", eventStorage);
		rmiServer.addObject("userStorage", userStorage);
		rmiServer.addObject("groupStorage", groupStorage);
		rmiServer.addObject("roomStorage", roomStorage);
		rmiServer.addObject("alarmStorage", alarmStorage);
		rmiServer.addObject("invitationStorage", invitationStorage);
	}
}
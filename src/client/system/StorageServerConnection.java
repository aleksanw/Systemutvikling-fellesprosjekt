package client.system;

import common.AlarmStorageI;
import common.EventStorageI;
import common.GroupStorageI;
import common.InvitationStorageI;
import common.RoomStorageI;
import common.UserStorageI;

public class StorageServerConnection {
	private RMIClient server;
	public EventStorageI eventStorage;
	public UserStorageI userStorage;
	public GroupStorageI groupStorage;
	public RoomStorageI roomStorage;
	public AlarmStorageI alarmStorage;
	public InvitationStorageI invitationStorage;

	public StorageServerConnection(String address) {
		if (server == null) {
			server = new RMIClient(address);
		}

		this.eventStorage = (EventStorageI) server.getObject("eventStorage");
		this.userStorage = (UserStorageI) server.getObject("userStorage");
		this.groupStorage = (GroupStorageI) server.getObject("groupStorage");
		this.roomStorage = (RoomStorageI) server.getObject("roomStorage");
		this.alarmStorage = (AlarmStorageI) server.getObject("alarmStorage");
		this.invitationStorage = (InvitationStorageI) server
				.getObject("invitationStorage");
	}

	public StorageServerConnection() {
		this("localhost");
	}
}

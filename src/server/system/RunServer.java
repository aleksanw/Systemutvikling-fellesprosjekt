package server.system;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import client.system.RMIClient;

import server.model.*;
import server.storage.Storage;

public class RunServer {
	public static void main(String[] args) throws RemoteException {
		
		RMIServer rmiServer = new RMIServer();
		
		rmiServer.addObject("EventStorage", new Storage(Event.class));
		rmiServer.addObject("UserStorage", new Storage(User.class));
		rmiServer.addObject("GroupStorage", new Storage(User.class));
		rmiServer.addObject("RoomStorage", new Storage(Room.class));
		rmiServer.addObject("AlarmStorage", new Storage(Alarm.class));
		rmiServer.addObject("InvitationStorage", new Storage(Invitation.class));
	}
}

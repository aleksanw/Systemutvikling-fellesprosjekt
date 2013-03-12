package server.system;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import client.system.RMIClient;

import storage.EventStorage;

public class RunServer {
	public static void main(String[] args) throws RemoteException {
		
		RMIServer rmiServer = new RMIServer();
		
		rmiServer.addObject("EventStorage", new EventStorage());
	}
}

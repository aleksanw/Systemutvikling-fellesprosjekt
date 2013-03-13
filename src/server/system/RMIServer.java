package server.system;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

import storage.EventStorage;

public class RMIServer {
	private static int port = 1099;
	
	public RMIServer() {
		// Initialize Security Manager
		if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }
		
		// Bind to RMI registry 
		try {
			LocateRegistry.createRegistry( port );
		} catch (RemoteException e) {
			System.out.println("RMI Server connection error: Error initializing registry or binding server.");
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("RMI Server Running...");
	}
	
	public void addObject(String name, Remote obj) {
		// Bind to RMI registry 
		try {
			//Naming.rebind("EventStorage", new EventStorage());
			Naming.rebind(name, obj);
			
		} catch (RemoteException e) {
			System.out.println("RMI Server addObject error: Error initializing registry or binding server.");
			System.out.println(e.getMessage());
			System.exit(-1);
		} catch (MalformedURLException e) {
			System.out.println("RMI Server addObject error: Could not bind server to defined registry as the URL was malformed.");
			System.exit(-1);
		}
	}
}

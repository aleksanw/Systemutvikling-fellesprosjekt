package server.system;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class RMIServer {
	private static int port = 1099;
	Registry registry;
	
	/**
	 * Starts RMI Server and starts listen to port 1099
	 * 
	 */
	
	public RMIServer() {
		System.setProperty("java.security.policy","config/openall.policy");
		
		// Initialize Security Manager
		if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }
		
		// Bind to RMI registry 
		try {
			registry = LocateRegistry.createRegistry( port );
		} catch (RemoteException e) {
			System.out.println("RMI Server connection error: Error initializing registry or binding server.");
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		System.out.println("RMI Server Running...");
	}
	
	public void killServer(){
		try {
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (NoSuchObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a remote object to RMI Server
	 * 
	 * Usage eq.
	 * 		server = new RMIServer();
	 * 		server.addObject("EventStorage", new EventStorage());
	 * 
	 * @param name
	 * @param obj
	 */
	
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

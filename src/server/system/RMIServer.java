package server.system;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


/**
 * Make a RMIServer.
 * 	
 * Usage:
 * 		server = new RMIServer();
 * 		server.addObject("EventStorage", new EventStorage());
 * @author jont
 *
 */

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
		if(System.getSecurityManager() == null){
            System.setSecurityManager(new RMISecurityManager());
        }
		
		// Bind to RMI registry 
		try {
			registry = LocateRegistry.createRegistry( port );
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("RMI Server Running. (Should be killed before starting a new one on the same port.)");
	}
	
	public void killServer(){
		try {
			UnicastRemoteObject.unexportObject(registry, true);
		} catch (NoSuchObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Killed RMI Server");
	}
	
	/**
	 * Add a remote object to RMI Server
	 * 
	 * Usage:
	 * 		server = new RMIServer();
	 * 		server.addObject("EventStorage", new EventStorage());
	 * 
	 * @param name
	 * @param obj
	 */
	
	public void addObject(String name, Remote obj) {
		try {
			Naming.rebind(name, obj);
		} catch (RemoteException | MalformedURLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

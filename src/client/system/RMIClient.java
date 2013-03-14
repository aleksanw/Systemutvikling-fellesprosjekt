package client.system;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import common.*;

public class RMIClient {
	private static String server = "localhost:1099";
	//public StorageI eventStorage;
	
	public RMIClient() throws RemoteException {
		System.setProperty("java.security.policy","config/openall.policy");
		
		// Initialize Security Manager
		if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }
		
		//this.eventStorage = (StorageI)getRMIObjectFromServer("EventStorage");
		//System.out.println(eventStorage.getValue());
	}
	
	public Object getObject(String objectname) {
		String urlServer = new String("rmi://" + server + "/" + objectname);

		// Bind to RMIServer
		 try {
			 return (Object)Naming.lookup(urlServer);
		} catch (MalformedURLException e) {
			System.out.println("Errpr: Malformed hostname.");
		} catch (RemoteException e) {
			System.out.println("Error: Remote Exception.");
			System.out.println(e.detail);
		} catch (NotBoundException e) {
			System.out.println("Error: Not Bound Exception.");
		}
		
		return null;
	}
}

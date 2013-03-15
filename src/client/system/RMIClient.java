package client.system;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

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
	
	public Object getObject(String objectname) throws Exception{
		String urlServer = new String("rmi://" + server + "/" + objectname);

		// Bind to RMIServer
		return (Object) Naming.lookup(urlServer);
	}
}

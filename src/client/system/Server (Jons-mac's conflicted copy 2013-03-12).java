package client.system;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import common.ValueModelI;

public class Server {
	private static String server = "localhost:1099";
	private Storage getEventStorage;
	
	public Server() {
		// Initialize Security Manager
		if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }
		
		
	}
	
	private Object getObject(String objectname) {
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
	}
	
	/*
	public login(String username, String password) {
		
	}
	
	
	public getEventStorage() {
		
	}
	
	public getUserStorage() {
		
	}
	
	public getGroupStorage() {
		
	}
	
	public getRoomStorage() {
		
	}
	
	public getAlarmStorage() {
		
	}
	
	
	public getCurrentUser() {
		
	}
	*/
}

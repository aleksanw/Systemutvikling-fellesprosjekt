package common;

import java.rmi.Remote;
import java.rmi.RemoteException;



/**
 * 
 * THIS CLASS IS JUST AN EXAMPLE AND NOT USED IN THE SYSTEM
 * 
 * 
 */
public interface ValueModelI extends Remote {
	public String getValue() throws RemoteException;
	public void setValue(String value) throws RemoteException;
}

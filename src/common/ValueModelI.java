package common;

import java.rmi.Remote;
import java.rmi.RemoteException;



/**
 * 
 * THIS CLASS IS JUST AN EXAMPLE
 * 
 * 
 */
public interface ValueModelI extends Remote {
	public String getValue() throws RemoteException;
	public void setValue(String value) throws RemoteException;
}

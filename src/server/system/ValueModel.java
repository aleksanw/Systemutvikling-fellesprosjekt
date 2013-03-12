package server.system;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;




/**
 * 
 * THIS CLASS IS JUST AN EXAMPLE
 * 
 * 
 */
import common.ValueModelI;

@SuppressWarnings("serial")
public class ValueModel extends UnicastRemoteObject implements ValueModelI {

	protected ValueModel() throws RemoteException {
		this.value = "Hei";
	}
	
	private String value;
	
	public String getValue() throws RemoteException {
		return value;
	}

	public void setValue(String value) throws RemoteException {
		this.value = value;
	}
}
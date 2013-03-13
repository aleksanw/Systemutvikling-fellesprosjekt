package server.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.StorageI;
import common.ValueModelI;

public class EventStorage extends UnicastRemoteObject implements StorageI {
	
	public EventStorage() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	// Just for testing
	public String getValue() {
		return "hei";
	}
}

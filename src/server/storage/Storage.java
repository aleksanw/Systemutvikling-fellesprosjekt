package server.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import common.StorageI;

import server.model.*;

public class Storage extends UnicastRemoteObject implements StorageI {
	private String modelClass;
	
	public Storage(String modelClass) throws RemoteException {
		this.modelClass = modelClass;
	}

	public Model create() throws RemoteException {
		return Class.forName(modelClass).newInstance();
	}

	@Override
	public Model get(int ID) throws RemoteException {
		return Class.forName(modelClass).newInstance(ID);
	}
}

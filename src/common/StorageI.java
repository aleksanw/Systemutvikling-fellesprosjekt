package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Event;
import server.model.Model;

public interface StorageI extends Remote {
	public Model create() throws RemoteException;
	
	public Model get(int ID) throws RemoteException;
}

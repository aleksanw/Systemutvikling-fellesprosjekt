package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Event;


public interface EventStorageI extends Remote {
	public Event create() throws RemoteException;
	public void delete(Event e) throws RemoteException;
}
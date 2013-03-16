package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Event;

public interface EventStorageI extends Remote {
	public EventI create() throws RemoteException;
	public EventI get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Event model) throws RemoteException;
}

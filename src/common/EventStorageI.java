package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.Event;

public interface EventStorageI extends Remote {
	public Event create() throws RemoteException;
	
	public Event get(int eventId);
	public void delete(Event e) throws RemoteException;
}
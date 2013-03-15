package server.storage;

import java.rmi.RemoteException;

import server.model.Event;

import common.EventStorageI;

public class EventStorage extends Storage implements EventStorageI {
	
	public EventStorage() throws RemoteException {
		super(Event.class);
	}
	
	public Event create() throws RemoteException {
		return (Event) super.create();
	}
	
	public Event get(int ID) throws RemoteException {
		return (Event) super.get(ID);
	}
	
	public void delete(int ID) throws RemoteException {
		super.delete(ID);
	}
	
	public void delete(Event model) throws RemoteException {
		super.delete(model);
	}
}
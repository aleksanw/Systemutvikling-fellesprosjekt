package server.storage;

import java.rmi.RemoteException;

import server.model.Event;

import common.EventI;
import common.EventStorageI;

public class EventStorage extends Storage implements EventStorageI {
	
	public EventStorage() throws RemoteException {
		super(Event.class);
	}
	
	public Event create() throws RemoteException {
		return (Event) super.create();
	}
	
	public Event get(int ID) throws RemoteException {
		try {
			return (Event) super.get(ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void delete(int ID) throws RemoteException {
		try {
			super.delete(ID);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(EventI model) throws RemoteException {
		super.delete(model);
	}
}
package server.storage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import server.model.Event;

import common.EventStorageI;
import common.StorageI;
import common.ValueModelI;

public class EventStorage extends UnicastRemoteObject implements EventStorageI, StorageI {
	private Hashtable<Integer, Event> eventsCache;
	
	
	public EventStorage() throws RemoteException {
		eventsCache = new Hashtable<Integer, Event>();
	}

	public Event create() throws RemoteException {
		// TODO Auto-generated method stub
		Event newEvent = new Event();
		Integer eventID = newEvent.getID();
		eventsCache.put(eventID, newEvent);
		return newEvent;
	}
	
	public Event get(int eventID) {
		// TODO Auto-generated method stub
		
		if(eventsCache.containsKey(eventID)) {
			return eventsCache.get(eventID);
		} else {
			// Get from Database, cache in hashtable and return object
			
			// TODO Not implemented
			Event newEvent = new Event(eventID);
			eventsCache.put(eventID, newEvent);
			return newEvent;
		}
		
		return null;
	}

	public void delete(Event e) throws RemoteException {
		
	}
	
	
}

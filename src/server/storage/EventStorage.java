package server.storage;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.listModel.EventList;
import server.model.Event;
import server.model.Group;
import server.model.User;

import common.EventI;
import common.EventStorageI;
import common.WeekI;

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

	public EventList getEventList(ArrayList<User> users,
			ArrayList<Group> groups, WeekI week) throws RemoteException {
		return new EventList(users, groups, week);
	}
}
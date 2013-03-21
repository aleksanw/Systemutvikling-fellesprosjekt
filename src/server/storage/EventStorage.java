package server.storage;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.joda.time.DateTime;

import server.listModel.EventList;
import server.listModel.MeetingsCreatedByUser;
import server.model.Event;

import common.EventI;
import common.EventStorageI;
import common.GroupI;
import common.MeetingsCreatedByUserI;
import common.UserI;

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

	public EventList getEventList(ArrayList<UserI> users,
			ArrayList<GroupI> groups, DateTime date) throws RemoteException {
		return new EventList(users, groups, date);
	}
	
	public MeetingsCreatedByUserI getMeetingsCreatedByUser(UserI user) throws RemoteException {
		return (MeetingsCreatedByUserI) new MeetingsCreatedByUser(user);
	}
}
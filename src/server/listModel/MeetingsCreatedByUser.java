package server.listModel;

import java.rmi.RemoteException;
import java.util.ArrayList;

import common.EventI;
import common.MeetingsCreatedByUserI;
import common.UserI;

public class MeetingsCreatedByUser extends ListModel implements MeetingsCreatedByUserI {
	ArrayList<EventI> list = new ArrayList<EventI>();
	
	private UserI user;

	public MeetingsCreatedByUser(UserI user) throws RemoteException {
		super();
		refresh();
	}

	public ArrayList<EventI> getList() throws RemoteException {
		return list;
	}

	private void refresh() throws RemoteException {
		//ArrayList<Event> oldList = (ArrayList<Event>) list.clone();

		list = user.getCreatedEvents();

		//pcs.firePropertyChange("list", oldList, list);
	}
}

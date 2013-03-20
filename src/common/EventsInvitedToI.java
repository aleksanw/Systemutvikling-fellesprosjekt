package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Event;

public interface EventsInvitedToI {

	public ArrayList<Event> getList() throws RemoteException;

}
package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Event;

public interface MeetingsCreatedByUserI {

	public ArrayList<Event> getList() throws RemoteException;

}
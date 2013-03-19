package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Event;

public interface InvitationListI extends ListModelI {
	public ArrayList<Event> getList() throws RemoteException;
}
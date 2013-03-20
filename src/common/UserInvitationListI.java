package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Event;

public interface UserInvitationListI {

	public ArrayList<Event> getList() throws RemoteException;

}
package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface EventsInvitedToI extends ListModelI {

	public ArrayList<EventI> getEventList() throws RemoteException;
	public ArrayList<InvitationI> getInvitationList() throws RemoteException;

}
package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MeetingsCreatedByUserI extends ListModelI {

	public ArrayList<EventI> getList() throws RemoteException;

}
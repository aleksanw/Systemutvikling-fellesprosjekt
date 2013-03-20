package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Group;

public interface allGroupsListI {

	public ArrayList<Group> getList() throws RemoteException;

}
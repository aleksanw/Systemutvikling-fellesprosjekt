package common;

import java.rmi.RemoteException;
import java.util.ArrayList;

import server.model.Group;

public interface AllGroupsListI {

	public ArrayList<Group> getList() throws RemoteException;

}
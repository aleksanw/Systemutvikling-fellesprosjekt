package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Group;

public interface GroupStorageI extends Remote {
	public GroupI create() throws RemoteException;
	public GroupI get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Group model) throws RemoteException;
}

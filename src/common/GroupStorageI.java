package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Group;

public interface GroupStorageI extends Remote {
	public Group create() throws RemoteException;
	public Group get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Group model) throws RemoteException;
}

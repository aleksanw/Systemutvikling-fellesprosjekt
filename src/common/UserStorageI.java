package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.User;

public interface UserStorageI extends Remote {
	public UserI create() throws RemoteException;
	public UserI get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(User model) throws RemoteException;
}

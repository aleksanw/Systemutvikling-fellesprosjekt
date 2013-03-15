package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.User;

public interface UserStorageI extends Remote {
	public User create() throws RemoteException;
	public User get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(User model) throws RemoteException;
}

package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserStorageI extends Remote {
	public UserI create() throws RemoteException;

	public UserI get(int ID) throws RemoteException;

	public void delete(int ID) throws RemoteException;

	public void delete(UserI model) throws RemoteException;

	public UserListI getUserList(GroupI group) throws RemoteException;
}

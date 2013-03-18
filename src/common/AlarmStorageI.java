package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AlarmStorageI extends Remote {
	public AlarmI create() throws RemoteException;
	public AlarmI get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(AlarmI model) throws RemoteException;
}

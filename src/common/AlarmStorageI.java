package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.model.Alarm;

public interface AlarmStorageI extends Remote {
	public Alarm create() throws RemoteException;
	public Alarm get(int ID) throws RemoteException;
	public void delete(int ID) throws RemoteException;
	public void delete(Alarm model) throws RemoteException;
}

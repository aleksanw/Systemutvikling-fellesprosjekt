package common;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ModelI extends Remote {

	public abstract void delete() throws RemoteException;

	public abstract void addPropartyChangeListener(
			PropertyChangeListener listener) throws RemoteException;

	public abstract void removePropartyChangeListener(
			PropertyChangeListener listener) throws RemoteException;
}
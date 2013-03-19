package common;

import java.beans.PropertyChangeListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ModelI extends Remote {

	public abstract void delete() throws RemoteException, SQLException;

	public abstract void addPropartyChangeListener(
			PropertyChangeListener listener) throws RemoteException;

	public abstract void removePropartyChangeListener(
			PropertyChangeListener listener) throws RemoteException;
}
package server.listModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.ListModelI;

public abstract class ListModel extends UnicastRemoteObject implements
		ListModelI {
	protected PropertyChangeSupport pcs;

	protected ListModel() throws RemoteException {
		pcs = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListner(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

}
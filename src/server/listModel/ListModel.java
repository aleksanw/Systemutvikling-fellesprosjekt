package server.listModel;

import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.ListModelI;

public class ListModel<E> extends UnicastRemoteObject implements
		ListSelectionListener, ListModelI {

	protected ListModel() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private DefaultListModel<E> model;

	public void valueChanged(ListSelectionEvent e) {
		System.out.println("Hei");
	}
}

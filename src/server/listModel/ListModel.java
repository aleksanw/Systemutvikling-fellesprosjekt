package server.listModel;

import java.beans.PropertyChangeSupport;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class ListModel<E> implements ListSelectionListener {

	PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private DefaultListModel<E> model;

	public void valueChanged(ListSelectionEvent e) {
		System.out.println("Hei");
	}
}

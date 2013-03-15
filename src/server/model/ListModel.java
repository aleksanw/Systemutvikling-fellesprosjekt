package server.model;

import java.beans.PropertyChangeSupport;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("unused")
public class ListModel<E> implements ListSelectionListener{
	
	PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private DefaultListModel<E> model;

	public void valueChanged(ListSelectionEvent e) {
		System.out.println("Hei");
	}
}

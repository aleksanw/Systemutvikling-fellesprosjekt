package client.gui;

import java.awt.Component;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import common.EventI;

class EventCellRenderer extends JLabel implements ListCellRenderer {

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		String s;
		try {
			s = ((EventI) value).getEventName();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		setText(s);

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		setOpaque(true);
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		return this;
	}
}

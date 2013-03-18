package client.gui;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import server.model.Room;

public class CellRenderer extends JLabel implements ListCellRenderer{

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		String s = ((Room) value).getRoomName();
		setText(s);
		return this;
	}
}

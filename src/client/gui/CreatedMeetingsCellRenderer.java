package client.gui;

import java.awt.Component;
import java.rmi.RemoteException;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import common.EventI;

public class CreatedMeetingsCellRenderer extends JLabel implements ListCellRenderer {

	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		String s;
		try {
			int numberOfInvites = ((EventI) value).getInvitationList().size();
			int accepted = 0;
			int declined = 0;
			int notAnswered = 0;
			s = "<html>" + ((EventI) value).getEventName();
			s += "<br /> -Invites:           " + numberOfInvites;
			s += "<br /> -Accepted:          " + accepted;
			s += "<br /> -Declined:          " + declined;
			s += "<br /> -Not answered yet : " + notAnswered;
			s += "</html>";
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

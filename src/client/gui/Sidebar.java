package client.gui;

import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

import common.EventI;
import common.UserInvitationListI;

class Sidebar extends JPanel implements ListSelectionListener {

	private JLabel recieved, sent, calenders;
	private JList<String> rList, sList;
	private JScrollPane sScroll, rScroll;

	public Sidebar() {
		DefaultListModel<String> listmodel = new DefaultListModel<String>();
		rList = new JList<String>();
		rList.setFocusable(false);
		rList.setModel(listmodel);
		rList.setOpaque(false);
		rList.addListSelectionListener(this);
		
		UserInvitationListI aEventList;
		try {
			aEventList = MainClass.sServer.invitationStorage.getEventsInvitedTo(MainClass.currentUser);
		} catch (RemoteException e) {
		}
		
		for (EventI event : aEventList.getList()) {
			listmodel.addElement("test" + i);
		}

		sList = new JList<String>();

		rScroll = new JScrollPane(rList);
		rScroll.setBorder(BorderFactory.createEmptyBorder());
		rScroll.setOpaque(false);
		rScroll.getViewport().setOpaque(false);
		sScroll = new JScrollPane(sList);

		recieved = new JLabel("Mottatte Møteinnkallelser");
		sent = new JLabel("Sendte Møteinnkallelser");
		calenders = new JLabel("Kalendre");

		setLayout(new MigLayout("wrap 1"));
		add(recieved);
		add(rScroll, "growx");
		add(sent);
		add(sScroll, "growx");
		add(calenders);

		// setPreferredSize(new Dimension(250,600));
	}

	public void valueChanged(ListSelectionEvent arg0) {

	}
}

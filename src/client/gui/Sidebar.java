package client.gui;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
import common.EventsInvitedToI;
import common.InvitationI;
import common.MeetingsCreatedByUserI;

class Sidebar extends JPanel {

	private JLabel recieved, sent, calenders;
	private JList<EventI> sList;
	private JList<InvitationI> rList;
	private JScrollPane sScroll, rScroll;
	EventsInvitedToI evtList;
	ArrayList<InvitationI> invList;
	MeetingsCreatedByUserI createdEvents;
	ArrayList<EventI> createdMeetingsList;

	public Sidebar() {
		DefaultListModel<InvitationI> listmodel = new DefaultListModel<InvitationI>();
		DefaultListModel<EventI> eventListModel = new DefaultListModel<EventI>();
		rList = new JList<InvitationI>(listmodel);
		rList.setCellRenderer(new InvitationsCellRenderer());
		rList.setFocusable(false);
//		rList.setModel(listmodel);
		rList.setOpaque(false);
		rList.addListSelectionListener(new rListener());
		
		sList = new JList<EventI>(eventListModel);
		sList.setCellRenderer(new CreatedMeetingsCellRenderer());
		sList.setFocusable(false);
		sList.setOpaque(false);
		sList.addListSelectionListener(new sListener ());
		
		try {
			evtList = MainClass.sServer.invitationStorage.getEventsInvitedTo(MainClass.currentUser);
			invList = evtList.getInvitationList();
			createdEvents = (MeetingsCreatedByUserI) MainClass.sServer.eventStorage.getMeetingsCreatedByUser(MainClass.currentUser);
			createdMeetingsList = createdEvents.getList();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		makeRList(listmodel);
		
		for (int i = 0; i < createdMeetingsList.size(); i++) {
			eventListModel.addElement(createdMeetingsList.get(i));
		}
		
		/*
		EventsInvitedToI eventList;
		try {
			eventList = MainClass.sServer.invitationStorage.getEventsInvitedTo(MainClass.currentUser);
		
			for (InvitationI invitation : eventList.getInvitationList()) {
				//listmodel.addElement(invitation.getEvent().getEventName());
				//System.out.println(invitation.getEvent().getEventName());
				
				listmodel.addElement("test" + i);
			}
		} catch (RemoteException e) {
			System.out.println("RemoteExceptionerror");
		}
		/**/


		rScroll = new JScrollPane(rList);	
		rScroll.setBorder(BorderFactory.createEmptyBorder());
		rScroll.setOpaque(false);
		//rScroll.setSize(new Dimension(250, 180));
		rScroll.getViewport().setOpaque(false);
		
		sScroll = new JScrollPane(sList);
		sScroll.setBorder(BorderFactory.createEmptyBorder());
		sScroll.setOpaque(false);
		//sScroll.setSize(new Dimension(250, 360));
		sScroll.getViewport().setOpaque(false);

		recieved = new JLabel("Mottatte Møteinnkallelser");
		sent = new JLabel("Sendte Møteinnkallelser");
		calenders = new JLabel("Kalendre");

		setLayout(new MigLayout("wrap 1"));
		add(recieved);
		add(rScroll, "w 200:250:300, h 90:180:360");
		add(sent);
		add(sScroll, "w 200:250:300, h 180:360:540");
		add(calenders);

		// setPreferredSize(new Dimension(250,600));
	}

	private void makeRList(DefaultListModel<InvitationI> listmodel) {
		for (int i = 0; i < invList.size(); i++) {
			try {
				if(invList.get(i).isAttending() == null)
					listmodel.addElement(invList.get(i));
				else if(invList.get(i).isAttending())
					listmodel.addElement(invList.get(i));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
	}

	public class rListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			MainClass.runAnswerMeeting(rList.getSelectedValue());
		}
	}
	
	public class sListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			MainClass.runChangeMeeting(sList.getSelectedValue());
		}
	}
}

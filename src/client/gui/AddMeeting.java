package client.gui;

import java.awt.GridBagConstraints;
import java.rmi.RemoteException;
import java.util.ArrayList;

import common.EventI;
import common.UserI;

class AddMeeting extends AddEvent {

	private Participants part;

	public AddMeeting() {
		super();
		remove(allDay);
		remove(setAlarm);
		remove(lAlarm);
		remove(lAllDay);
		remove(vis);
		remove(visible);

		part = new Participants();

		g.fill = GridBagConstraints.EAST;

		g.gridx = 9;
		g.gridy = 1;
		g.gridheight = 8;
		add(part, g);
	}
	
	public void setEvent(EventI event) throws RemoteException {
		super.setEvent(event);
		ArrayList<UserI> users  = new ArrayList<UserI>();
		if(event != null) {
			for(int i = 0; i < event.getInvitationList().size(); i++ )
				users.add((UserI) event.getInvitationList().get(i));
		}
		part.setAddedUsers(users);
		part.setEvent(event);
	}
	
	public EventI getEvent() {
		return super.getEvent();
	}
}

package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Model;
import server.model.User;
import server.system.StorageServer;

import common.EventI;
import common.EventsInvitedToI;
import common.InvitationI;

public class EventsInvitedTo extends ListModel implements EventsInvitedToI {
	ArrayList<EventI> events = new ArrayList<EventI>();
	ArrayList<InvitationI> invites = new ArrayList<InvitationI>();
	int userID;

	public EventsInvitedTo(User user) throws RemoteException {
		this.userID = user.getUserID();
		refresh();
	}

	public ArrayList<EventI> getEventList() throws RemoteException {
		return events;
	}
	
	public ArrayList<InvitationI> getInvitationList() throws RemoteException {
		return invites;
	}

	private void refresh() throws RemoteException {
		//ArrayList<Event> oldList = (ArrayList<Event>) list.clone();

		events = new ArrayList<EventI>();

		String query = "SELECT * FROM InvitedTo natural join User where userID="
				+ userID + ";";

		events = new ArrayList<EventI>();
		ResultSet result = Model.getDB().readQuery(query);
		try {
			while (result.next()) {
				this.events.add(StorageServer.eventStorage.get(result
						.getInt("eventID")));
				this.invites.add(StorageServer.invitationStorage.get(result
						.getInt("invitedToID")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		//pcs.firePropertyChange("list", oldList, list);
	}
}

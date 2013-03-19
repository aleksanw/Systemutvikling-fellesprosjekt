package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Event;
import server.model.Model;
import server.model.User;
import server.system.StorageServer;

import common.InvitationListI;

public class InvitationList extends ListModel implements InvitationListI {
	ArrayList<Event> list = new ArrayList<Event>();
	int userID;

	public InvitationList(User user) throws RemoteException {
		int userID = user.getUserID();
		refresh();
	}

	public ArrayList<Event> getList() throws RemoteException {
		return list;
	}

	private void refresh() throws RemoteException {
		ArrayList<Event> oldList = (ArrayList<Event>) list.clone();

		String query = "SELECT * FROM InvitedTo natural join User where userID="
				+ userID + ";";
		ResultSet result = Model.getDB().readQuery(query);
		try {
			while (result.next()) {
				this.list.add(StorageServer.eventStorage.get(result
						.getInt("eventID")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		pcs.firePropertyChange("list", oldList, list);
	}
}

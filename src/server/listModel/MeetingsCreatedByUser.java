package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;

import server.model.Event;
import server.model.Model;
import server.model.User;
import server.system.StorageServer;

public class MeetingsCreatedByUser extends ListModel {
	ArrayList<Event> list = new ArrayList<Event>();
	private User user;

	public MeetingsCreatedByUser(User user) throws RemoteException {
		super();
		refresh();
	}

	public ArrayList<Event> getList() throws RemoteException {
		return list;
	}

	private void refresh() {
		ArrayList<Event> oldList = (ArrayList<Event>)list.clone();
		
		list = new ArrayList<Event>();
		
		String query = "SELECT * FROM Event WHERE isMeeting=1 AND createdByUser=" + user.getUserID();
		ResultSet result;
		try {
			result = Model.getDB().readQuery(query);
			while (result.next()) {
				this.list.add(StorageServer.eventStorage.get(result
						.getInt("eventID")));
			}

		} catch (RemoteException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		pcs.firePropertyChange("list", oldList, list);
	}
}

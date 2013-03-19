package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Event;
import server.model.Model;
import server.model.User;
import server.system.StorageServer;

public class Invitations extends ListModel {
	ArrayList<Event> invites = new ArrayList<Event>();
	
	public static void main(String[] args) throws RemoteException, SQLException {
		Invitations i = new Invitations(new User(1));
		ArrayList<Event> x = i.getList();
		for(int y = 0; y< x.size() ; y++) {
			System.out.println(x.get(y));
		}
	}

	public Invitations(User user) throws SQLException, RemoteException {
		int userID = user.getUserID();
		String query = "SELECT * FROM InvitedTo natural join User where userID="+ userID +";";
		ResultSet result = Model.getDB().readQuery(query);
		while(result.next()) {
			System.out.println(result.getInt("eventID"));
			this.invites.add(StorageServer.eventStorage.get(result.getInt("eventID")));
		}
	}
	
	public ArrayList<Event> getList() throws RemoteException{
		return invites;
	}
}

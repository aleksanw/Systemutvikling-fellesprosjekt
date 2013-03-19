package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Group;
import server.model.Model;
import server.model.User;
import server.system.StorageServer;

public class Users extends ListModel {
	ArrayList<User> users = new ArrayList<User>();
	int groupID;

	public Users(Group group) throws SQLException, RemoteException {
		super();
		groupID = group.getGroupID();
		refresh();
	}

	public ArrayList<User> getList() {
		return users;
	}

	public void refresh() throws RemoteException {
		String query = "SELECT userID FROM memberOfGroup, Groups WHERE Group."
				+ groupID + "=memberOfGroup." + groupID + ";";
		ResultSet result = Model.getDB().readQuery(query);
		try {
			while (result.next()) {
				this.users.add(StorageServer.userStorage.get(result
						.getInt("userID")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}

package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Model;
import server.model.User;
import server.system.StorageServer;

import common.GroupI;
import common.UserListI;

public class UserList extends ListModel implements UserListI {
	ArrayList<User> list = new ArrayList<User>();
	int groupID;

	public UserList(GroupI group) throws RemoteException {
		super();
		groupID = group.getGroupID();
		refresh();
	}

	public ArrayList<User> getList() {
		return list;
	}

	private void refresh() throws RemoteException {
		ArrayList<User> oldList = (ArrayList<User>) list.clone();

		String query = "SELECT userID FROM memberOfGroup, Groups WHERE Group."
				+ groupID + "=memberOfGroup." + groupID + ";";
		ResultSet result = Model.getDB().readQuery(query);
		try {
			while (result.next()) {
				this.list.add(StorageServer.userStorage.get(result
						.getInt("userID")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		pcs.firePropertyChange("list", oldList, list);
	}
}
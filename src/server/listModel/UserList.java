package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Model;
import server.system.StorageServer;

import common.GroupI;
import common.UserI;
import common.UserListI;

public class UserList extends ListModel implements UserListI {
	ArrayList<UserI> list = new ArrayList<UserI>();
	int groupID;

	public UserList(GroupI group) throws RemoteException {
		super();
		groupID = group.getGroupID();
		refresh();
	}

	public ArrayList<UserI> getList() {
		return list;
	}

	private void refresh() throws RemoteException {
		ArrayList<UserI> oldList = (ArrayList<UserI>) list.clone();

		list = new ArrayList<UserI>();

		String query = "SELECT userID FROM memberOfGroup natural join Groups WHERE groupID="
				+ groupID + ";";

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
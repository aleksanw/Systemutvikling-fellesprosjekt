package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Group;
import server.model.Model;
import server.model.User;
import server.storage.UserStorage;
import server.system.StorageServer;

public class Users extends ListModel {
	ArrayList<User> users = new ArrayList<User>();
	
	public Users(Group group, UserStorage storage) throws SQLException, RemoteException {
		int groupID = group.getGroupID();
		String query = "SELECT userID FROM memberOfGroup, Groups WHERE Group." + groupID + "=memberOfGroup." + groupID + ";";
		ResultSet result = Model.getDB().readQuery(query);
		while(result.next()) {
			this.users.add(StorageServer.userStorage.get(result.getInt("userID")));
		}
	}
	
	public ArrayList<User> getList() {
		return users;
	}
}

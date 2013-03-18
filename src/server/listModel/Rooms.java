package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Group;
import server.model.Model;
import server.model.Room;
import server.model.User;
import server.storage.RoomStorage;
import server.storage.UserStorage;

public class Rooms extends ListModel {
ArrayList<Room> rooms = new ArrayList<Room>();
	
	public Rooms(RoomStorage storage) throws SQLException, RemoteException {
		String query = "SELECT roomID FROM Rooms WHERE Group." + groupID + "=memberOfGroup." + groupID + ";";
		ResultSet result = Model.getDB().readQuery(query);
		while(result.next()) {
			this.users.add(storage.get(result.getInt("userID")));
		}
	}
	
	public ArrayList<User> getList() {
		return users;
	}
}

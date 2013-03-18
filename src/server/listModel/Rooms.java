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
	
	public Rooms() throws SQLException, RemoteException {
		String query = "SELECT roomID FROM Rooms;";
		ResultSet result = Model.getDB().readQuery(query);
		while(result.next()) {
			this.rooms.add(StorageServer.roomStorage.get(result.getInt("roomID")));
		}
	}
	
	public ArrayList<Room> getList() throws RemoteException{
		return rooms;
	}
}

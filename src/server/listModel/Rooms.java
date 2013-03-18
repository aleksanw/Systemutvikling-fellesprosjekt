package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Model;
import server.model.Room;
import server.model.User;
import server.storage.RoomStorage;
import server.storage.UserStorage;
import server.system.StorageServer;

public class Rooms extends ListModel {
ArrayList<Room> rooms = new ArrayList<Room>();

	public static void main(String[] args) throws Exception {
		new StorageServer();
		Rooms x = new Rooms();
		System.out.println(x.getList());
	}
	
	public Rooms() throws SQLException, RemoteException {
		String query = "SELECT roomID FROM Room;";
		ResultSet result = Model.getDB().readQuery(query);
		while(result.next()) {
			this.rooms.add(StorageServer.roomStorage.get(result.getInt("roomID")));
		}
	}
	
	public ArrayList<Room> getList() throws RemoteException{
		return rooms;
	}
}

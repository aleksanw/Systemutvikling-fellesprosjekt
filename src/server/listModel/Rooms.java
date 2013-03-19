package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import server.model.Model;
import server.model.Room;
import server.system.StorageServer;

class Rooms extends ListModel {
	ArrayList<Room> rooms = new ArrayList<Room>();

	public Rooms() {
		String query = "SELECT roomID FROM Room;";
		ResultSet result;
		try {
			result = Model.getDB().readQuery(query);

			while (result.next()) {
				this.rooms.add(StorageServer.roomStorage.get(result
						.getInt("roomID")));
			}

		} catch (RemoteException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Room> getList() {
		return rooms;
	}
}

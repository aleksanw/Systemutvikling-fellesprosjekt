package server.listModel;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.FireableAlarmsForUserI;

import server.model.Alarm;
import server.model.Model;
import server.model.User;
import server.system.StorageServer;

public class FireableAlarmsforUser extends ListModel implements FireableAlarmsForUserI {
	private ArrayList<Alarm> list = new ArrayList<Alarm>();
	private User user;

	public FireableAlarmsforUser(User user) throws RemoteException {
		super();
		refresh();
	}

	public ArrayList<Alarm> getList() throws RemoteException {
		return list;
	}

	private void refresh() {
		ArrayList<Alarm> oldList = (ArrayList<Alarm>) list.clone();

		list = new ArrayList<Alarm>();

		String query = "SELECT alarmID FROM Alarm JOIN Event USING(eventID) WHERE userID="
				+ user.getUserID()
				+ " AND start-numberOfHoursBeforeMeeting > NOW()";
		ResultSet result;
		try {
			result = Model.getDB().readQuery(query);
			while (result.next()) {
				this.list.add(StorageServer.alarmStorage.get(result
						.getInt("alarmID")));
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		pcs.firePropertyChange("list", oldList, list);
	}
}

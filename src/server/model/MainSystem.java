package server.model;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.joda.time.DateTime;

import common.EventI;

public class MainSystem {
	
	
	public static void main(String[] args) throws SQLException, RemoteException {
		User a = new User(1);
		//DateTime dt = new DateTime(2014, 11, 20, 12, 15, 0, 0);
		//DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		System.out.println(a.getCreatedEvents());
	}
}

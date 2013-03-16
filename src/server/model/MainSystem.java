package server.model;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.joda.time.DateTime;

import common.EventI;

public class MainSystem {
	
	
	public static void main(String[] args) throws SQLException, RemoteException {
		
<<<<<<< HEAD
		Event a = new Event(2);
=======
		EventI a = new Event();
		a.setEventName("Masse kake i dage");
		a.setStart(new DateTime(2013,03,14,13,37,50,003));
		a.setWholeDay(true);
>>>>>>> Add remote interface for all remote objects
		//DateTime dt = new DateTime(2014, 11, 20, 12, 15, 0, 0);
		//DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		System.out.println(a.getEventName());
	}
}

package server.model;

import java.sql.SQLException;

import org.joda.time.DateTime;

public class MainSystem {
	
	
	public static void main(String[] args) throws SQLException {
		
		Event a = new Event();
		a.setEventName("Masse kake i dage");
		a.setStart(new DateTime(2013,03,14,13,37,50,003));
		a.setWholeDay(true);
		//DateTime dt = new DateTime(2014, 11, 20, 12, 15, 0, 0);
		//DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		System.out.println(a.getEventID());
	}
}

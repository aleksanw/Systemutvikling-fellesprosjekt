package model;

import java.sql.SQLException;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MainSystem {
	
	
	public static void main(String[] args) throws SQLException {
		User x = new User("Akkernnnn2", "AkilsPassord", "Akil");
		DateTime dt = new DateTime(2014, 11, 20, 12, 15, 0, 0);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:SS");
		System.out.println(x.getTableFields().toString());
	}
}
